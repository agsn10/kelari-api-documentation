package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a DateTime schema object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code DateTimeSchema} class extends {@link Schema} to handle the date-time format for schema definitions.
 * This class is used to represent date-time data types, providing functionality for type validation and conversion.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * DateTimeSchema schema = new DateTimeSchema();
 * schema.setDefault(new Date());
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * components:
 *   schemas:
 *     DateTimeExample:
 *       type: string
 *       format: date-time
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<https://github.com/kelari>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DateTimeSchema extends Schema<OffsetDateTime> {

    private static final Logger LOGGER = Logger.getLogger(DateTimeSchema.class.getName());

    /**
     * Default constructor that initializes the DateTimeSchema with a type of "string" and format of "date-time".
     */
    public DateTimeSchema() {
        super("string", "date-time");
    }

    /**
     * Sets the type of the schema.
     *
     * @param type The type of the schema (e.g., "string", "integer").
     * @return The current instance of {@code DateTimeSchema}.
     */
    @Override
    public DateTimeSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets the format of the schema.
     *
     * @param format The format of the schema (e.g., "date-time").
     * @return The current instance of {@code DateTimeSchema}.
     */
    @Override
    public DateTimeSchema format(String format) {
        super.setFormat(format);
        return this;
    }

    /**
     * Sets the default value for the schema.
     *
     * @param _default The default value for the schema.
     * @return The current instance of {@code DateTimeSchema}.
     */
    public DateTimeSchema _default(Date _default) {
        super.setDefault(_default);
        return this;
    }

    /**
     * Casts a given object to an {@link OffsetDateTime}.
     * If the value is a {@link Date}, it converts it to an {@code OffsetDateTime} in UTC.
     * If the value is a {@link String}, it attempts to parse it as an {@code OffsetDateTime}.
     * If the value is already an {@link OffsetDateTime}, it returns the same value.
     *
     * @param value The object to be cast to an {@code OffsetDateTime}.
     * @return The corresponding {@code OffsetDateTime} value or {@code null} if the conversion fails.
     */
    @Override
    protected OffsetDateTime cast(Object value) {
        return Optional.ofNullable(value)
                .flatMap(v -> {
                    if (v instanceof Date) {
                        return Optional.of(((Date) v).toInstant().atOffset(ZoneOffset.UTC));
                    } else if (v instanceof String) {
                        try {
                            return Optional.of(OffsetDateTime.parse((String) v));
                        } catch (Exception e) {
                            LOGGER.log(Level.SEVERE, e.getMessage(), e);
                            return Optional.empty();
                        }
                    } else if (v instanceof OffsetDateTime) {
                        return Optional.of((OffsetDateTime) v);
                    }
                    return Optional.empty();
                })
                .orElse(null);
    }

    /**
     * Sets the allowed values (enum) for the schema.
     *
     * @param _enum A list of allowed {@code OffsetDateTime} values.
     * @return The current instance of {@code DateTimeSchema}.
     */
    public DateTimeSchema _enum(List<OffsetDateTime> _enum) {
        super.setEnum(_enum);
        return this;
    }

    /**
     * Adds a single allowed value (enum) for the schema.
     *
     * @param _enumItem A single {@code OffsetDateTime} value to add to the enum list.
     * @return The current instance of {@code DateTimeSchema}.
     */
    public DateTimeSchema addEnumItem(OffsetDateTime _enumItem) {
        super.addEnumItemObject(_enumItem);
        return this;
    }

    /**
     * Compares this {@code DateTimeSchema} object with another object for equality.
     *
     * @param object The object to compare with.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Returns the hash code for this {@code DateTimeSchema}.
     *
     * @return The hash code value for this {@code DateTimeSchema}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Returns a string representation of this {@code DateTimeSchema}.
     *
     * @return A string representation of the {@code DateTimeSchema}.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DateTimeSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}