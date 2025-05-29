package io.github.kelari.annotation.v3.enums;

/**
 * Defines the type of security scheme to be used in the API, as specified by the
 * OpenAPI Specification.
 *
 * <p>
 * This enumeration is used to indicate how security credentials are expected to be provided
 * by the client during API requests.
 * </p>
 *
 * <ul>
 *     <li>{@link #APIKEY} – An API key that is transmitted either via query parameter, header, or cookie.</li>
 *     <li>{@link #HTTP} – HTTP authentication schemes like Basic, Bearer, etc.</li>
 *     <li>{@link #OAUTH2} – OAuth 2.0 flow for delegated authorization.</li>
 *     <li>{@link #OPENIDCONNECT} – OpenID Connect Discovery for verifying identities.</li>
 *     <li>{@link #DEFAULT} – Represents an unspecified or implementation-defined scheme type.</li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @SecurityScheme(
 *     name = "BearerAuth",
 *     type = SecuritySchemeType.HTTP,
 *     scheme = "bearer"
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#securitySchemeObject">
 *      Security Scheme (OpenAPI Specification)</a>
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum SecuritySchemeType {
    APIKEY,
    DEFAULT,
    HTTP,
    OAUTH2,
    OPENIDCONNECT
}
