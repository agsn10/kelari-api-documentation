package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

/**
 * Represents a Map Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code MapSchema} class extends {@link Schema} to represent a schema that
 * describes an object of arbitrary key-value pairs. The keys are expected to be strings,
 * and the values can be of any type that can be specified in the OpenAPI schema.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = "object"</li>
 *   <li>{@code additionalProperties} = null</li>
 * </ul>
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * MapSchema mapSchema = new MapSchema();
 * mapSchema.type("object");
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * schema:
 *   type: object
 *   additionalProperties: true
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#data-types">OpenAPI 3.0.1 – Data Types</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MapSchema extends Schema<Object> {

    /**
     * Constructs a new {@code MapSchema} with default values.
     * <p>
     * The schema type is set to "object" and additional properties are set to null.
     * </p>
     */
    public MapSchema() {
        super("object", null);
    }

    /**
     * Sets the type of this schema.
     *
     * @param type The type to be set (e.g., "object", "array", etc.).
     * @return This {@code MapSchema} object for method chaining.
     */
    @Override
    public MapSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Checks if this {@code MapSchema} is equal to another object.
     * This method delegates the equality check to the superclass.
     *
     * @param object The object to be compared with this schema.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Returns the hash code for this {@code MapSchema}.
     * This method delegates the hash code generation to the superclass.
     *
     * @return The hash code for this schema.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Returns a string representation of this {@code MapSchema}.
     *
     * @return A string representation of the schema, including its type and other properties.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MapSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}