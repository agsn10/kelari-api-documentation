package io.github.kelari.model.v3.media;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a String Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code StringSchema} class extends {@link Schema} to represent a schema for string-based values.
 * It supports setting default values, enumeration items, and provides a method to cast arbitrary objects into {@code String} values.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = "string"</li>
 *   <li>{@code enum} = null (can be set using {@code _enum(List<String>)} or {@code addEnumItem(String)})</li>
 * </ul>
 * </p>
 *
 * <p><strong>Customization:</strong></p>
 * <p>
 * The {@code _default(String)} method allows setting the default value for the schema, and the
 * {@code addEnumItem(String)} method allows adding items to the enumeration of valid values.
 * </p>
 *
 * <p><strong>Casting Behavior:</strong></p>
 * <p>
 * The {@code cast(Object)} method attempts to convert any object into a {@code String}.
 * If the conversion fails, it logs the error and returns {@code null}.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * StringSchema stringSchema = new StringSchema();
 * stringSchema._default("defaultValue")
 *             .addEnumItem("option1")
 *             .addEnumItem("option2");
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * schema:
 *   type: string
 *   default: "defaultValue"
 *   enum:
 *     - "option1"
 *     - "option2"
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<[]>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#data-types">OpenAPI 3.0.1 – Data Types</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public class StringSchema extends Schema<String> {

    private static final Logger LOGGER = Logger.getLogger(StringSchema.class.getName());

    /**
     * Constructs a new {@code StringSchema} with default values.
     * <p>
     * The schema type is set to "string", and the enumeration is set to {@code null}.
     * </p>
     */
    public StringSchema() {
        super("string", null);
    }

    /**
     * Sets the type of this schema.
     *
     * @param type The type to be set (e.g., "string").
     * @return This {@code StringSchema} object for method chaining.
     */
    @Override
    public StringSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets the default value for this schema.
     *
     * @param _default The default value to be set.
     * @return This {@code StringSchema} object for method chaining.
     */
    public StringSchema _default(String _default) {
        super.setDefault(_default);
        return this;
    }

    /**
     * Sets the enumeration of valid values for this schema.
     *
     * @param _enum The list of valid enumeration values.
     * @return This {@code StringSchema} object for method chaining.
     */
    public StringSchema _enum(List<String> _enum) {
        super.setEnum(_enum);
        return this;
    }

    /**
     * Adds an item to the enumeration of valid values for this schema.
     *
     * @param _enumItem The enumeration item to be added.
     * @return This {@code StringSchema} object for method chaining.
     */
    public StringSchema addEnumItem(String _enumItem) {
        super.addEnumItemObject(_enumItem);
        return this;
    }

    /**
     * Attempts to cast an object to a {@code String}.
     * <p>
     * If the object is non-null, it tries to convert it to a {@code String}. If the conversion fails,
     * an error is logged, and {@code null} is returned.
     * </p>
     *
     * @param value The object to be cast to a {@code String}.
     * @return The {@code String} representation of the value, or {@code null} if the casting fails.
     */
    @Override
    protected String cast(Object value) {
        if (Objects.nonNull(value)) {
            try {
                return value.toString();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * Checks if this {@code StringSchema} is equal to another object.
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
     * Computes the hash code for this {@code StringSchema}.
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
     * Returns a string representation of this {@code StringSchema}.
     * <p>
     * This method provides a string representation of the schema, including its type and other properties.
     * </p>
     *
     * @return A string representation of the schema.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StringSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}