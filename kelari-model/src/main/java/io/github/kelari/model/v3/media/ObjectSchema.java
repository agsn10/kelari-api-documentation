package io.github.kelari.model.v3.media;

import java.util.Objects;

/**
 * Represents an Object Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code ObjectSchema} class extends {@link Schema} to represent a schema for object-based values,
 * as defined in the OpenAPI specification. This schema allows setting default values, examples, and casting
 * arbitrary objects into the specified type.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = "object"</li>
 *   <li>{@code format} = {@code null}</li>
 * </ul>
 * </p>
 *
 * <p><strong>Customization:</strong></p>
 * <p>
 * The {@code example(Object)} method allows setting an example value for the schema.
 * </p>
 *
 * <p><strong>Casting Behavior:</strong></p>
 * <p>
 * The {@code cast(Object)} method simply returns the given value, as this schema type is for generic object data.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * ObjectSchema objectSchema = new ObjectSchema();
 * objectSchema.example("Sample Example");
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * schema:
 *   type: object
 *   example: "Sample Example"
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#data-types">OpenAPI 3.0.1 – Data Types</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public class ObjectSchema extends Schema<Object> {

    /**
     * Constructs a new {@code ObjectSchema} with default values.
     * <p>
     * The schema type is set to "object" and the format is set to {@code null}.
     * </p>
     */
    public ObjectSchema() {
        super("object", null);
    }

    /**
     * Sets the type of this schema.
     *
     * @param type The type to be set (e.g., "object").
     * @return This {@code ObjectSchema} object for method chaining.
     */
    @Override
    public ObjectSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets an example value for this schema.
     *
     * @param example The example value to be set for this schema. If the example is non-null, it will
     *                be converted to a string and set as the example.
     * @return This {@code ObjectSchema} object for method chaining.
     */
    @Override
    public ObjectSchema example(Object example) {
        if (Objects.nonNull(example)) {
            super.setExample(example.toString());
        } else {
            super.setExample(example);
        }
        return this;
    }

    /**
     * Casts an object to the specified schema type.
     * <p>
     * Since this is a generic object schema, this method simply returns the input value.
     * </p>
     *
     * @param value The object to be cast to the schema type.
     * @return The same object that was passed as input.
     */
    @Override
    protected Object cast(Object value) {
        return value;
    }

    /**
     * Checks if this {@code ObjectSchema} is equal to another object.
     * <p>
     * This method compares the current schema to another object for equality.
     * </p>
     *
     * @param object The object to be compared with this schema.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Computes the hash code for this {@code ObjectSchema}.
     * <p>
     * This method delegates the hash code generation to the superclass and includes additional properties.
     * </p>
     *
     * @return The hash code for this schema.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Returns a string representation of this {@code ObjectSchema}.
     * <p>
     * This method provides a string representation of the schema, including its type and other properties.
     * </p>
     *
     * @return A string representation of the schema.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ObjectSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}