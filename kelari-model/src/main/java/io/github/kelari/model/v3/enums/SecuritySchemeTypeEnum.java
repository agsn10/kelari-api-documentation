package io.github.kelari.model.v3.enums;

/**
 * Enumeration that represents the security scheme types supported by the OpenAPI 3.0.1 specification.
 * <p>
 * This enumeration defines the possible security mechanisms applied to API endpoints as specified by OpenAPI.
 * </p>
 *
 * <p><strong>Available Types:</strong></p>
 * <ul>
 *     <li>{@code APIKEY} – API key passed via query, header, or cookie.</li>
 *     <li>{@code HTTP} – HTTP-based schemes such as Basic, Bearer, etc.</li>
 *     <li>{@code OAUTH2} – OAuth 2.0 flow, supporting different authentication methods.</li>
 *     <li>{@code OPENIDCONNECT} – OpenID Connect Discovery mechanism.</li>
 *     <li>{@code MUTUALTLS} – Mutual TLS authentication.</li>
 * </ul>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * SecuritySchemeTypeEnum securityScheme = SecuritySchemeTypeEnum.APIKEY;
 * System.out.println(securityScheme);  // Output: apiKey
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * securitySchemes:
 *   apiKey:
 *     type: apiKey
 *     in: header
 *     name: X-API-Key
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see OAuthFlow
 * @see SecurityScheme
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#security-scheme-object">OpenAPI 3.0.1 – Security Scheme Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum SecuritySchemeTypeEnum {

    /**
     * Represents an API key-based security scheme.
     */
    APIKEY("apiKey"),
    /**
     * Represents an HTTP-based security scheme.
     */
    HTTP("http"),
    /**
     * Represents an OAuth 2.0-based security scheme.
     */
    OAUTH2("oauth2"),
    /**
     * Represents an OpenID Connect-based security scheme.
     */
    OPENIDCONNECT("openIdConnect"),
    /**
     * Represents a Mutual TLS-based security scheme.
     */
    MUTUALTLS("mutualTLS");
    private final String value;
    /**
     * Constructor for the enumeration with the corresponding value for the scheme type.
     *
     * @param value the string value representing the scheme type in OpenAPI
     */
    SecuritySchemeTypeEnum(String value) {
        this.value = value;
    }
    /**
     * Returns the scheme type value as a {@code String}, as used in OpenAPI.
     *
     * @return the string value of the scheme type
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}