package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

/**
 * Represents a Binary File Schema as defined in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code FileSchema} class extends {@link Schema} to support binary-encoded string content,
 * such as file uploads or base64-encoded payloads, commonly used in multipart or binary media types.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = "string"</li>
 *   <li>{@code format} = "binary"</li>
 * </ul>
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * FileSchema fileSchema = new FileSchema();
 * fileSchema._default("SGVsbG8gd29ybGQ="); // base64-encoded string it's simulating binary content
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * requestBody:
 *   content:
 *     application/octet-stream:
 *       schema:
 *         type: string
 *         format: binary
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
public class FileSchema extends Schema<String> {

    /**
     * Constructs a {@link FileSchema} with default type "string" and format "binary".
     */
    public FileSchema() {
        super("string", "binary");
    }

    /**
     * Sets the type of the schema.
     *
     * @param type the OpenAPI data type, usually "string"
     * @return the current {@link FileSchema} instance
     */
    @Override
    public FileSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets the format of the schema.
     *
     * @param format the OpenAPI data format, usually "binary"
     * @return the current {@link FileSchema} instance
     */
    @Override
    public FileSchema format(String format) {
        super.setFormat(format);
        return this;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param object the reference object with which to compare
     * @return {@code true} if this object is the same as the object argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of this {@link FileSchema}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FileSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}