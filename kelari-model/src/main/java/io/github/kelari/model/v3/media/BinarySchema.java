package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.enums.BynaryStringConversionEnum;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a Binary Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code BinarySchema} class extends {@link Schema} to support binary-encoded string content,
 * such as file uploads or base64-encoded payloads, typically used in multipart or binary media types.
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
 * <p><strong>String Conversion Behavior:</strong></p>
 * <p>
 * If the system property or environment variable {@code binary.string.conversion} is set to {@code base64},
 * string inputs will be decoded from Base64 into byte arrays. Otherwise, string inputs are interpreted
 * using UTF-8 encoding.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * BinarySchema binarySchema = new BinarySchema();
 * binarySchema._default("SGVsbG8gd29ybGQ=".getBytes(StandardCharsets.UTF_8));
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
public class BinarySchema extends Schema<byte[]> {

    private static final Logger LOGGER = Logger.getLogger(BinarySchema.class.getName());

    public BinarySchema() {
        super("string", "binary");
    }

    @Override
    public BinarySchema type(String type) {
        super.setType(type);
        return this;
    }

    @Override
    public BinarySchema format(String format) {
        super.setFormat(format);
        return this;
    }

    public BinarySchema _default(byte[] _default) {
        super.setDefault(_default);
        return this;
    }

    @Override
    protected byte[] cast(Object value) {
        if (Objects.isNull(value)) return null;
        try {
            if (value instanceof byte[])
                return (byte[]) value;
            String stringValue = value.toString();
            return Optional.ofNullable(
                            Optional.ofNullable(System.getProperty(BINARY_STRING_CONVERSION_PROPERTY))
                                    .orElse(System.getenv(BINARY_STRING_CONVERSION_PROPERTY))
                    )
                    .filter(mode -> BynaryStringConversionEnum.BINARY_STRING_CONVERSION_BASE64.name().equalsIgnoreCase(mode))
                    .map(mode -> Base64.getDecoder().decode(stringValue))
                    .orElseGet(() -> stringValue.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

}