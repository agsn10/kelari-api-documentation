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
 * Represents the {@code OAuthFlows} object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code OAuthFlows} object allows configuration of the supported OAuth 2.0 flows. Each flow (implicit,
 * password, client credentials, and authorization code) is described using its own {@link OAuthFlow} object.
 * This object is used within the {@link SecurityScheme} to define the OAuth2 security mechanisms supported
 * by the API.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * OAuthFlows flows = new OAuthFlows()
 *     .implicit(new OAuthFlow().authorizationUrl("https://example.com/oauth/authorize").scopes(new Scopes()))
 *     .authorizationCode(new OAuthFlow()
 *         .authorizationUrl("https://example.com/oauth/authorize")
 *         .tokenUrl("https://example.com/oauth/token")
 *         .scopes(new Scopes().addScope("read", "Read access")));
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * flows:
 *   implicit:
 *     authorizationUrl: https://example.com/oauth/authorize
 *     scopes:
 *       read: Read access
 *   authorizationCode:
 *     authorizationUrl: https://example.com/oauth/authorize
 *     tokenUrl: https://example.com/oauth/token
 *     scopes:
 *       read: Read access
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see OAuthFlow
 * @see SecurityScheme
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#oauth-flows-object">OpenAPI 3.0.1 – OAuth Flows Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAuthFlows implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(OAuthFlows.class.getName());

    private OAuthFlow implicit = null;
    private OAuthFlow password = null;
    private OAuthFlow clientCredentials = null;
    private OAuthFlow authorizationCode = null;
    private Map<String, Object> extensions = null;

    /**
     * Gets the OAuth 2.0 Implicit flow configuration.
     *
     * @return the implicit flow configuration
     */
    public OAuthFlow getImplicit() {
        return implicit;
    }
    /**
     * Sets the OAuth 2.0 Implicit flow configuration.
     *
     * @param implicit the implicit flow configuration
     */
    public void setImplicit(OAuthFlow implicit) {
        this.implicit = implicit;
    }
    /**
     * Fluent setter for the OAuth 2.0 Implicit flow configuration.
     *
     * @param implicit the implicit flow configuration
     * @return this {@link OAuthFlows} instance
     */
    public OAuthFlows implicit(OAuthFlow implicit) {
        this.implicit = implicit;
        return this;
    }

    /**
     * Gets the OAuth 2.0 Resource Owner Password flow configuration.
     *
     * @return the password flow configuration
     */
    public OAuthFlow getPassword() {
        return password;
    }
    /**
     * Sets the OAuth 2.0 Resource Owner Password flow configuration.
     *
     * @param password the password flow configuration
     */
    public void setPassword(OAuthFlow password) {
        this.password = password;
    }
    /**
     * Fluent setter for the OAuth 2.0 Resource Owner Password flow configuration.
     *
     * @param password the password flow configuration
     * @return this {@link OAuthFlows} instance
     */
    public OAuthFlows password(OAuthFlow password) {
        this.password = password;
        return this;
    }

    /**
     * Gets the OAuth 2.0 Client Credentials flow configuration.
     *
     * @return the client credentials flow configuration
     */
    public OAuthFlow getClientCredentials() {
        return clientCredentials;
    }
    /**
     * Sets the OAuth 2.0 Client Credentials flow configuration.
     *
     * @param clientCredentials the client credentials flow configuration
     */
    public void setClientCredentials(OAuthFlow clientCredentials) {
        this.clientCredentials = clientCredentials;
    }
    /**
     * Fluent setter for the OAuth 2.0 Client Credentials flow configuration.
     *
     * @param clientCredentials the client credentials flow configuration
     * @return this {@link OAuthFlows} instance
     */
    public OAuthFlows clientCredentials(OAuthFlow clientCredentials) {
        this.clientCredentials = clientCredentials;
        return this;
    }

    /**
     * Gets the OAuth 2.0 Authorization Code flow configuration.
     *
     * @return the authorization code flow configuration
     */
    public OAuthFlow getAuthorizationCode() {
        return authorizationCode;
    }
    /**
     * Sets the OAuth 2.0 Authorization Code flow configuration.
     *
     * @param authorizationCode the authorization code flow configuration
     */
    public void setAuthorizationCode(OAuthFlow authorizationCode) {
        this.authorizationCode = authorizationCode;
    }
    /**
     * Fluent setter for the OAuth 2.0 Authorization Code flow configuration.
     *
     * @param authorizationCode the authorization code flow configuration
     * @return this {@link OAuthFlows} instance
     */
    public OAuthFlows authorizationCode(OAuthFlow authorizationCode) {
        this.authorizationCode = authorizationCode;
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
        OAuthFlows that = (OAuthFlows) object;
        return Objects.equals(implicit, that.implicit) &&
               Objects.equals(password, that.password) &&
               Objects.equals(clientCredentials, that.clientCredentials) &&
               Objects.equals(authorizationCode, that.authorizationCode) &&
               Objects.equals(extensions, that.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(implicit, password, clientCredentials, authorizationCode, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OAuthFlows {\n");
        sb.append("    implicit: ").append(toIndentedString(implicit)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    clientCredentials: ").append(toIndentedString(clientCredentials)).append("\n");
        sb.append("    authorizationCode: ").append(toIndentedString(authorizationCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}