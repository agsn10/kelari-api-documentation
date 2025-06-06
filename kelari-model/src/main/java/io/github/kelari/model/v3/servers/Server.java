package io.github.kelari.model.v3.servers;

import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a Server object used to define an API server in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code Server} object provides connectivity information to a target server. It includes
 * the base URL for API requests, an optional description, a set of variables for URL substitution,
 * and vendor-specific extensions.
 * </p>
 *
 * <p><strong>Example usage:</strong></p>
 * <pre>
 * servers:
 *   - url: https://{username}.example.com:{port}/{basePath}
 *     description: The production API server
 *     variables:
 *       username:
 *         default: demo
 *       port:
 *         enum:
 *           - '443'
 *           - '8443'
 *         default: '443'
 *       basePath:
 *         default: v2
 *     x-company-metadata:
 *       region: us-east-1
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#server-object">OpenAPI 3.0.1 – Server Object</a>
 * @see ServerVariables
 * @see ServerVariable
 * @copyright 2025 Kelari. All rights reserved.
 */
public class Server implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());

    private String url = null;
    private String description = null;
    private ServerVariables variables = null;
    private java.util.Map<String, Object> extensions = null; // <- here go x-*

    /**
     * Gets the URL of the server.
     *
     * @return the server URL
     * @see <a href="https://spec.openapis.org/oas/v3.0.1#server-object">OpenAPI Server Object</a>
     */
    public String getUrl() {
        return url;
    }
    /**
     * Sets the URL of the server.
     *
     * @param url the server URL
     */
    public void setUrl(String url) {
        this.url = url;
    }
    public Server url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the description of the server.
     *
     * @return the server description
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the server.
     *
     * @param description the server description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    public Server description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Gets the map of server variables for URL template substitution.
     *
     * @return the server variables
     * @see <a href="https://spec.openapis.org/oas/v3.0.1#server-object">OpenAPI Server Object</a>
     */
    public ServerVariables getVariables() {
        return variables;
    }
    /**
     * Sets the map of server variables for URL template substitution.
     *
     * @param variables the server variables
     */
    public void setVariables(ServerVariables variables) {
        this.variables = variables;
    }
    public Server variables(ServerVariables variables) {
        this.variables = variables;
        return this;
    }

    /**
     * Adds a vendor extension (key starting with "x-") to the extensions map.
     *
     * @param name the name of the extension property
     * @param value the value of the extension property
     * @return the updated {@code Server} instance
     * @see <a href="https://spec.openapis.org/oas/v3.0.1#specification-extensions">Specification Extensions</a>
     */
    public Server extensions(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return this;
        }
        if (Objects.isNull(extensions))
            extensions = new LinkedHashMap<>();
        extensions.put(name, value);
        return this;
    }
    /**
     * Returns the vendor extensions map.
     *
     * @return a map of extension properties, or {@code null} if none are present
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Sets the vendor extensions map.
     *
     * @param extensions a map of extension properties to set
     * @see <a href="https://spec.openapis.org/oas/v3.0.1#specification-extensions">Specification Extensions</a>
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Server server = (Server) object;
        return Objects.equals(url, server.url) &&
                Objects.equals(description, server.description) &&
                Objects.equals(variables, server.variables) &&
                Objects.equals(extensions, server.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, description, variables, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Server {\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}