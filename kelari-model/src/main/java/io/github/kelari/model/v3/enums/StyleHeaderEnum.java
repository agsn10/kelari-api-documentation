package io.github.kelari.model.v3.enums;

/**
 * Represents the style options available for a Header in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code StyleHeaderEnum} defines the serialization style for a header parameter.
 * In OpenAPI 3.0.1, only the {@code simple} style is supported for header parameters.
 * This enum is used in conjunction with the {@link io.github.kelari.model.v3.Header} class to
 * indicate how the header value should be serialized and parsed.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>
 * headers:
 *   X-Custom-Header:
 *     description: Custom header
 *     required: true
 *     style: simple
 *     schema:
 *       type: string
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see io.github.kelari.model.v3.headers.Header
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#header-object">OpenAPI 3.0.1 – Header Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum StyleHeaderEnum {

    /**
     * The {@code simple} style — the only supported style for header parameters in OpenAPI 3.0.1.
     */
    SIMPLE("simple");

    private final String value;

    StyleHeaderEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
