package io.github.kelari.model.v3.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents an OAuth flow object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code OAuthFlow} object defines a specific OAuth 2.0 flow configuration. This includes the
 * authorization URL, token URL, refresh URL, and available scopes. Each flow (e.g., "implicit",
 * "password", "clientCredentials", "authorizationCode") can define its own OAuthFlow object.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * OAuthFlow flow = new OAuthFlow()
 *     .authorizationUrl("https://example.com/oauth/authorize")
 *     .tokenUrl("https://example.com/oauth/token")
 *     .refreshUrl("https://example.com/oauth/refresh")
 *     .scopes(new Scopes().addScope("read", "Read access").addScope("write", "Write access"));
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * flows:
 *   authorizationCode:
 *     authorizationUrl: https://example.com/oauth/authorize
 *     tokenUrl: https://example.com/oauth/token
 *     refreshUrl: https://example.com/oauth/refresh
 *     scopes:
 *       read: Read access
 *       write: Write access
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Scopes
 * @see SecurityScheme
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#oauth-flow-object">OpenAPI 3.0.1 – OAuth Flow Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAuthFlow implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(OAuthFlow.class.getName());

    private String authorizationUrl = null;
    private String tokenUrl = null;
    private String refreshUrl = null;
    private Scopes scopes = null;
    private Map<String, Object> extensions = null;

    /**
     * Gets the authorization URL to be used for this flow.
     *
     * @return the authorization URL
     */
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }
    /**
     * Sets the authorization URL to be used for this flow.
     *
     * @param authorizationUrl the authorization URL
     */
    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }
    /**
     * Builder-style method for setting the authorization URL.
     *
     * @param authorizationUrl the authorization URL
     * @return this {@code OAuthFlow} instance
     */
    public OAuthFlow authorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
        return this;
    }

    /**
     * Gets the token URL to be used for this flow.
     *
     * @return the token URL
     */
    public String getTokenUrl() {
        return tokenUrl;
    }
    /**
     * Sets the token URL to be used for this flow.
     *
     * @param tokenUrl the token URL
     */
    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }
    /**
     * Builder-style method for setting the token URL.
     *
     * @param tokenUrl the token URL
     * @return this {@code OAuthFlow} instance
     */
    public OAuthFlow tokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
        return this;
    }

    /**
     * Gets the refresh URL to be used for obtaining new access tokens.
     *
     * @return the refresh URL
     */
    public String getRefreshUrl() {
        return refreshUrl;
    }
    /**
     * Sets the refresh URL to be used for obtaining new access tokens.
     *
     * @param refreshUrl the refresh URL
     */
    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }
    /**
     * Builder-style method for setting the refresh URL.
     *
     * @param refreshUrl the refresh URL
     * @return this {@code OAuthFlow} instance
     */
    public OAuthFlow refreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
        return this;
    }

    /**
     * Gets the OAuth2 scopes available for this flow.
     *
     * @return the {@link Scopes} instance
     */
    public Scopes getScopes() {
        return scopes;
    }
    /**
     * Sets the OAuth2 scopes available for this flow.
     *
     * @param scopes the {@link Scopes} instance
     */
    public void setScopes(Scopes scopes) {
        this.scopes = scopes;
    }
    /**
     * Builder-style method for setting the OAuth2 scopes.
     *
     * @param scopes the {@link Scopes} instance
     * @return this {@code OAuthFlow} instance
     */
    public OAuthFlow scopes(Scopes scopes) {
        this.scopes = scopes;
        return this;
    }

    /**
     * Returns any extensions for the parameter.
     *
     * @return a map of extension names to extension values
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Sets any extensions for the parameter.
     *
     * @param extensions a map of extension names to extension values
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Adds a custom extension property to this object.
     * <p>
     * Extensions must follow the OpenAPI specification naming convention, where keys
     * must start with {@code "x-"}. If the provided name does not conform to this
     * requirement, the extension is ignored and a warning is logged.
     * </p>
     *
     * @param name  the name of the extension property. Must start with {@code "x-"}.
     * @param value the value associated with the extension property. Can be any Object.
     *
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if(Objects.isNull(extensions))
            extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        OAuthFlow oAuthFlow = (OAuthFlow) object;
        return Objects.equals(authorizationUrl, oAuthFlow.authorizationUrl) &&
               Objects.equals(tokenUrl, oAuthFlow.tokenUrl) &&
               Objects.equals(refreshUrl, oAuthFlow.refreshUrl) &&
               Objects.equals(scopes, oAuthFlow.scopes) &&
               Objects.equals(extensions, oAuthFlow.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorizationUrl, tokenUrl, refreshUrl, scopes, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OAuthFlow {\n");
        sb.append("    authorizationUrl: ").append(toIndentedString(authorizationUrl)).append("\n");
        sb.append("    tokenUrl: ").append(toIndentedString(tokenUrl)).append("\n");
        sb.append("    refreshUrl: ").append(toIndentedString(refreshUrl)).append("\n");
        sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}