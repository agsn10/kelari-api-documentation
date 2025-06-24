package io.github.kelari.model.v3.operations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kelari.model.v3.ExternalDocumentation;
import io.github.kelari.model.v3.callbacks.Callback;
import io.github.kelari.model.v3.parameters.Parameter;
import io.github.kelari.model.v3.parameters.RequestBody;
import io.github.kelari.model.v3.responses.ApiResponses;
import io.github.kelari.model.v3.security.SecurityRequirement;
import io.github.kelari.model.v3.servers.Server;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

/**
 * Represents the {@code Operation} object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code Operation} object defines a single API operation on a path, including metadata like tags,
 * summary, description, parameters, request body, responses, callbacks, and security requirements.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Operation operation = new Operation()
 *     .operationId("createUser")
 *     .summary("Create a new user")
 *     .description("This operation creates a new user in the system.")
 *     .tags(List.of("user"))
 *     .requestBody(new RequestBody().description("User object"))
 *     .responses(new ApiResponses().addApiResponse("200", new ApiResponse().description("Success")))
 *     .deprecated(false);
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * paths:
 *   /users:
 *     post:
 *       tags:
 *         - user
 *       summary: Create a new user
 *       description: This operation creates a new user in the system.
 *       operationId: createUser
 *       requestBody:
 *         description: User object
 *       responses:
 *         '200':
 *           description: Success
 *       deprecated: false
 * </pre>
 *
 * <p>
 * This class encapsulates all information related to an API operation, including request and response data,
 * external documentation, security requirements, vendor extensions, and server overrides.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see io.github.kelari.model.v3.parameters.Parameter
 * @see RequestBody
 * @see ApiResponses
 * @see Callback
 * @see SecurityRequirement
 * @see Server
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#operation-object">OpenAPI 3.0.1 – Operation Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Operation implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Operation.class.getName());

    private List<String> tags = null;
    private String summary = null;
    private String description = null;
    private ExternalDocumentation externalDocs = null;
    private String operationId = null;
    private List<Parameter> parameters = null;
    @JsonProperty("requestBody")
    private RequestBody requestBody = null;
    private ApiResponses responses = null;
    private Map<String, Callback> callbacks = null;
    private Boolean deprecated = null;
    private List<SecurityRequirement> security = null;
    private List<Server> servers = null;
    private Map<String, Object> extensions = null;

    /**
     * Returns the list of tags associated with the operation.
     *
     * @return a list of tag strings
     */
    public List<String> getTags() {
        return tags;
    }
    /**
     * Sets the list of tags for the operation.
     *
     * @param tags a list of tag strings
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    /**
     * Sets the tags for the operation and returns this instance for chaining.
     *
     * @param tags a list of tag strings
     * @return this {@link Operation} instance
     */
    public Operation tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Returns the short summary of the operation.
     *
     * @return the summary string
     */
    public String getSummary() {
        return summary;
    }
    /**
     * Sets the short summary of the operation.
     *
     * @param summary the summary string
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
    /**
     * Sets the summary and returns this instance for chaining.
     *
     * @param summary the summary string
     * @return this {@link Operation} instance
     */
    public Operation summary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Returns the detailed description of the operation.
     *
     * @return the description string
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the detailed description of the operation.
     *
     * @param description the description string
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Sets the description and returns this instance for chaining.
     *
     * @param description the description string
     * @return this {@link Operation} instance
     */
    public Operation description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the external documentation reference.
     *
     * @return an {@link ExternalDocumentation} instance
     */
    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }
    /**
     * Sets the external documentation for the operation.
     *
     * @param externalDocs an {@link ExternalDocumentation} instance
     */
    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }
    /**
     * Sets the external documentation and returns this instance for chaining.
     *
     * @param externalDocs an {@link ExternalDocumentation} instance
     * @return this {@link Operation} instance
     */
    public Operation externalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
        return this;
    }

    /**
     * Returns the unique operation ID.
     *
     * @return the operation ID string
     */
    public String getOperationId() {
        return operationId;
    }
    /**
     * Sets the unique operation ID.
     *
     * @param operationId the operation ID string
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
    /**
     * Sets the operation ID and returns this instance for chaining.
     *
     * @param operationId the operation ID string
     * @return this {@link Operation} instance
     */
    public Operation operationId(String operationId) {
        this.operationId = operationId;
        return this;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }
    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }
    public Operation requestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public ApiResponses getResponses() {
        return responses;
    }
    public void setResponses(ApiResponses responses) {
        this.responses = responses;
    }

    public Map<String, Callback> getCallbacks() {
        return callbacks;
    }
    public void setCallbacks(Map<String, Callback> callbacks) {
        this.callbacks = callbacks;
    }

    public Boolean getDeprecated() {
        return deprecated;
    }
    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }
    public Operation deprecated(Boolean deprecated) {
        this.deprecated = deprecated;
        return this;
    }

    public List<SecurityRequirement> getSecurity() {
        return security;
    }
    public void setSecurity(List<SecurityRequirement> security) {
        this.security = security;
    }
    public Operation security(SecurityRequirement security) {
        if(Objects.isNull(this.security))
            this.security = new ArrayList<>(0);
        this.security.add(security);
        return this;
    }

    public List<Server> getServers() {
        return servers;
    }
    /**
     * Sets the list of servers for this operation.
     *
     * @param servers a list of {@link Server} instances
     */
    public void setServers(List<Server> servers) {
        this.servers = servers;
    }
    /**
     * Sets the list of servers and returns this instance for chaining.
     *
     * @param servers a list of {@link Server} instances
     * @return this {@link Operation} instance
     */
    public Operation servers(List<Server> servers) {
        this.servers = servers;
        return this;
    }
    /**
     * Adds a single server to the list and returns this instance for chaining.
     *
     * @param serversItem a {@link Server} instance to add
     * @return this {@link Operation} instance
     */
    public Operation addServersItem(Server serversItem) {
        if (Objects.isNull(this.servers))
            this.servers = new ArrayList<>();
        this.servers.add(serversItem);
        return this;
    }

    /**
     * Adds a vendor extension (key starting with "x-") to the extensions map.
     *
     * @param name the name of the extension property
     * @param value the value of the extension property
     * @return the updated {@code PathItem} instance
     */
    public Operation extensions(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return this;
        }
        if(Objects.isNull(extensions))
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
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Operation {\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    externalDocs: ").append(toIndentedString(externalDocs)).append("\n");
        sb.append("    operationId: ").append(toIndentedString(operationId)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    requestBody: ").append(toIndentedString(requestBody)).append("\n");
        sb.append("    responses: ").append(toIndentedString(responses)).append("\n");
        sb.append("    callbacks: ").append(toIndentedString(callbacks)).append("\n");
        sb.append("    deprecated: ").append(toIndentedString(deprecated)).append("\n");
        sb.append("    security: ").append(toIndentedString(security)).append("\n");
        sb.append("    servers: ").append(toIndentedString(servers)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        Operation operation = (Operation) object;
        return Objects.equals(tags, operation.tags) &&
               Objects.equals(summary, operation.summary) &&
               Objects.equals(description, operation.description) &&
               Objects.equals(externalDocs, operation.externalDocs) &&
               Objects.equals(operationId, operation.operationId) &&
               Objects.equals(parameters, operation.parameters) &&
               Objects.equals(requestBody, operation.requestBody) &&
               Objects.equals(responses, operation.responses) &&
               Objects.equals(callbacks, operation.callbacks) &&
               Objects.equals(deprecated, operation.deprecated) &&
               Objects.equals(security, operation.security) &&
               Objects.equals(servers, operation.servers) &&
               Objects.equals(extensions, operation.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags, summary, description, externalDocs, operationId, parameters, requestBody, responses, callbacks, deprecated, security, servers, extensions);
    }
}