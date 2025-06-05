package io.github.kelari.model.v3.media;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents an email schema object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code EmailSchema} class extends {@link Schema} to handle the {@code email} format for schema definitions.
 * It is used to define properties in an OpenAPI document that must conform to the email address format.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * EmailSchema schema = new EmailSchema();
 * schema._default("user@example.com");
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * components:
 *   schemas:
 *     UserEmail:
 *       type: string
 *       format: email
 *       default: user@example.com
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<https://github.com/kelari>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public class EmailSchema extends Schema<String> {

    private static final Logger LOGGER = Logger.getLogger(EmailSchema.class.getName());

    /**
     * Default constructor that initializes the EmailSchema with type "string" and format "email".
     */
    public EmailSchema() {
        super("string", "email");
    }

    /**
     * Sets the type of the schema.
     *
     * @param type The type to set (typically "string").
     * @return The current {@code EmailSchema} instance.
     */
    @Override
    public EmailSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets the format of the schema.
     *
     * @param format The format to set (typically "email").
     * @return The current {@code EmailSchema} instance.
     */
    @Override
    public EmailSchema format(String format) {
        super.setFormat(format);
        return this;
    }

    /**
     * Sets the default value for the schema.
     *
     * @param _default The default email value.
     * @return The current {@code EmailSchema} instance.
     */
    public EmailSchema _default(String _default) {
        super.setDefault(_default);
        return this;
    }

    /**
     * Attempts to cast the given object to a {@code String} representing an email address.
     *
     * @param value The object to cast.
     * @return The string representation or {@code null} if the cast fails.
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
     * Adds a single allowed value (enum) for the schema.
     *
     * @param _enumItem A string email value to add to the enum list.
     * @return The current {@code EmailSchema} instance.
     */
    public EmailSchema addEnumItem(String _enumItem) {
        super.addEnumItemObject(_enumItem);
        return this;
    }

    /**
     * Checks equality between this schema and another object.
     *
     * @param object The object to compare.
     * @return {@code true} if equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Returns the hash code for this {@code EmailSchema}.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Returns a string representation of this {@code EmailSchema}.
     *
     * @return A formatted string describing the schema.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EmailSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}