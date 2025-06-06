package io.github.kelari.model.v3.paths;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kelari.model.v3.enums.HttpMethodEnum;
import io.github.kelari.model.v3.operations.Operation;
import io.github.kelari.model.v3.parameters.Parameter;
import io.github.kelari.model.v3.servers.Server;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Describes the operations available on a single path.
 * <p>
 * A {@code PathItem} may be empty due to ACL constraints.
 * The path itself is still exposed to the documentation viewer, but the operations and parameters
 * are not visible to the user.
 * </p>
 *
 * <p>
 * This object follows the structure defined in the OpenAPI 3.0.1 specification.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * PathItem pathItem = new PathItem()
 *     .get(new Operation()
 *         .summary("Returns user by ID")
 *         .operationId("getUserById")
 *         .responses(new ApiResponses()
 *             .addApiResponse("200", new ApiResponse()
 *                 .description("Successful response")
 *                 .content(new Content()
 *                     .addMediaType("application/json", new MediaType()
 *                         .schema(new Schema<>()
 *                             .type("object")
 *                             .addProperties("id", new Schema<>().type("integer"))
 *                             .addProperties("name", new Schema<>().type("string"))
 *                         ))))));
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * paths:
 *   /user/{id}:
 *     get:
 *       summary: Returns user by ID
 *       operationId: getUserById
 *       responses:
 *         '200':
 *           description: Successful response
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   id:
 *                     type: integer
 *                   name:
 *                     type: string
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#pathItemObject">OpenAPI 3.0.1 – PathItem Object</a>
 * @see Operation
 * @see Server
 * @see Parameter
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathItem implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(PathItem.class.getName());

    private String summary = null;
    private String description = null;
    private Operation get = null;
    private Operation put = null;
    private Operation post = null;
    private Operation delete = null;
    private Operation options = null;
    private Operation head = null;
    private Operation patch = null;
    private Operation trace = null;
    private List<Server> servers = null;
    private List<Parameter> parameters = null;
    @JsonProperty("$ref")
    private String $ref = null;
    private Map<String, Object> extensions = null;

    /**
     * Returns the short summary of the path.
     *
     * @return the summary text
     */
    public String getSummary() {
        return summary;
    }
    /**
     * Sets the short summary of the path.
     *
     * @param summary the summary text
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
    /**
     * Fluent setter for the path summary.
     *
     * @param summary the summary text
     * @return this {@code PathItem} instance
     */
    public PathItem summary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Returns the description of the path.
     *
     * @return the description text
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the path.
     *
     * @param description the description text
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Fluent setter for the path description.
     *
     * @param description the description text
     * @return this {@code PathItem} instance
     */
    public PathItem description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the GET operation.
     *
     * @return the GET {@link Operation}
     */
    public Operation getGet() {
        return get;
    }
    /**
     * Sets the GET operation.
     *
     * @param get the GET {@link Operation}
     */
    public void setGet(Operation get) {
        this.get = get;
    }
    /**
     * Fluent setter for the GET operation.
     *
     * @param get the GET {@link Operation}
     * @return this {@code PathItem} instance
     */
    public PathItem get(Operation get) {
        this.get = get;
        return this;
    }

    /**
     *  Returns the PUT operation.
     * */
    public Operation getPut() { return put; }
    /**
     * Sets the PUT operation.
     * */
    public void setPut(Operation put) { this.put = put; }
    /**
     * Fluent setter for the PUT operation.
     * */
    public PathItem put(Operation put) { this.put = put; return this; }

    /**
     * Returns the POST operation.
     * */
    public Operation getPost() { return post; }
    /**
     * Sets the POST operation.
     * */
    public void setPost(Operation post) { this.post = post; }
    /**
     * Fluent setter for the POST operation.
     * */
    public PathItem post(Operation post) { this.post = post; return this; }

    /**
     * Returns the DELETE operation.
     * */
    public Operation getDelete() { return delete; }
    /**
     * Sets the DELETE operation.
     * */
    public void setDelete(Operation delete) { this.delete = delete; }
    /**
     * Fluent setter for the DELETE operation.
     * */
    public PathItem delete(Operation delete) { this.delete = delete; return this; }

    /**
     * Returns the OPTIONS operation.
     * */
    public Operation getOptions() { return options; }
    /**
     * Sets the OPTIONS operation.
     * */
    public void setOptions(Operation options) { this.options = options; }
    /**
     * Fluent setter for the OPTIONS operation.
     * */
    public PathItem options(Operation options) { this.options = options; return this; }

    /**
     * Returns the HEAD operation.
     * */
    public Operation getHead() { return head; }
    /**
     * Sets the HEAD operation.
     * */
    public void setHead(Operation head) { this.head = head; }
    /**
     * Fluent setter for the HEAD operation.
     * */
    public PathItem head(Operation head) { this.head = head; return this; }

    /**
     * Returns the PATCH operation.
     * */
    public Operation getPatch() { return patch; }
    /**
     * Sets the PATCH operation.
     * */
    public void setPatch(Operation patch) { this.patch = patch; }
    /**
     * Fluent setter for the PATCH operation.
     * */
    public PathItem patch(Operation patch) { this.patch = patch; return this; }

    /**
     * Returns the TRACE operation.
     * */
    public Operation getTrace() { return trace; }
    /**
     * Sets the TRACE operation.
     * */
    public void setTrace(Operation trace) { this.trace = trace; }
    /**
     * Fluent setter for the TRACE operation.
     * */
    public PathItem trace(Operation trace) { this.trace = trace; return this; }

    /**
     * Returns all defined operations for this path.
     *
     * @return a list of {@link Operation} objects
     */
    public List<Operation> readOperations() {
        return Stream.of(get, put, head, post, delete, patch, options, trace)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
    /**
     * Sets the operation for a given HTTP method.
     *
     * @param method    the HTTP method
     * @param operation the operation to associate with the method
     */
    public void operation(HttpMethodEnum method, Operation operation) {
        Map<HttpMethodEnum, BiConsumer<PathItem, Operation>> OPERATION_SETTERS = Map.of(
                HttpMethodEnum.GET, (obj, op) -> obj.get = op,
                HttpMethodEnum.PUT, (obj, op) -> obj.put = op,
                HttpMethodEnum.POST, (obj, op) -> obj.post = op,
                HttpMethodEnum.PATCH, (obj, op) -> obj.patch = op,
                HttpMethodEnum.DELETE, (obj, op) -> obj.delete = op,
                HttpMethodEnum.HEAD, (obj, op) -> obj.head = op,
                HttpMethodEnum.OPTIONS, (obj, op) -> obj.options = op,
                HttpMethodEnum.TRACE, (obj, op) -> obj.trace = op
        );
        OPERATION_SETTERS.get(method).accept(this, operation);
    }
    /**
     * Returns all defined operations as a map keyed by HTTP method.
     *
     * @return a map of HTTP methods to their {@link Operation} instances
     */
    public Map<HttpMethodEnum, Operation> readOperationsMap() {
        return Stream.of(
                        new AbstractMap.SimpleEntry<>(HttpMethodEnum.GET, this.get),
                        new AbstractMap.SimpleEntry<>(HttpMethodEnum.PUT, this.put),
                        new AbstractMap.SimpleEntry<>(HttpMethodEnum.POST, this.post),
                        new AbstractMap.SimpleEntry<>(HttpMethodEnum.DELETE, this.delete),
                        new AbstractMap.SimpleEntry<>(HttpMethodEnum.PATCH, this.patch),
                        new AbstractMap.SimpleEntry<>(HttpMethodEnum.HEAD, this.head),
                        new AbstractMap.SimpleEntry<>(HttpMethodEnum.OPTIONS, this.options),
                        new AbstractMap.SimpleEntry<>(HttpMethodEnum.TRACE, this.trace)
                )
                .filter(entry -> Objects.nonNull(entry.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> b,
                        LinkedHashMap::new
                ));
    }

    /**
     * Returns the list of servers associated with this path.
     *
     * @return the list of {@link Server} instances
     */
    public List<Server> getServers() {
        return servers;
    }
    /**
     * Sets the list of servers for this path.
     *
     * @param servers the list of {@link Server} instances
     */
    public void setServers(List<Server> servers) {
        this.servers = servers;
    }
    /**
     * Fluent setter for the server list.
     *
     * @param servers the list of {@link Server} instances
     * @return this {@code PathItem} instance
     */
    public PathItem servers(List<Server> servers) {
        this.servers = servers;
        return this;
    }
    /**
     * Adds a single server to the server list.
     *
     * @param serversItem a {@link Server} to add
     * @return this {@code PathItem} instance
     */
    public PathItem addServersItem(Server serversItem) {
        if (Objects.isNull(this.servers))
            this.servers = new ArrayList<>();
        this.servers.add(serversItem);
        return this;
    }

    /**
     * Returns the list of parameters associated with this path.
     *
     * @return the list of {@link Parameter} instances
     */
    public List<Parameter> getParameters() {
        return parameters;
    }
    /**
     * Sets the list of parameters for this path.
     *
     * @param parameters the list of {@link Parameter} instances
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
    /**
     * Fluent setter for the parameter list.
     *
     * @param parameters the list of {@link Parameter} instances
     * @return this {@code PathItem} instance
     */
    public PathItem parameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }
    /**
     * Adds a single parameter to the parameter list.
     *
     * @param parametersItem a {@link Parameter} to add
     * @return this {@code PathItem} instance
     */
    public PathItem addParametersItem(Parameter parametersItem) {
        if (Objects.isNull(this.parameters))
            this.parameters = new ArrayList<>();
        this.parameters.add(parametersItem);
        return this;
    }

    /**
     * Returns the reference string to an external definition.
     *
     * @return the reference string
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the reference string to an external definition.
     *
     * @param $ref the reference string
     */
    public void set$ref(String $ref) {
        this.$ref = $ref;
    }
    /**
     * Fluent setter for the reference.
     *
     * @param $ref the reference string
     * @return this {@code PathItem} instance
     */
    public PathItem $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /**
     * Adds a vendor extension (key starting with "x-") to the extensions map.
     *
     * @param name the name of the extension property
     * @param value the value of the extension property
     * @return the updated {@code PathItem} instance
     */
    public PathItem extensions(String name, Object value) {
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
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        PathItem pathItem = (PathItem) object;
        return Objects.equals(summary, pathItem.summary) &&
               Objects.equals(description, pathItem.description) &&
               Objects.equals(get, pathItem.get) &&
               Objects.equals(put, pathItem.put) &&
               Objects.equals(post, pathItem.post) &&
               Objects.equals(delete, pathItem.delete) &&
               Objects.equals(options, pathItem.options) &&
               Objects.equals(head, pathItem.head) &&
               Objects.equals(patch, pathItem.patch) &&
               Objects.equals(trace, pathItem.trace) &&
               Objects.equals(servers, pathItem.servers) &&
               Objects.equals(parameters, pathItem.parameters) &&
               Objects.equals($ref, pathItem.$ref) &&
               Objects.equals(extensions, pathItem.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(summary, description, get, put, post, delete, options, head, patch, trace, servers, parameters, $ref, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PathItem {\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    get: ").append(toIndentedString(get)).append("\n");
        sb.append("    put: ").append(toIndentedString(put)).append("\n");
        sb.append("    post: ").append(toIndentedString(post)).append("\n");
        sb.append("    delete: ").append(toIndentedString(delete)).append("\n");
        sb.append("    options: ").append(toIndentedString(options)).append("\n");
        sb.append("    head: ").append(toIndentedString(head)).append("\n");
        sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
        sb.append("    trace: ").append(toIndentedString(trace)).append("\n");
        sb.append("    servers: ").append(toIndentedString(servers)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}