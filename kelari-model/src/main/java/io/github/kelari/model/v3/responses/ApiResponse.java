package io.github.kelari.model.v3.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.headers.Header;
import io.github.kelari.model.v3.links.Link;
import io.github.kelari.model.v3.media.Content;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a response in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code ApiResponse} object describes a single response from an API operation, including
 * design-time, static links to operations based on the response. It defines the content returned
 * and any headers or links that may be associated with the response.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * ApiResponse response = new ApiResponse();
 * response.setDescription("A successful response");
 * response.setContent(new Content().addMediaType("application/json", mediaType));
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * responses:
 *   '200':
 *     description: A successful response
 *     content:
 *       application/json:
 *         schema:
 *           type: object
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Header
 * @see Link
 * @see Content
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#response-object">OpenAPI 3.0.1 – Response Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#reference-object">OpenAPI 3.0.1 – Reference Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(ApiResponse.class.getName());

    private String description = null;
    private Map<String, Header> headers = null;
    private Content content = null;
    private Map<String, Link> links = null;
    private Map<String, Object> extensions = null;
    private String $ref = null;

    /**
     * Gets the description of the API response.
     *
     * @return a human-readable description of the response.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the API response.
     *
     * @param description a human-readable explanation of the response.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Sets the description and returns the current instance.
     *
     * @param description the response description.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Gets the headers associated with the response.
     *
     * @return a map of header names to {@link Header} objects.
     */
    public Map<String, Header> getHeaders() {
        return headers;
    }
    /**
     * Sets the headers of the response.
     *
     * @param headers a map of header names to {@link Header} objects.
     */
    public void setHeaders(Map<String, Header> headers) {
        this.headers = headers;
    }
    /**
     * Sets the headers and returns the current instance.
     *
     * @param headers a map of header names to {@link Header} objects.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse headers(Map<String, Header> headers) {
        this.headers = headers;
        return this;
    }
    /**
     * Adds a header to the response.
     *
     * @param name   the name of the header.
     * @param header the {@link Header} object.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse addHeaderObject(String name, Header header) {
        if (Objects.isNull(this.headers))
            headers = new LinkedHashMap<>();
        headers.put(name, header);
        return this;
    }

    /**
     * Gets the content of the response.
     *
     * @return the {@link Content} object representing media types and schemas.
     */
    public Content getContent() {
        return content;
    }
    /**
     * Sets the content of the response.
     *
     * @param content the {@link Content} object.
     */
    public void setContent(Content content) {
        this.content = content;
    }
    /**
     * Sets the content and returns the current instance.
     *
     * @param content the {@link Content} object.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse content(Content content) {
        this.content = content;
        return this;
    }

    /**
     * Gets the links associated with the response.
     *
     * @return a map of link names to {@link Link} objects.
     */
    public Map<String, Link> getLinks() {
        return links;
    }
    /**
     * Sets the links of the response.
     *
     * @param links a map of link names to {@link Link} objects.
     */
    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }
    /**
     * Sets the links and returns the current instance.
     *
     * @param links a map of link names to {@link Link} objects.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse links(Map<String, Link> links) {
        this.links = links;
        return this;
    }
    /**
     * Adds a single link to the response.
     *
     * @param name the name of the link.
     * @param link the {@link Link} object.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse addLink(String name, Link link) {
        if (Objects.isNull(this.links))
            this.links = new LinkedHashMap<>();
        this.links.put(name, link);
        return this;
    }
    /**
     * Alias for {@link #addLink(String, Link)}.
     *
     * @param name the name of the link.
     * @param link the {@link Link} object.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse link(String name, Link link) {
        return this.addLink(name, link);
    }

    /**
     * Gets the OpenAPI specification extensions.
     *
     * @return a map of extension names to values.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a custom extension to the response.
     * <p>Keys must start with "x-" to be valid.</p>
     *
     * @param name  the name of the extension.
     * @param value the value of the extension.
     */
    public void addExtension(String name, Object value) {
        if (OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (Objects.isNull(this.extensions))
            this.extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }
    /**
     * Sets the OpenAPI specification extensions.
     *
     * @param extensions a map of extension names to values.
     */
    public void setExtensions(java.util.Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Sets the extensions and returns the current instance.
     *
     * @param extensions a map of extension names to values.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse extensions(java.util.Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    /**
     * Gets the reference string to a predefined response object.
     *
     * @return the reference string.
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the reference string to a predefined response.
     * <p>If a simple reference is provided (e.g., "NotFound"), it is expanded to
     * {@code "#/components/responses/NotFound"}.</p>
     *
     * @param $ref the reference string.
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.IS_SIMPLE_REF_USING_INDEXOF.test($ref))
            $ref = "#/components/responses/" + $ref;
        this.$ref = $ref;
    }
    /**
     * Sets the reference string and returns the current instance.
     *
     * @param $ref the reference string.
     * @return this {@link ApiResponse} instance.
     */
    public ApiResponse $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        ApiResponse that = (ApiResponse) object;
        return Objects.equals(description, that.description) &&
               Objects.equals(headers, that.headers) &&
               Objects.equals(content, that.content) &&
               Objects.equals(links, that.links) &&
               Objects.equals(extensions, that.extensions) &&
               Objects.equals($ref, that.$ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, headers, content, links, extensions, $ref);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiResponse {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}