package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Number Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code NumberSchema} class extends {@link Schema} to represent a schema for number-based values,
 * supporting both integer and floating-point types as defined in the OpenAPI specification. This schema allows
 * setting default values, enum constraints, and automatic casting of arbitrary objects into {@link BigDecimal}.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = "number"</li>
 *   <li>{@code format} = {@code null}</li>
 * </ul>
 * </p>
 *
 * <p><strong>Customization:</strong></p>
 * <p>
 * The {@code _default(BigDecimal)} method allows setting the default value for the schema, and the
 * {@code _enum(List<BigDecimal>)} method sets an enumeration of valid values.
 * </p>
 *
 * <p><strong>Casting Behavior:</strong></p>
 * <p>
 * The {@code cast(Object)} method attempts to convert any object into a {@link BigDecimal}.
 * If the conversion fails, it returns {@code null}.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * NumberSchema numberSchema = new NumberSchema();
 * numberSchema._default(new BigDecimal("42.0"))
 *             .addEnumItem(new BigDecimal("10.5"))
 *             .addEnumItem(new BigDecimal("20.7"));
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * schema:
 *   type: number
 *   default: 42.0
 *   enum:
 *     - 10.5
 *     - 20.7
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
public class NumberSchema extends Schema<BigDecimal>{

    /**
     * Constructs a new {@code NumberSchema} with default values.
     * <p>
     * The schema type is set to "number" and the format is set to {@code null}.
     * </p>
     */
    public NumberSchema() {
        super("number", null);
    }

    /**
     * Sets the type of this schema.
     *
     * @param type The type to be set (e.g., "number").
     * @return This {@code NumberSchema} object for method chaining.
     */
    @Override
    public NumberSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets the default value for this schema.
     *
     * @param _default The default value to be set for the schema.
     * @return This {@code NumberSchema} object for method chaining.
     */
    public NumberSchema _default(BigDecimal _default) {
        super.setDefault(_default);
        return this;
    }

    /**
     * Sets the list of valid enum values for this schema.
     *
     * @param _enum A list of valid {@link BigDecimal} values that are allowed by this schema.
     * @return This {@code NumberSchema} object for method chaining.
     */
    public NumberSchema _enum(List<BigDecimal> _enum) {
        super.setEnum(_enum);
        return this;
    }

    /**
     * Adds an individual item to the list of valid enum values for this schema.
     *
     * @param _enumItem A {@link BigDecimal} value to be added to the enum list.
     * @return This {@code NumberSchema} object for method chaining.
     */
    public NumberSchema addEnumItem(BigDecimal _enumItem) {
        super.addEnumItemObject(_enumItem);
        return this;
    }

    /**
     * Casts an object to a {@link BigDecimal}.
     * <p>
     * This method attempts to convert any object into a {@link BigDecimal}.
     * If the conversion fails, it returns {@code null}.
     * </p>
     *
     * @param value The object to be cast to a {@link BigDecimal}.
     * @return A {@link BigDecimal} representing the value, or {@code null} if the conversion fails.
     */
    @Override
    protected BigDecimal cast(Object value) {
        if (Objects.nonNull(value)) {
            try {
                return new BigDecimal(value.toString());
            } catch (Exception e) {
                // Exception handling for invalid value
            }
        }
        return null;
    }

    /**
     * Computes the hash code for this {@code NumberSchema}.
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
     * Checks if this {@code NumberSchema} is equal to another object.
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
     * Returns a string representation of this {@code NumberSchema}.
     * <p>
     * This method provides a string representation of the schema, including its type and other properties.
     * </p>
     *
     * @return A string representation of the schema.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NumberSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
