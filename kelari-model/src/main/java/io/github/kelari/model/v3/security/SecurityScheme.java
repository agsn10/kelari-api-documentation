package io.github.kelari.model.v3.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.enums.SecuritySchemeInEnum;
import io.github.kelari.model.v3.enums.SecuritySchemeTypeEnum;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a security scheme in an OpenAPI 3.0.1 specification.
 * <p>
 * This class defines the structure for security schemes used for authentication and authorization in API operations.
 * It supports types such as API keys, HTTP authentication (e.g., Basic, Bearer), OAuth2 flows, and OpenID Connect.
 * </p>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * components:
 *   securitySchemes:
 *     apiKeyAuth:
 *       type: apiKey
 *       in: header
 *       name: X-API-KEY
 *     httpAuth:
 *       type: http
 *       scheme: basic
 *     oauth2Auth:
 *       type: oauth2
 *       flows:
 *         authorizationCode:
 *           authorizationUrl: https://example.com/oauth/authorize
 *           tokenUrl: https://example.com/oauth/token
 *           scopes:
 *             read: Grants read access
 *             write: Grants write access
 *     openId:
 *       type: openIdConnect
 *       openIdConnectUrl: https://example.com/.well-known/openid-configuration
 * </pre>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * SecurityScheme scheme = new SecurityScheme()
 *     .type(SecuritySchemeTypeEnum.HTTP)
 *     .scheme("bearer")
 *     .bearerFormat("JWT")
 *     .description("JWT based authentication");
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see OAuthFlows
 * @see SecuritySchemeTypeEnum
 * @see SecuritySchemeInEnum
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#security-scheme-object">OpenAPI 3.0.1 – Security Scheme Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityScheme implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(SecurityScheme.class.getName());

    private SecuritySchemeTypeEnum type = null;
    private String description = null;
    private String name = null;
    private String $ref = null;
    private SecuritySchemeInEnum in = null;
    private String scheme = null;
    private String bearerFormat = null;
    private OAuthFlows flows = null;
    private String openIdConnectUrl = null;
    private Map<String, Object> extensions = null;

    /**
     * Gets the type of the security scheme.
     *
     * @return the type of the security scheme
     */
    public SecuritySchemeTypeEnum getType() {
        return type;
    }
    /**
     * Sets the type of the security scheme.
     *
     * @param type the type of the security scheme
     */
    public void setType(SecuritySchemeTypeEnum type) {
        this.type = type;
    }
    /**
     * Sets the type of the security scheme and returns the updated object.
     *
     * @param type the type of the security scheme
     * @return the updated SecurityScheme object
     */
    public SecurityScheme type(SecuritySchemeTypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Gets the description of the security scheme.
     *
     * @return the description of the security scheme
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the security scheme.
     *
     * @param description the description of the security scheme
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Sets the description of the security scheme and returns the updated object.
     *
     * @param description the description of the security scheme
     * @return the updated SecurityScheme object
     */
    public SecurityScheme description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Gets the name of the security scheme.
     *
     * @return the name of the security scheme
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the security scheme.
     *
     * @param name the name of the security scheme
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the name of the security scheme and returns the updated object.
     *
     * @param name the name of the security scheme
     * @return the updated SecurityScheme object
     */
    public SecurityScheme name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the reference to another security scheme object.
     *
     * @return the reference to another security scheme
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the reference to another security scheme object.
     *
     * @param $ref the reference to another security scheme
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.IS_SIMPLE_REF_USING_CONTAINS.test($ref))
            $ref = "#/components/securitySchemes/" + $ref;
        this.$ref = $ref;
    }
    /**
     * Sets the reference to another security scheme object and returns the updated object.
     *
     * @param $ref the reference to another security scheme
     * @return the updated SecurityScheme object
     */
    public SecurityScheme $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /**
     * Gets the location of the security scheme (e.g., in the header, query parameter).
     *
     * @return the location of the security scheme
     */
    public SecuritySchemeInEnum getIn() {
        return in;
    }
    /**
     * Sets the location of the security scheme.
     *
     * @param in the location of the security scheme
     */
    public void setIn(SecuritySchemeInEnum in) {
        this.in = in;
    }
    /**
     * Sets the location of the security scheme and returns the updated object.
     *
     * @param in the location of the security scheme
     * @return the updated SecurityScheme object
     */
    public SecurityScheme in(SecuritySchemeInEnum in) {
        this.in = in;
        return this;
    }

    /**
     * Gets the authorization scheme (e.g., Basic, Bearer).
     *
     * @return the authorization scheme
     */
    public String getScheme() {
        return scheme;
    }
    /**
     * Sets the authorization scheme (e.g., Basic, Bearer).
     *
     * @param scheme the authorization scheme
     */
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
    /**
     * Sets the authorization scheme and returns the updated object.
     *
     * @param scheme the authorization scheme
     * @return the updated SecurityScheme object
     */
    public SecurityScheme scheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    /**
     * Gets the bearer format of the security scheme (e.g., JWT).
     *
     * @return the bearer format of the security scheme
     */
    public String getBearerFormat() {
        return bearerFormat;
    }
    /**
     * Sets the bearer format of the security scheme.
     *
     * @param bearerFormat the bearer format (e.g., JWT)
     */
    public void setBearerFormat(String bearerFormat) {
        this.bearerFormat = bearerFormat;
    }
    /**
     * Sets the bearer format of the security scheme and returns the updated object.
     *
     * @param bearerFormat the bearer format (e.g., JWT)
     * @return the updated SecurityScheme object
     */
    public SecurityScheme bearerFormat(String bearerFormat) {
        this.bearerFormat = bearerFormat;
        return this;
    }

    /**
     * Gets the OAuth flows associated with the security scheme.
     *
     * @return the OAuth flows associated with the security scheme
     */
    public OAuthFlows getFlows() {
        return flows;
    }
    /**
     * Sets the OAuth flows for the security scheme.
     *
     * @param flows the OAuth flows
     */
    public void setFlows(OAuthFlows flows) {
        this.flows = flows;
    }
    /**
     * Sets the OAuth flows and returns the updated object.
     *
     * @param flows the OAuth flows
     * @return the updated SecurityScheme object
     */
    public SecurityScheme flows(OAuthFlows flows) {
        this.flows = flows;
        return this;
    }

    /**
     * Gets the OpenID Connect URL associated with the security scheme.
     *
     * @return the OpenID Connect URL
     */
    public String getOpenIdConnectUrl() {
        return openIdConnectUrl;
    }
    /**
     * Sets the OpenID Connect URL associated with the security scheme.
     *
     * @param openIdConnectUrl the OpenID Connect URL
     */
    public void setOpenIdConnectUrl(String openIdConnectUrl) {
        this.openIdConnectUrl = openIdConnectUrl;
    }
    /**
     * Sets the OpenID Connect URL and returns the updated object.
     *
     * @param openIdConnectUrl the OpenID Connect URL
     * @return the updated SecurityScheme object
     */
    public SecurityScheme openIdConnectUrl(String openIdConnectUrl) {
        this.openIdConnectUrl = openIdConnectUrl;
        return this;
    }

    /**
     * Returns any extensions for the security scheme.
     *
     * @return a map of extension names to extension values
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Sets any extensions for the security scheme.
     *
     * @param extensions a map of extension names to extension values
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Adds a custom extension property to this security scheme.
     * <p>
     * Extensions must follow the OpenAPI specification naming convention, where keys
     * must start with {@code "x-"}. If the provided name does not conform to this
     * requirement, the extension is ignored and a warning is logged.
     * </p>
     *
     * @param name  the name of the extension property. Must start with {@code "x-"}.
     * @param value the value associated with the extension property. Can be any Object.
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
        SecurityScheme that = (SecurityScheme) object;
        return type == that.type &&
                Objects.equals(description, that.description) &&
                Objects.equals(name, that.name) &&
                Objects.equals($ref, that.$ref) && in == that.in &&
                Objects.equals(scheme, that.scheme) &&
                Objects.equals(bearerFormat, that.bearerFormat) &&
                Objects.equals(flows, that.flows) &&
                Objects.equals(openIdConnectUrl, that.openIdConnectUrl) &&
                Objects.equals(extensions, that.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description, name, $ref, in, scheme,
                bearerFormat, flows, openIdConnectUrl, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SecurityScheme {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    in: ").append(toIndentedString(in)).append("\n");
        sb.append("    scheme: ").append(toIndentedString(scheme)).append("\n");
        sb.append("    bearerFormat: ").append(toIndentedString(bearerFormat)).append("\n");
        sb.append("    flows: ").append(toIndentedString(flows)).append("\n");
        sb.append("    openIdConnectUrl: ").append(toIndentedString(openIdConnectUrl)).append("\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}