package io.github.kelari.model.v3.media;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a UUID Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code UUIDSchema} class extends {@link Schema} to represent a schema for UUID values.
 * It supports setting default values, enumeration items, and provides a method to cast arbitrary objects into {@code UUID} values.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = "string"</li>
 *   <li>{@code format} = "uuid"</li>
 *   <li>{@code enum} = null (can be set using {@code _enum(List<UUID>)} or {@code addEnumItem(UUID)})</li>
 * </ul>
 * </p>
 *
 * <p><strong>Customization:</strong></p>
 * <p>
 * The {@code _default(UUID)} and {@code _default(String)} methods allow setting the default value for the schema.
 * The {@code addEnumItem(UUID)} method allows adding items to the enumeration of valid values.
 * </p>
 *
 * <p><strong>Casting Behavior:</strong></p>
 * <p>
 * The {@code cast(Object)} method attempts to convert any object into a {@code UUID}.
 * If the conversion fails, it logs the error and returns {@code null}.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * UUIDSchema uuidSchema = new UUIDSchema();
 * uuidSchema._default(UUID.randomUUID())
 *           .addEnumItem(UUID.randomUUID())
 *           .addEnumItem(UUID.randomUUID());
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * schema:
 *   type: string
 *   format: uuid
 *   default: "123e4567-e89b-12d3-a456-426614174000"
 *   enum:
 *     - "123e4567-e89b-12d3-a456-426614174000"
 *     - "987e6543-e21b-34d5-a456-426614174111"
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<[]>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see UUID
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#data-types">OpenAPI 3.0.1 – Data Types</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public class UUIDSchema extends Schema<UUID> {

    private static final Logger LOGGER = Logger.getLogger(UUIDSchema.class.getName());

    /**
     * Constructs a new {@code UUIDSchema} with default values.
     * <p>
     * The schema type is set to "string", and the format is set to "uuid".
     * </p>
     */
    public UUIDSchema() {
        super("string", "uuid");
    }

    /**
     * Sets the type of this schema.
     *
     * @param type The type to be set (e.g., "string").
     * @return This {@code UUIDSchema} object for method chaining.
     */
    @Override
    public UUIDSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets the format of this schema.
     *
     * @param format The format to be set (e.g., "uuid").
     * @return This {@code UUIDSchema} object for method chaining.
     */
    @Override
    public UUIDSchema format(String format) {
        super.setFormat(format);
        return this;
    }

    /**
     * Sets the default value for this schema.
     *
     * @param _default The default UUID value to be set.
     * @return This {@code UUIDSchema} object for method chaining.
     */
    public UUIDSchema _default(UUID _default) {
        super.setDefault(_default);
        return this;
    }

    /**
     * Sets the default value for this schema using a string representation of a UUID.
     *
     * @param _default The default string value to be set, which is parsed into a UUID.
     * @return This {@code UUIDSchema} object for method chaining.
     */
    public UUIDSchema _default(String _default) {
        if (_default != null) {
            super.setDefault(UUID.fromString(_default));
        }
        return this;
    }

    /**
     * Sets the enumeration of valid UUID values for this schema.
     *
     * @param _enum The list of valid UUID values.
     * @return This {@code UUIDSchema} object for method chaining.
     */
    public UUIDSchema _enum(List<UUID> _enum) {
        super.setEnum(_enum);
        return this;
    }

    /**
     * Adds an item to the enumeration of valid UUID values for this schema.
     *
     * @param _enumItem The UUID enumeration item to be added.
     * @return This {@code UUIDSchema} object for method chaining.
     */
    public UUIDSchema addEnumItem(UUID _enumItem) {
        super.addEnumItemObject(_enumItem);
        return this;
    }

    /**
     * Attempts to cast an object to a {@code UUID}.
     * <p>
     * If the object is non-null, it tries to convert it to a {@code UUID}. If the conversion fails,
     * an error is logged, and {@code null} is returned.
     * </p>
     *
     * @param value The object to be cast to a {@code UUID}.
     * @return The {@code UUID} representation of the value, or {@code null} if the casting fails.
     */
    @Override
    protected UUID cast(Object value) {
        if (value != null) {
            try {
                return UUID.fromString(value.toString());
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * Checks if this {@code UUIDSchema} is equal to another object.
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
     * Computes the hash code for this {@code UUIDSchema}.
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
     * Returns a string representation of this {@code UUIDSchema}.
     * <p>
     * This method provides a string representation of the schema, including its type and other properties.
     * </p>
     *
     * @return A string representation of the schema.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UUIDSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}