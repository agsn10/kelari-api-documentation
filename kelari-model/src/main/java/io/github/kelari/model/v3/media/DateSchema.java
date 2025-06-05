package io.github.kelari.model.v3.media;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a schema for a date in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code DateSchema} class is a specialization of {@link Schema} configured
 * for the "string" type and "date" format. It supports parsing and validating date values.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * DateSchema dateSchema = new DateSchema()
 *     ._default(new Date())
 *     .addEnumItem(Date.from(Instant.parse("2025-01-01T00:00:00Z")));
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * type: string
 * format: date
 * default: 2025-01-01
 * enum:
 *   - 2025-01-01
 *   - 2025-12-31
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a>
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 */
public class DateSchema extends Schema<Date> {

    private static final Logger LOGGER = Logger.getLogger(DateSchema.class.getName());

    /**
     * Constructs a new {@code DateSchema} with type "string" and format "date".
     */
    public DateSchema() {
        super("string", "date");
    }

    /**
     * Sets the type of this schema.
     *
     * @param type the type to set
     * @return this {@code DateSchema} instance
     */
    @Override
    public DateSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets the format of this schema.
     *
     * @param format the format to set
     * @return this {@code DateSchema} instance
     */
    @Override
    public DateSchema format(String format) {
        super.setFormat(format);
        return this;
    }

    /**
     * Sets the default value of the schema.
     *
     * @param _default the default date value
     * @return this {@code DateSchema} instance
     */
    public DateSchema _default(Date _default) {
        super.setDefault(_default);
        return this;
    }

    /**
     * Adds a date to the list of enum values for this schema.
     *
     * @param _enumItem the enum item to add
     * @return this {@code DateSchema} instance
     */
    public DateSchema addEnumItem(Date _enumItem) {
        super.addEnumItemObject(_enumItem);
        return this;
    }

    /**
     * Attempts to cast an object to a {@code Date}, parsing strings using the format {@code yyyy-MM-dd}.
     *
     * @param value the value to cast
     * @return the cast {@code Date} or {@code null} if conversion fails
     */
    @Override
    protected Date cast(Object value) {
        if (Objects.nonNull(value)) {
            try {
                if (value instanceof Date) {
                    return (Date) value;
                } else if (value instanceof String) {
                    return new SimpleDateFormat("yyyy-MM-dd Z").parse((String)value + " UTC");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * Compares this schema to the specified object.
     *
     * @param object the object to compare
     * @return {@code true} if equal; otherwise {@code false}
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Returns a hash code for this schema.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Returns a string representation of this {@code DateSchema}.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DateSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
