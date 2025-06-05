package io.github.kelari.model.v3.links;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.servers.Server;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents the {@code Link} object in the OpenAPI 3.0.1 specification.
 * <p>
 * A {@code Link} object represents a possible design-time link for a response. The presence of a link
 * makes it possible to define a relationship between responses and operations.
 * This is similar to hypermedia links, but OpenAPI links use an operationRef or operationId to define an
 * explicit relationship to an operation.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Link link = new Link()
 *     .operationId("getUserById")
 *     .parameters("userId", "$response.body#/id")
 *     .description("The `userId` value returned in the response can be used as input parameter to retrieve user details.");
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * links:
 *   GetUserById:
 *     operationId: getUserById
 *     parameters:
 *       userId: "$response.body#/id"
 *     description: >
 *       The `userId` value returned in the response can be used
 *       as input parameter to retrieve user details.
 * </pre>
 *
 * <p>
 * This class supports OpenAPI extension fields prefixed with {@code x-}, which can be added using {@link #addExtension}.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#link-object">OpenAPI 3.0.1 – Link Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Link implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Link.class.getName());

    private String operationRef = null;
    private String operationId = null;
    private Map<String, String> parameters = null;
    private Object requestBody = null;
    private String description = null;
    private String $ref = null;
    private Map<String, Object> extensions = null;
    private Server server;

    /**
     * Returns the server associated with this link.
     *
     * @return the {@link Server} object or null if not set.
     */
    public Server getServer() {
        return server;
    }
    /**
     * Sets the server associated with this link.
     *
     * @param server the {@link Server} to set.
     */
    public void setServer(Server server) {
        this.server = server;
    }
    /**
     * Fluent method to set the server and return this link.
     *
     * @param server the {@link Server} to associate with the link.
     * @return the current {@link Link} instance.
     */
    public Link server(Server server) {
        this.setServer(server);
        return this;
    }

    /**
     * Returns the operation reference of this link.
     *
     * @return the operation reference URI or null.
     */
    public String getOperationRef() {
        return operationRef;
    }
    /**
     * Sets the operation reference of this link.
     *
     * @param operationRef the URI reference to an existing operation.
     */
    public void setOperationRef(String operationRef) {
        this.operationRef = operationRef;
    }
    /**
     * Fluent method to set the operation reference.
     *
     * @param operationRef the URI reference to an existing operation.
     * @return the current {@link Link} instance.
     */
    public Link operationRef(String operationRef) {
        this.operationRef = operationRef;
        return this;
    }

    /**
     * Returns the request body associated with this link.
     *
     * @return the request body or null.
     */
    public Object getRequestBody() {
        return requestBody;
    }
    /**
     * Sets the request body for this link.
     *
     * @param requestBody the request body to set.
     */
    public void setRequestBody(Object requestBody) {
        this.requestBody = requestBody;
    }
    /**
     * Fluent method to set the request body.
     *
     * @param requestBody the request body to associate.
     * @return the current {@link Link} instance.
     */
    public Link requestBody(Object requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    /**
     * Returns the description of this link.
     *
     * @return the description or null.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of this link.
     *
     * @param description a human-readable description of the link.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Fluent method to set the description.
     *
     * @param description a human-readable description of the link.
     * @return the current {@link Link} instance.
     */
    public Link description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the reference string of this link.
     *
     * @return the JSON Reference string or null.
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the reference string for this link. Automatically prefixes with
     * {@code #/components/links/} if a simple reference is provided.
     *
     * @param $ref the reference string to set.
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.IS_SIMPLE_REF_USING_CONTAINS.test($ref))
            $ref = "#/components/links/" + $ref;
        this.$ref = $ref;
    }
    /**
     * Fluent method to set the reference string.
     *
     * @param $ref the reference string.
     * @return the current {@link Link} instance.
     */
    public Link $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /**
     * Returns a map of extensions associated with this link.
     *
     * @return a map of OpenAPI extensions or null.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a single OpenAPI extension to this link.
     *
     * @param name  the name of the extension (must start with {@code x-}).
     * @param value the value of the extension.
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)){
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (this.extensions == null)
            this.extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }
    /**
     * Sets the entire extensions map for this link.
     *
     * @param extensions a map containing extension keys and values.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Fluent method to set all OpenAPI extensions.
     *
     * @param extensions a map of OpenAPI extensions.
     * @return the current {@link Link} instance.
     */
    public Link extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    /**
     * Returns the operation ID associated with this link.
     *
     * @return the operation ID or null.
     */
    public String getOperationId() {
        return operationId;
    }
    /**
     * Sets the operation ID of the linked operation.
     *
     * @param operationId the operation ID to reference.
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
    /**
     * Fluent method to set the operation ID.
     *
     * @param operationId the operation ID to reference.
     * @return the current {@link Link} instance.
     */
    public Link operationId(String operationId) {
        this.operationId = operationId;
        return this;
    }

    /**
     * Returns the parameters map for this link.
     *
     * @return a map of parameter names and runtime expressions.
     */
    public Map<String, String> getParameters() {
        return parameters;
    }
    /**
     * Sets the parameters map for this link.
     *
     * @param parameters a map of parameter names and values.
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
    /**
     * Adds a parameter to the parameters map.
     *
     * @param name     the parameter name.
     * @param parameter the runtime expression to assign.
     * @return the current {@link Link} instance.
     */
    public Link parameters(String name, String parameter) {
        return this.addParameter(name, parameter);
    }
    /**
     * Adds a parameter to the link. Initializes the map if it is null.
     *
     * @param name      the parameter name.
     * @param parameter the runtime expression as a value.
     * @return the current {@link Link} instance.
     */
    public Link addParameter(String name, String parameter) {
        if (Objects.isNull(this.parameters))
            this.parameters = new LinkedHashMap<>();
        this.parameters.put(name, parameter);
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Link link = (Link) object;
        return Objects.equals(operationRef, link.operationRef) &&
               Objects.equals(operationId, link.operationId) &&
               Objects.equals(parameters, link.parameters) &&
               Objects.equals(requestBody, link.requestBody) &&
               Objects.equals(description, link.description) &&
               Objects.equals($ref, link.$ref) &&
               Objects.equals(extensions, link.extensions) &&
               Objects.equals(server, link.server);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationRef, operationId, parameters, requestBody, description, $ref, extensions, server);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Link {\n");
        sb.append("    operationRef: ").append(toIndentedString(operationRef)).append("\n");
        sb.append("    operationId: ").append(toIndentedString(operationId)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    requestBody: ").append(toIndentedString(requestBody)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}