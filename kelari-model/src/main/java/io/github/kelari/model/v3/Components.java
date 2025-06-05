package io.github.kelari.model.v3;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.callbacks.Callback;
import io.github.kelari.model.v3.examples.Example;
import io.github.kelari.model.v3.headers.Header;
import io.github.kelari.model.v3.links.Link;
import io.github.kelari.model.v3.media.Schema;
import io.github.kelari.model.v3.parameters.Parameter;
import io.github.kelari.model.v3.parameters.RequestBody;
import io.github.kelari.model.v3.paths.PathItem;
import io.github.kelari.model.v3.responses.ApiResponse;
import io.github.kelari.model.v3.security.SecurityScheme;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;


/**
 * Represents the components section of an OpenAPI specification.
 * This includes definitions for schemas, responses, parameters, examples, request bodies, headers,
 * security schemes, links, callbacks, and other OpenAPI components.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 * */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Components implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Components.class.getName());

    /**
     * Prefix used for schema references.
     */
    public static final String COMPONENTS_SCHEMAS_REF = "#/components/schemas/";

    private Map<String, Schema> schemas = null;
    private Map<String, ApiResponse> responses = null;
    private Map<String, Parameter> parameters = null;
    private Map<String, Example> examples = null;
    private Map<String, RequestBody> requestBodies = null;
    private Map<String, Header> headers = null;
    private Map<String, SecurityScheme> securitySchemes = null;
    private Map<String, Link> links = null;
    private Map<String, Callback> callbacks = null;
    private Map<String, Object> extensions = null;
    private Map<String, PathItem> pathItems;

    /**
     * Gets the schema definitions.
     */
    public Map<String, Schema> getSchemas() {
        return schemas;
    }

    /**
     * Sets the schema definitions.
     */
    public void setSchemas(Map<String, Schema> schemas) {
        this.schemas = schemas;
    }

    /**
     * Fluent setter for schema definitions.
     */
    public Components schemas(Map<String, Schema> schemas) {
        this.schemas = schemas;
        return this;
    }

    /**
     * Adds a single schema to the collection.
     */
    public Components addSchemas(String key, Schema schemasItem) {
        if (this.schemas == null) this.schemas = new LinkedHashMap<>();
        this.schemas.put(key, schemasItem);
        return this;
    }

    /**
     * Gets the API response definitions.
     */
    public Map<String, ApiResponse> getResponses() {
        return responses;
    }

    /**
     * Sets the API response definitions.
     */
    public void setResponses(Map<String, ApiResponse> responses) {
        this.responses = responses;
    }

    /**
     * Fluent setter for API response definitions.
     */
    public Components responses(Map<String, ApiResponse> responses) {
        this.responses = responses;
        return this;
    }

    /**
     * Adds a single response definition.
     */
    public Components addResponses(String key, ApiResponse responsesItem) {
        if (this.responses == null) this.responses = new LinkedHashMap<>();
        this.responses.put(key, responsesItem);
        return this;
    }

    /**
     * Gets the parameter definitions.
     */
    public Map<String, Parameter> getParameters() {
        return parameters;
    }

    /**
     * Sets the parameter definitions.
     */
    public void setParameters(Map<String, Parameter> parameters) {
        this.parameters = parameters;
    }

    /**
     * Fluent setter for parameter definitions.
     */
    public Components parameters(Map<String, Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Adds a single parameter definition.
     */
    public Components addParameters(String key, Parameter parametersItem) {
        if (this.parameters == null) this.parameters = new LinkedHashMap<>();
        this.parameters.put(key, parametersItem);
        return this;
    }

    /**
     * Gets the example definitions.
     */
    public Map<String, Example> getExamples() {
        return examples;
    }

    /**
     * Sets the example definitions.
     */
    public void setExamples(Map<String, Example> examples) {
        this.examples = examples;
    }

    /**
     * Fluent setter for example definitions.
     */
    public Components examples(Map<String, Example> examples) {
        this.examples = examples;
        return this;
    }

    /**
     * Adds a single example definition.
     */
    public Components addExamples(String key, Example examplesItem) {
        if (this.examples == null) this.examples = new LinkedHashMap<>();
        this.examples.put(key, examplesItem);
        return this;
    }

    /**
     * Gets the request body definitions.
     */
    public Map<String, RequestBody> getRequestBodies() {
        return requestBodies;
    }

    /**
     * Sets the request body definitions.
     */
    public void setRequestBodies(Map<String, RequestBody> requestBodies) {
        this.requestBodies = requestBodies;
    }

    /**
     * Fluent setter for request body definitions.
     */
    public Components requestBodies(Map<String, RequestBody> requestBodies) {
        this.requestBodies = requestBodies;
        return this;
    }

    /**
     * Adds a single request body definition.
     */
    public Components addRequestBodies(String key, RequestBody requestBodiesItem) {
        if (this.requestBodies == null) this.requestBodies = new LinkedHashMap<>();
        this.requestBodies.put(key, requestBodiesItem);
        return this;
    }

    /**
     * Gets the header definitions.
     */
    public Map<String, Header> getHeaders() {
        return headers;
    }

    /**
     * Sets the header definitions.
     */
    public void setHeaders(Map<String, Header> headers) {
        this.headers = headers;
    }

    /**
     * Fluent setter for header definitions.
     */
    public Components headers(Map<String, Header> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Adds a single header definition.
     */
    public Components addHeaders(String key, Header headersItem) {
        if (this.headers == null) this.headers = new LinkedHashMap<>();
        this.headers.put(key, headersItem);
        return this;
    }

    /**
     * Gets the security scheme definitions.
     */
    public Map<String, SecurityScheme> getSecuritySchemes() {
        return securitySchemes;
    }

    /**
     * Sets the security scheme definitions.
     */
    public void setSecuritySchemes(Map<String, SecurityScheme> securitySchemes) {
        this.securitySchemes = securitySchemes;
    }

    /**
     * Fluent setter for security scheme definitions.
     */
    public Components securitySchemes(Map<String, SecurityScheme> securitySchemes) {
        this.securitySchemes = securitySchemes;
        return this;
    }

    /**
     * Adds a single security scheme definition.
     */
    public Components addSecuritySchemes(String key, SecurityScheme securitySchemesItem) {
        if (this.securitySchemes == null) this.securitySchemes = new LinkedHashMap<>();
        this.securitySchemes.put(key, securitySchemesItem);
        return this;
    }

    /**
     * Gets the link definitions.
     */
    public Map<String, Link> getLinks() {
        return links;
    }

    /**
     * Sets the link definitions.
     */
    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }

    /**
     * Fluent setter for link definitions.
     */
    public Components links(Map<String, Link> links) {
        this.links = links;
        return this;
    }

    /**
     * Adds a single link definition.
     */
    public Components addLinks(String key, Link linksItem) {
        if (this.links == null) this.links = new LinkedHashMap<>();
        this.links.put(key, linksItem);
        return this;
    }

    /**
     * Gets the callback definitions.
     */
    public Map<String, Callback> getCallbacks() {
        return callbacks;
    }

    /**
     * Sets the callback definitions.
     */
    public void setCallbacks(Map<String, Callback> callbacks) {
        this.callbacks = callbacks;
    }

    /**
     * Fluent setter for callback definitions.
     */
    public Components callbacks(Map<String, Callback> callbacks) {
        this.callbacks = callbacks;
        return this;
    }

    /**
     * Adds a single callback definition.
     */
    public Components addCallbacks(String key, Callback callbacksItem) {
        if (this.callbacks == null) this.callbacks = new LinkedHashMap<>();
        this.callbacks.put(key, callbacksItem);
        return this;
    }

    /**
     * Gets the specification extensions.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    /**
     * Sets the specification extensions.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    /**
     * Adds a custom extension to the component.
     *
     * @param name  the extension key, must start with "x-"
     * @param value the extension value
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (Objects.isNull(extensions))
            extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }

    /**
     * Gets the path item definitions.
     */
    public Map<String, PathItem> getPathItems() {
        return pathItems;
    }

    /**
     * Sets the path item definitions.
     */
    public void setPathItems(Map<String, PathItem> pathItems) {
        this.pathItems = pathItems;
    }

    /**
     * Fluent setter for path item definitions.
     */
    public Components pathItems(Map<String, PathItem> pathItems) {
        this.pathItems = pathItems;
        return this;
    }

    /**
     * Adds a single path item definition.
     */
    public Components addPathItem(String key, PathItem pathItem) {
        if (this.pathItems == null) this.pathItems = new LinkedHashMap<>();
        this.pathItems.put(key, pathItem);
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        Components that = (Components) object;
        return Objects.equals(schemas, that.schemas) &&
                Objects.equals(responses, that.responses) &&
                Objects.equals(parameters, that.parameters) &&
                Objects.equals(examples, that.examples) &&
                Objects.equals(requestBodies, that.requestBodies) &&
                Objects.equals(headers, that.headers) &&
                Objects.equals(securitySchemes, that.securitySchemes) &&
                Objects.equals(links, that.links) &&
                Objects.equals(callbacks, that.callbacks) &&
                Objects.equals(extensions, that.extensions) &&
                Objects.equals(pathItems, that.pathItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schemas, responses, parameters, examples, requestBodies, headers, securitySchemes, links, callbacks, extensions, pathItems);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Components {\n");
        sb.append("    schemas: ").append(toIndentedString(schemas)).append("\n");
        sb.append("    responses: ").append(toIndentedString(responses)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    examples: ").append(toIndentedString(examples)).append("\n");
        sb.append("    requestBodies: ").append(toIndentedString(requestBodies)).append("\n");
        sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
        sb.append("    securitySchemes: ").append(toIndentedString(securitySchemes)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    callbacks: ").append(toIndentedString(callbacks)).append("\n");
        sb.append("    pathItems: ").append(toIndentedString(pathItems)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
