package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.text.NumberFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents an Integer Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code IntegerSchema} class extends {@link Schema} to support integer-based values
 * compliant with the OpenAPI specification. It allows setting default values, enum constraints,
 * and automatic casting of arbitrary objects into {@link Integer} or {@link Long}, depending on
 * their range.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = "integer"</li>
 *   <li>{@code format} = "int32"</li>
 * </ul>
 * </p>
 *
 * <p><strong>Casting Behavior:</strong></p>
 * <p>
 * The {@code cast(Object)} method attempts to convert any object into a {@link Number}.
 * If the value falls within the range of a 32-bit signed integer, it is cast to an {@code Integer},
 * otherwise to a {@code Long}. Parsing is done using {@link NumberFormat}. If parsing fails,
 * {@code null} is returned and the error is logged.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * IntegerSchema integerSchema = new IntegerSchema();
 * integerSchema._default(42)
 *              .addEnumItem(1)
 *              .addEnumItem(2)
 *              .addEnumItem(3);
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * schema:
 *   type: integer
 *   format: int32
 *   default: 42
 *   enum:
 *     - 1
 *     - 2
 *     - 3
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
public class IntegerSchema extends Schema<Number>{

    private static final Logger LOGGER = Logger.getLogger(IntegerSchema.class.getName());

    /**
     * Constructs an {@code IntegerSchema} with type {@code "integer"} and format {@code "int32"}.
     */
    public IntegerSchema() {
        super("integer", "int32");
    }

    /**
     * Sets the OpenAPI type of this schema.
     *
     * @param type the type to set, usually {@code "integer"}
     * @return this {@code IntegerSchema} instance
     */
    @Override
    public IntegerSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets the OpenAPI format of this schema.
     *
     * @param format the format to set, e.g., {@code "int32"} or {@code "int64"}
     * @return this {@code IntegerSchema} instance
     */
    @Override
    public IntegerSchema format(String format) {
        super.setFormat(format);
        return this;
    }

    /**
     * Sets the default value of the schema.
     *
     * @param _default the default number value
     * @return this {@code IntegerSchema} instance
     */
    public IntegerSchema _default(Number _default) {
        super.setDefault(_default);
        return this;
    }

    /**
     * Attempts to cast an arbitrary object into a {@link Number}.
     * If the parsed value is within the range of {@link Integer}, returns an {@link Integer}.
     * Otherwise, returns a {@link Long}. If parsing fails, logs the error and returns {@code null}.
     *
     * @param value the object to cast
     * @return a {@link Number} instance (either {@link Integer} or {@link Long}), or {@code null} if invalid
     */
    @Override
    protected Number cast(Object value) {
        if (Objects.nonNull(value)) {
            try {
                Number casted = NumberFormat.getInstance().parse(value.toString());
                if (OpenApiPredicates.IS_WITHIN_INTEGER_RANGE.test(casted))
                    return Integer.parseInt(value.toString());
                else
                    return Long.parseLong(value.toString());
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * Adds a number to the enumeration values of this schema.
     *
     * @param _enumItem the number value to add to the enum list
     * @return this {@code IntegerSchema} instance
     */
    public IntegerSchema addEnumItem(Number _enumItem) {
        super.addEnumItemObject(_enumItem);
        return this;
    }

    /**
     * Computes the hash code of this schema.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Compares this schema to another object for equality.
     *
     * @param object the object to compare to
     * @return {@code true} if equal, otherwise {@code false}
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Returns the string representation of this schema.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IntegerSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
