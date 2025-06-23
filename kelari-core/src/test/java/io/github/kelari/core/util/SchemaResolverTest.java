package io.github.kelari.core.util;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.media.Content;
import io.github.kelari.model.v3.media.MediaType;
import io.github.kelari.model.v3.media.Schema;
import io.github.kelari.model.v3.operations.Operation;
import io.github.kelari.model.v3.paths.PathItem;
import io.github.kelari.model.v3.paths.Paths;
import io.github.kelari.model.v3.responses.ApiResponse;
import io.github.kelari.model.v3.responses.ApiResponses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SchemaResolverTest {

    private OpenAPI openAPI;
    private SchemaResolver resolver;

    @BeforeEach
    void setup() {
        openAPI = new OpenAPI();
        resolver = new SchemaResolver(openAPI);
    }

    @Test
    void shouldResolveSchemaFromPathAndGetOperation() {
        // Arrange
        String path = "/pets";
        String type = "get";

        Schema schema = new Schema();
        schema.setType("object");

        MediaType mediaType = new MediaType();
        mediaType.setSchema(schema);

        Content content = new Content();
        content.put("application/json", mediaType);

        ApiResponse response = new ApiResponse();
        response.setContent(content);

        ApiResponses responses = new ApiResponses();
        responses.put("200", response);

        Operation operation = new Operation();
        operation.setResponses(responses);

        PathItem pathItem = new PathItem();
        pathItem.setGet(operation);

        Map<String, PathItem> map = new LinkedHashMap<>();
        map.put("/pets", pathItem);

        Paths paths = new Paths();
        paths.putAll(map);
        openAPI.setPaths(paths);

        // Act
        JsonNode result = resolver.resolveSchemaFromPath(path, type);

        // Assert
        assertNotNull(result);
        assertEquals("object", result.get("type").asText());
    }

    @Test
    void shouldReturnNullForUnsupportedOperation() {
        JsonNode result = resolver.resolveSchemaFromPath("/pets", "invalidOp");
        assertNull(result);
    }

    @Test
    void shouldConvertSimpleSchemaToJsonNode() {
        Schema schema = new Schema();
        schema.setType("string");
        schema.setFormat("uuid");
        schema.setDescription("Unique identifier");

        JsonNode node = resolver.convertToJsonNode(schema);

        assertNotNull(node);
        assertEquals("string", node.get("type").asText());
        assertEquals("uuid", node.get("format").asText());
        assertEquals("Unique identifier", node.get("description").asText());
    }

    @Test
    void shouldHandleSchemaWithEnum() {
        Schema schema = new Schema();
        schema.setType("string");
        schema.set_enum(Arrays.asList("A", "B", "C"));

        JsonNode node = resolver.convertToJsonNode(schema);

        assertNotNull(node.get("enum"));
        assertTrue(node.get("enum").isArray());
        assertEquals("A", node.get("enum").get(0).asText());
    }

    @Test
    void shouldReturnNullForNullSchema() {
        assertNull(resolver.convertToJsonNode(null));
    }
}
