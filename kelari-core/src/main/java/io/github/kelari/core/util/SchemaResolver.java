package io.github.kelari.core.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.kelari.model.v3.media.MediaType;
import io.github.kelari.model.v3.media.Schema;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.operations.Operation;
import io.github.kelari.model.v3.paths.PathItem;
import io.github.kelari.model.v3.responses.ApiResponse;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Resolves and retrieves schemas from an OpenAPI definition.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public class SchemaResolver {

    private static final Logger LOGGER = Logger.getLogger(SchemaResolver.class.getName());
    private final ObjectMapper mapper = new ObjectMapper();
    private final OpenAPI openAPI;

    /**
     * Creates a new instance of SchemaResolver.
     *
     * @param openAPI the OpenAPI object containing the schema definitions
     */
    public SchemaResolver(OpenAPI openAPI) {
        this.openAPI = openAPI;
    }

    /**
     * Resolves a schema from the OpenAPI components section.
     *
     * @param schemaName the name of the schema to resolve
     * @return an Optional containing the resolved Schema, or empty if not found
     */
    public Optional<Schema> resolveSchema(String schemaName) {
        if (openAPI.getComponents() != null && openAPI.getComponents().getSchemas() != null) {
            Map<String, Schema> schemas = openAPI.getComponents().getSchemas();
            return Optional.ofNullable(schemas.get(schemaName));
        }
        return Optional.empty();
    }

    /**
     * Resolves a schema from a PathItem based on an operation (like GET, POST).
     *
     * @param path the path for the operation (e.g., "/users")
     * @param operation the operation (e.g., "get", "post")
     * @return the resolved schema as a JsonNode, or null if not found
     */
    public JsonNode resolveSchemaFromPath(String path, String operation) {
        Optional<PathItem> pathItem = Optional.ofNullable(openAPI.getPaths())
                .map(paths -> paths.get(path));

        if (pathItem.isEmpty()) {
            LOGGER.warning("Path not found: " + path);
            return null;
        }

        switch (operation.toLowerCase()) {
            case "get":
                return resolveResponseSchema(pathItem.get().getGet());
            case "post":
                return resolveResponseSchema(pathItem.get().getPost());
            case "put":
                return resolveResponseSchema(pathItem.get().getPut());
            case "delete":
                return resolveResponseSchema(pathItem.get().getDelete());
            case "patch":
                return resolveResponseSchema(pathItem.get().getPatch());
            case "head":
                return resolveResponseSchema(pathItem.get().getHead());
            case "options":
                return resolveResponseSchema(pathItem.get().getOptions());
            case "trace":
                return resolveResponseSchema(pathItem.get().getTrace());
            default:
                LOGGER.warning("Unsupported HTTP operation: " + operation);
                return null;
        }
    }


    private JsonNode resolveResponseSchema(Operation operation) {
        if (operation != null && operation.getResponses() != null) {
            return operation.getResponses().values().stream()
                    .filter(Objects::nonNull)
                    .map(ApiResponse::getContent)
                    .filter(Objects::nonNull)
                    .flatMap(content -> content.values().stream())
                    .map(MediaType::getSchema)
                    .filter(Objects::nonNull)
                    .map(this::convertToJsonNode)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Converts a Schema object into a JsonNode.
     *
     * @param schema the Schema object to convert
     * @return the converted JsonNode
     */
    public JsonNode convertToJsonNode(Schema schema) {
        if (schema == null)
            return null;

        ObjectNode node = mapper.createObjectNode();

        if (schema.get$ref() != null) {
            node.put("$ref", schema.get$ref());
            return node;
        }

        if (schema.getType() != null)
            node.put("type", schema.getType());
        if (schema.getFormat() != null)
            node.put("format", schema.getFormat());
        if (schema.getDescription() != null)
            node.put("description", schema.getDescription());

        if (schema.getProperties() != null && schema.getProperties() instanceof Map) {
            ObjectNode propertiesNode = mapper.createObjectNode();
            Map<?, ?> rawProperties = (Map<?, ?>) schema.getProperties();
            for (Map.Entry<?, ?> entry : rawProperties.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key instanceof String && value instanceof Schema)
                    propertiesNode.set((String) key, convertToJsonNode((Schema) value));
                else
                    LOGGER.warning("Invalid property type: key=" + key + ", value=" + value);
            }
            node.set("properties", propertiesNode);
        }

        if (schema.getItems() != null)
            node.set("items", convertToJsonNode(schema.getItems()));

        Object additionalProperties = schema.getAdditionalProperties();
        if (additionalProperties instanceof Schema)
            node.set("additionalProperties", convertToJsonNode((Schema) additionalProperties));
        else if (additionalProperties instanceof Boolean)
            node.put("additionalProperties", (Boolean) additionalProperties);

        if (schema.get_enum() != null && !schema.get_enum().isEmpty())
            node.set("enum", mapper.valueToTree(schema.get_enum()));

        return node;
    }
}