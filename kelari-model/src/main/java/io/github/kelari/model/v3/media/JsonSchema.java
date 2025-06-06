package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a JSON Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code JsonSchema} class extends {@link Schema} to support arbitrary types
 * compliant with the OpenAPI specification. It resolves types from a set of declared types and
 * supports casting arbitrary objects into appropriate types such as {@link Integer}, {@link Long},
 * or {@link Boolean}, based on the resolved type.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = resolved based on the types set</li>
 *   <li>{@code format} = inferred based on type</li>
 * </ul>
 * </p>
 *
 * <p><strong>Casting Behavior:</strong></p>
 * <p>
 * The {@code cast(Object)} method attempts to convert any object into a valid type. If the value
 * resolves to "number", it is cast to either {@link Integer} or {@link Long} based on its range.
 * If the value resolves to "boolean", it is parsed as a {@link Boolean}.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * JsonSchema jsonSchema = new JsonSchema();
 * jsonSchema._default("value")
 *           .addEnumItem("item1")
 *           .addEnumItem("item2");
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * schema:
 *   type: object
 *   additionalProperties: true
 *   default: "value"
 *   enum:
 *     - "item1"
 *     - "item2"
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<[]>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#data-types">OpenAPI 3.0.1 – Data Types</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonSchema  extends Schema<Object>{

    private static final Logger LOGGER = Logger.getLogger(JsonSchema.class.getName());

    /**
     * Set of types that are treated as numeric: "integer" and "number".
     */
    private static final Set<String> NUMBER_TYPES = new HashSet<>(Arrays.asList("integer", "number"));

    /**
     * Resolves the effective schema type based on the values defined in the {@code types} field.
     * <p>
     * When only one type is defined, it returns that type, except for numeric types
     * which are normalized to "number". If multiple types are present, it prioritizes
     * commonly used types: object, string, array, number, boolean.
     * </p>
     *
     * @return the resolved type as a {@link String}; defaults to "null" if types are not defined.
     */
    private String resolveType() {
        Set<String> types = this.getTypes();
        if (types == null || types.isEmpty())
            return "null";
        if (types.size() == 1) {
            String type = types.iterator().next();
            return NUMBER_TYPES.contains(type) ? "number" : type;
        }
        if (types.contains("object")) return "object";
        if (types.contains("string")) return "string";
        if (types.contains("array")) return "array";
        if (types.contains("integer") || types.contains("number")) return "number";
        if (types.contains("boolean")) return "boolean";

        return types.iterator().next();
    }

    /**
     * Attempts to cast the provided value to the appropriate Java type based on the resolved schema type.
     * <p>
     * Supports casting from {@link String} to {@link Integer}, {@link Long}, or {@link Boolean} as applicable.
     * If the value is not parsable or if an exception occurs, the original value is returned.
     * </p>
     *
     * @param value the value to cast
     * @return the casted value if possible; otherwise, the original value
     */
    protected Object cast(Object value) {
        if (Objects.isNull(value))
            return null;
        if (value instanceof String) {
            if (resolveType().equals("number")) {
                try {
                    Number casted = NumberFormat.getInstance().parse(value.toString());
                    if (OpenApiPredicates.IS_WITHIN_INTEGER_RANGE.test(casted))
                        return Integer.parseInt(value.toString());
                    else
                        return Long.parseLong(value.toString());
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                    return value;
                }
            } else if (resolveType().equals("boolean"))
                return Boolean.parseBoolean(value.toString());
        }
        return value;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Returns a string representation of the object with indentation.
     *
     * @return a formatted string representing this {@code JsonSchema}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JsonSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
