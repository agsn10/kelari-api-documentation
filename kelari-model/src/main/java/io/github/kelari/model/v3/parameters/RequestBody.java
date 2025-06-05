package io.github.kelari.model.v3.parameters;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.media.Content;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents the {@code RequestBody} object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code RequestBody} object describes a single request body, including its content (media types),
 * description, requirement status, and any extensions.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * MediaType mediaType = new MediaType();
 * mediaType.schema(new Schema().type("string"))
 *     .example("sample string")
 *     .addExamples("example1", new Example().summary("A string example"))
 *     .addEncoding("field", new Encoding().contentType("application/json"));
 *
 * Content content = new Content();
 * content.addMediaType("application/json", mediaType);
 *
 * RequestBody requestBody = new RequestBody()
 *     .description("User to add to the system")
 *     .required(true)
 *     .content(content);
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * requestBody:
 *   description: User to add to the system
 *   required: true
 *   content:
 *     application/json:
 *       schema:
 *         type: string
 *       example: "sample string"
 *       examples:
 *         example1:
 *           summary: A string example
 *           value: "sample string"
 *       encoding:
 *         field:
 *           contentType: application/json
 * </pre>
 *
 * <p>
 * This class supports OpenAPI extension fields prefixed with {@code x-}, which can be added using {@link #addExtension}.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Content
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#requestBodyObject">OpenAPI 3.0.1 – Request Body Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestBody implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(RequestBody.class.getName());

    private String description = null;
    private Content content = null;
    private Boolean required = null;
    private Map<String, Object> extensions = null;
    private String $ref = null;

    /**
     * Returns the description of the request body.
     *
     * @return the description text.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description for the request body.
     *
     * @param description the textual description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Sets the description and returns the {@code RequestBody} instance.
     *
     * @param description the textual description.
     * @return this {@code RequestBody} instance.
     */
    public RequestBody description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the {@link Content} of the request body.
     *
     * @return the {@link Content} object.
     */
    public Content getContent() {
        return content;
    }
    /**
     * Sets the {@link Content} for the request body.
     *
     * @param content the {@link Content} object.
     */
    public void setContent(Content content) {
        this.content = content;
    }
    /**
     * Sets the content and returns the {@code RequestBody} instance.
     *
     * @param content the {@link Content} object.
     * @return this {@code RequestBody} instance.
     */
    public RequestBody content(Content content) {
        this.content = content;
        return this;
    }

    /**
     * Returns whether this request body is required.
     *
     * @return {@code true} if required, {@code false} otherwise.
     */
    public Boolean getRequired() {
        return required;
    }
    /**
     * Sets whether this request body is required.
     *
     * @param required {@code true} if required.
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }
    /**
     * Sets the required flag and returns the {@code RequestBody} instance.
     *
     * @param required {@code true} if required.
     * @return this {@code RequestBody} instance.
     */
    public RequestBody required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * Returns the extensions map.
     *
     * @return a {@link Map} containing the OpenAPI extensions.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a single OpenAPI extension field.
     * Extension names must start with {@code x-}. Invalid names are ignored.
     *
     * @param name  the name of the extension (must start with {@code x-}).
     * @param value the value of the extension.
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (this.extensions == null)
            this.extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }
    /**
     * Sets all extensions for the request body.
     *
     * @param extensions a map of extension names and values.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Sets all extensions and returns the {@code RequestBody} instance.
     *
     * @param extensions a map of extension names and values.
     * @return this {@code RequestBody} instance.
     */
    public RequestBody extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    /**
     * Returns the reference string if this object is a reference.
     *
     * @return the reference string.
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the reference string. If a simple reference is passed, it will be transformed to a full component path.
     *
     * @param $ref the reference string or component name.
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.IS_SIMPLE_REF_USING_INDEXOF.test($ref))
            $ref = "#/components/requestBodies/" + $ref;
        this.$ref = $ref;
    }
    /**
     * Sets the reference and returns the {@code RequestBody} instance.
     *
     * @param $ref the reference string.
     * @return this {@code RequestBody} instance.
     */
    public RequestBody $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        RequestBody that = (RequestBody) object;
        return Objects.equals(description, that.description) &&
                Objects.equals(content, that.content) &&
                Objects.equals(required, that.required) &&
                Objects.equals(extensions, that.extensions) &&
                Objects.equals($ref, that.$ref);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(description, content, required, extensions, $ref);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestBody {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}