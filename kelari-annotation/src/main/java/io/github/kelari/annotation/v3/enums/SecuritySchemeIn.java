package io.github.kelari.annotation.v3.enums;

/**
 * Indicates the location of the security scheme parameter in the API request, as defined by the
 * OpenAPI Specification.
 *
 * <p>
 * This enumeration is used primarily with {@code apiKey} type security schemes to specify where
 * the key is expected to be transmitted by the client.
 * </p>
 *
 * <ul>
 *     <li>{@link #HEADER} – The API key is expected in the HTTP header.</li>
 *     <li>{@link #QUERY} – The API key is expected in the query string.</li>
 *     <li>{@link #COOKIE} – The API key is expected in a cookie.</li>
 *     <li>{@link #DEFAULT} – Represents an unspecified or implementation-defined location.</li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @SecurityScheme(
 *     type = SecuritySchemeType.APIKEY,
 *     name = "apiKey",
 *     in = SecuritySchemeIn.HEADER
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#securitySchemeObject">
 *      Security Scheme (OpenAPI Specification)</a>
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum SecuritySchemeIn {
    COOKIE,
    DEFAULT,
    HEADER,
    QUERY
}
