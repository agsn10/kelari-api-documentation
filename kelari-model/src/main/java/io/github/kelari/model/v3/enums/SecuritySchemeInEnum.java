package io.github.kelari.model.v3.enums;

/**
 * Enumeration representing the possible locations of a security scheme in OpenAPI 3.0.1 specification.
 * <p>
 * This enum defines the possible locations where security information (e.g., API keys) can be passed in API requests.
 * </p>
 *
 * <p><strong>Available Locations:</strong></p>
 * <ul>
 *     <li>{@code COOKIE} – Security scheme is passed via cookies.</li>
 *     <li>{@code HEADER} – Security scheme is passed via HTTP headers.</li>
 *     <li>{@code QUERY} – Security scheme is passed via query parameters.</li>
 * </ul>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * SecuritySchemeInEnum location = SecuritySchemeInEnum.HEADER;
 * System.out.println(location);  // Output: header
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
 * @see SecurityScheme
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#security-scheme-object">OpenAPI 3.0.1 – Security Scheme Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum SecuritySchemeInEnum {

    /**
     * Represents the location where the security scheme is passed via cookies.
     */
    COOKIE("cookie"),
    /**
     * Represents the location where the security scheme is passed via HTTP headers.
     */
    HEADER("header"),
    /**
     * Represents the location where the security scheme is passed via query parameters.
     */
    QUERY("query");

    private final String value;

    /**
     * Constructor for the enumeration with the corresponding value for the security scheme location.
     *
     * @param value the string value representing the location of the security scheme
     */
    SecuritySchemeInEnum(String value) {
        this.value = value;
    }

    /**
     * Returns the location of the security scheme as a {@code String}, as used in OpenAPI.
     *
     * @return the string value representing the location of the security scheme
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}