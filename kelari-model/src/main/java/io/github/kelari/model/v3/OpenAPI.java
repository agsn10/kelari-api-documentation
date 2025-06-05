package io.github.kelari.model.v3;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.info.Info;
import io.github.kelari.model.v3.media.Schema;
import io.github.kelari.model.v3.paths.PathItem;
import io.github.kelari.model.v3.paths.Paths;
import io.github.kelari.model.v3.security.SecurityRequirement;
import io.github.kelari.model.v3.security.SecurityScheme;
import io.github.kelari.model.v3.servers.Server;
import io.github.kelari.model.v3.tags.Tag;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

/**
 * Represents an OpenAPI 3.0.1 specification.
 * <p>
 * The {@code OpenAPI} class is used to define the structure of an OpenAPI 3.0.1 document.
 * It includes information about the API such as metadata, servers, security, paths, components, and other related details.
 * The class provides methods for setting and getting various parts of the OpenAPI specification.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * OpenAPI openAPI = new OpenAPI()
 *     .openapi("3.0.1")
 *     .info(new Info().title("My API").version("1.0"))
 *     .servers(Arrays.asList(new Server().url("https://api.example.com")))
 *     .paths(new Paths());
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * openapi: 3.0.1
 * info:
 *   title: My API
 *   version: 1.0
 * servers:
 *   - url: https://api.example.com
 * paths: {}
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Info
 * @see Server
 * @see Paths
 * @see Components
 * @see SecurityRequirement
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#openapi-object">OpenAPI 3.0.1 – OpenAPI Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#info-object">OpenAPI 3.0.1 – Info Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#server-object">OpenAPI 3.0.1 – Server Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#path-item-object">OpenAPI 3.0.1 – Path Item Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenAPI implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(OpenAPI.class.getName());

    private String openapi = "3.0.1";
    private Info info = null;
    private ExternalDocumentation externalDocs = null;
    private List<Server> servers = null;
    private List<SecurityRequirement> security = null;
    private List<Tag> tags = null;
    private Paths paths = null;
    private Components components = null;
    private Map<String, Object> extensions = null;

    private String jsonSchemaDialect;

    private Map<String, PathItem> webhooks = null;

    /**
     * Gets the OpenAPI version.
     * @return the OpenAPI version.
     */
    public String getOpenapi() {
        return openapi;
    }
    /**
     * Sets the OpenAPI version.
     * @param openapi the OpenAPI version to set.
     */
    public void setOpenapi(String openapi) {
        this.openapi = openapi;
    }
    /**
     * Sets the OpenAPI version and returns the OpenAPI object.
     * @param openapi the OpenAPI version to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI openapi(String openapi) {
        this.openapi = openapi;
        return this;
    }

    /**
     * Gets the API information.
     * @return the API info.
     */
    public Info getInfo() {
        return info;
    }
    /**
     * Sets the API information.
     * @param info the API info to set.
     */
    public void setInfo(Info info) {
        this.info = info;
    }
    /**
     * Sets the API information and returns the OpenAPI object.
     * @param info the API info to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI info(Info info) {
        this.info = info;
        return this;
    }

    /**
     * Gets the external documentation.
     * @return the external documentation.
     */
    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }
    /**
     * Sets the external documentation.
     * @param externalDocs the external documentation to set.
     */
    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }
    /**
     * Sets the external documentation and returns the OpenAPI object.
     * @param externalDocs the external documentation to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI externalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
        return this;
    }

    /**
     * Gets the list of servers.
     * @return the list of servers.
     */
    public List<Server> getServers() {
        return servers;
    }
    /**
     * Sets the list of servers.
     * @param servers the list of servers to set.
     */
    public void setServers(List<Server> servers) {
        this.servers = servers;
    }
    /**
     * Sets the list of servers and returns the OpenAPI object.
     * @param servers the list of servers to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI servers(List<Server> servers) {
        this.servers = servers;
        return this;
    }
    /**
     * Adds a server to the list of servers.
     * @param serversItem the server to add.
     * @return the current OpenAPI object.
     */
    public OpenAPI addServersItem(Server serversItem) {
        if (Objects.isNull(this.servers))
            this.servers = new ArrayList<>();
        this.servers.add(serversItem);
        return this;
    }

    /**
     * Gets the list of security requirements.
     * @return the list of security requirements.
     */
    public List<SecurityRequirement> getSecurity() {
        return security;
    }
    /**
     * Sets the list of security requirements.
     * @param security the list of security requirements to set.
     */
    public void setSecurity(List<SecurityRequirement> security) {
        this.security = security;
    }
    /**
     * Sets the list of security requirements and returns the OpenAPI object.
     * @param security the list of security requirements to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI security(List<SecurityRequirement> security) {
        this.security = security;
        return this;
    }
    /**
     * Adds a security requirement to the list of security requirements.
     * @param securityItem the security requirement to add.
     * @return the current OpenAPI object.
     */
    public OpenAPI addSecurityItem(SecurityRequirement securityItem) {
        if (Objects.isNull(this.security))
            this.security = new ArrayList<>();
        this.security.add(securityItem);
        return this;
    }

    /**
     * Gets the list of tags.
     * @return the list of tags.
     */
    public List<Tag> getTags() {
        return tags;
    }
    /**
     * Sets the list of tags.
     * @param tags the list of tags to set.
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    /**
     * Sets the list of tags and returns the OpenAPI object.
     * @param tags the list of tags to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI tags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }
    /**
     * Adds a tag to the list of tags.
     * @param tagsItem the tag to add.
     * @return the current OpenAPI object.
     */
    public OpenAPI addTagsItem(Tag tagsItem) {
        if (Objects.isNull(this.tags))
            this.tags = new ArrayList<>();
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Gets the paths.
     * @return the paths.
     */
    public Paths getPaths() {
        return paths;
    }
    /**
     * Sets the paths.
     * @param paths the paths to set.
     */
    public void setPaths(Paths paths) {
        this.paths = paths;
    }
    /**
     * Sets the paths and returns the OpenAPI object.
     * @param paths the paths to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI paths(Paths paths) {
        this.paths = paths;
        return this;
    }

    /**
     * Gets the components of the OpenAPI.
     * @return the components.
     */
    public Components getComponents() {
        return components;
    }
    /**
     * Sets the components of the OpenAPI.
     * @param components the components to set.
     */
    public void setComponents(Components components) {
        this.components = components;
    }
    /**
     * Sets the components and returns the OpenAPI object.
     * @param components the components to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI components(Components components) {
        this.components = components;
        return this;
    }

    /**
     * Adds a path item to the OpenAPI specification.
     * @param name the name of the path.
     * @param path the PathItem to add.
     * @return the current OpenAPI object.
     */
    public OpenAPI path(String name, PathItem path) {
        if (Objects.isNull(this.paths))
            this.paths = new Paths();
        this.paths.addPathItem(name, path);
        return this;
    }

    /**
     * Adds a schema to the components of the OpenAPI specification.
     * @param name the name of the schema.
     * @param schema the Schema to add.
     * @return the current OpenAPI object.
     */
    public OpenAPI schema(String name, Schema schema) {
        if (Objects.isNull(components))
            this.components = new Components();
        components.addSchemas(name, schema);
        return this;
    }

    /**
     * Adds a security scheme to the components of the OpenAPI specification.
     * @param name the name of the security scheme.
     * @param securityScheme the SecurityScheme to add.
     * @return the current OpenAPI object.
     */
    public OpenAPI schemaRequirement(String name, SecurityScheme securityScheme) {
        if (Objects.isNull(components))
            this.components = new Components();
        components.addSecuritySchemes(name, securityScheme);
        return this;
    }

    /**
     * Gets the webhooks map.
     * @return the map of webhooks.
     */
    public Map<String, PathItem> getWebhooks() {
        return webhooks;
    }
    /**
     * Sets the webhooks map.
     * @param webhooks the map of webhooks to set.
     */
    public void setWebhooks(Map<String, PathItem> webhooks) {
        this.webhooks = webhooks;
    }
    /**
     * Sets the webhooks map and returns the OpenAPI object.
     * @param webhooks the map of webhooks to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI webhooks(Map<String, PathItem> webhooks) {
        this.webhooks = webhooks;
        return this;
    }
    /**
     * Adds a webhook to the webhooks map.
     * @param key the key of the webhook.
     * @param pathItem the PathItem to add.
     * @return the current OpenAPI object.
     */
    public OpenAPI addWebhooks(String key, PathItem pathItem) {
        if (Objects.isNull(this.webhooks))
            this.webhooks = new LinkedHashMap<>();
        this.webhooks.put(key, pathItem);
        return this;
    }

    /**
     * Gets the JSON Schema Dialect.
     * @return the JSON Schema Dialect.
     */
    public String getJsonSchemaDialect() {
        return jsonSchemaDialect;
    }
    /**
     * Sets the JSON Schema Dialect.
     * @param jsonSchemaDialect the JSON Schema Dialect to set.
     */
    public void setJsonSchemaDialect(String jsonSchemaDialect) {
        this.jsonSchemaDialect = jsonSchemaDialect;
    }
    /**
     * Sets the JSON Schema Dialect and returns the OpenAPI object.
     * @param jsonSchemaDialect the JSON Schema Dialect to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI jsonSchemaDialect(String jsonSchemaDialect) {
        this.jsonSchemaDialect = jsonSchemaDialect;
        return this;
    }

    /**
     * Gets the extensions map.
     * @return the map of extensions.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds an extension to the OpenAPI specification.
     * @param name the name of the extension.
     * @param value the value of the extension.
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
    /**
     * Sets the extensions map.
     * @param extensions the extensions to set.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Sets the extensions map and returns the OpenAPI object.
     * @param extensions the extensions to set.
     * @return the current OpenAPI object.
     */
    public OpenAPI extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    /**
     * Checks if two OpenAPI objects are equal.
     * @param object the object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object)  || getClass() != object.getClass()) return false;
        OpenAPI openAPI = (OpenAPI) object;
        return Objects.equals(openapi, openAPI.openapi) &&
                Objects.equals(info, openAPI.info) &&
                Objects.equals(externalDocs, openAPI.externalDocs) &&
                Objects.equals(servers, openAPI.servers) &&
                Objects.equals(security, openAPI.security) &&
                Objects.equals(tags, openAPI.tags) &&
                Objects.equals(paths, openAPI.paths) &&
                Objects.equals(components, openAPI.components) &&
                Objects.equals(extensions, openAPI.extensions) &&
                Objects.equals(jsonSchemaDialect, openAPI.jsonSchemaDialect) &&
                Objects.equals(webhooks, openAPI.webhooks);
    }

    /**
     * Generates a hash code for the OpenAPI object.
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(openapi, info, externalDocs, servers, security, tags, paths, components, extensions, jsonSchemaDialect, webhooks);
    }

    /**
     * Returns a string representation of the OpenAPI object.
     * @return the string representation of the OpenAPI object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OpenAPI {\n");
        sb.append("    openapi: ").append(toIndentedString(openapi)).append("\n");
        sb.append("    info: ").append(toIndentedString(info)).append("\n");
        sb.append("    externalDocs: ").append(toIndentedString(externalDocs)).append("\n");
        sb.append("    servers: ").append(toIndentedString(servers)).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
        sb.append("    jsonSchemaDialect: ").append(toIndentedString(jsonSchemaDialect)).append("\n");
        sb.append("    webhooks: ").append(toIndentedString(webhooks)).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

}
