package io.github.kelari.model.v3.headers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kelari.model.v3.enums.StyleHeaderEnum;
import io.github.kelari.model.v3.examples.Example;
import io.github.kelari.model.v3.media.Content;
import io.github.kelari.model.v3.media.Schema;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents the {@code Header} object in the OpenAPI 3.0.1 specification.
 * <p>
 * This class allows you to define headers for a request or response, including description, references,
 * whether the header is required or deprecated, and more.
 * </p>
 * <p>
 * This object also supports additional metadata such as examples, content type, and extensions specific to OpenAPI 3.0.1.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>
 * Header header = new Header()
 *     .description("An example header")
 *     .required(true)
 *     .deprecated(false)
 *     .style(StyleHeaderEnum.SIMPLE)
 *     .example("Example value")
 *     .content(new Content());
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * headers:
 *   X-Example-Header:
 *     description: An example header
 *     required: true
 *     deprecated: false
 *     style: simple
 *     example: "Example value"
 *     content:
 *       application/json:
 *         schema:
 *           type: string
 * </pre>
 *
 * <p>This class encapsulates header information including description, reference, style, examples, and additional extensions.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see StyleHeaderEnum
 * @see Content
 * @see Example
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#header-object">OpenAPI 3.0.1 – Header Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Header implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Header.class.getName());

    private String description = null;
    @JsonProperty("$ref")
    private String $ref = null;
    private Boolean required = null;
    private Boolean deprecated = null;
    private StyleHeaderEnum style = null;
    private Boolean explode = null;
    private Schema schema = null;
    private Map<String, Example> examples = null;
    private Object example = null;
    private Content content = null;
    private Map<String, Object> extensions = null;

    /**
     * Returns the description of the header.
     *
     * @return the description string.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the header.
     *
     * @param description the description text.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Fluent setter for the description.
     *
     * @param description the description text.
     * @return the current {@code Header} instance.
     */
    public Header description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the reference of the header object.
     *
     * @return the reference string.
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the reference to a reusable parameter component.
     *
     * @param $ref the reference string.
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.IS_SIMPLE_REF_USING_INDEXOF.test($ref))
            $ref = "#/components/headers/" + $ref;
        this.$ref = $ref;
    }
    /**
     * Fluent setter for the reference.
     *
     * @param $ref the reference string.
     * @return the current {@code Header} instance.
     */
    public Header $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /**
     * Returns whether the header is required.
     *
     * @return {@code true} if required, otherwise {@code false}.
     */
    public Boolean getRequired() {
        return required;
    }
    /**
     * Sets whether the header is required.
     *
     * @param required boolean indicating if the header is required.
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }
    /**
     * Fluent setter for the required field.
     *
     * @param required boolean indicating if the header is required.
     * @return the current {@code Header} instance.
     */
    public Header required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * Returns whether the header is deprecated.
     *
     * @return {@code true} if deprecated, otherwise {@code false}.
     */
    public Boolean getDeprecated() {
        return deprecated;
    }
    /**
     * Sets whether the header is deprecated.
     *
     * @param deprecated boolean indicating if the header is deprecated.
     */
    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }
    /**
     * Fluent setter for the deprecated field.
     *
     * @param deprecated boolean indicating if the header is deprecated.
     * @return the current {@code Header} instance.
     */
    public Header deprecated(Boolean deprecated) {
        this.deprecated = deprecated;
        return this;
    }

    /**
     * Returns the style of the header.
     *
     * @return the style enum.
     */
    public StyleHeaderEnum getStyle() {
        return style;
    }
    /**
     * Sets the style of the header.
     *
     * @param style the {@link StyleHeaderEnum} value.
     */
    public void setStyle(StyleHeaderEnum style) {
        this.style = style;
    }
    /**
     * Fluent setter for the style field.
     *
     * @param style the {@link StyleHeaderEnum} value.
     * @return the current {@code Header} instance.
     */
    public Header style(StyleHeaderEnum style) {
        this.style = style;
        return this;
    }

    /**
     * Returns whether the header uses explode behavior.
     *
     * @return {@code true} if explode is enabled, otherwise {@code false}.
     */
    public Boolean getExplode() {
        return explode;
    }
    /**
     * Sets whether the header uses explode behavior.
     *
     * @param explode boolean indicating if explode is enabled.
     */
    public void setExplode(Boolean explode) {
        this.explode = explode;
    }
    /**
     * Fluent setter for the explode field.
     *
     * @param explode boolean indicating if explode is enabled.
     * @return the current {@code Header} instance.
     */
    public Header explode(Boolean explode) {
        this.explode = explode;
        return this;
    }

    /**
     * Returns the schema definition of the header.
     *
     * @return the {@link Schema} object.
     */
    public Schema getSchema() {
        return schema;
    }
    /**
     * Sets the schema definition of the header.
     *
     * @param schema the {@link Schema} object.
     */
    public void setSchema(Schema schema) {
        this.schema = schema;
    }
    /**
     * Fluent setter for the schema.
     *
     * @param schema the {@link Schema} object.
     * @return the current {@code Header} instance.
     */
    public Header schema(Schema schema) {
        this.schema = schema;
        return this;
    }

    /**
     * Returns the map of examples for the header.
     *
     * @return map of examples.
     */
    public Map<String, Example> getExamples() {
        return examples;
    }
    /**
     * Sets the map of examples for the header.
     *
     * @param examples the map of {@link Example} objects.
     */
    public void setExamples(Map<String, Example> examples) {
        this.examples = examples;
    }
    /**
     * Fluent setter for the examples map.
     *
     * @param examples the map of {@link Example} objects.
     * @return the current {@code Header} instance.
     */
    public Header examples(Map<String, Example> examples) {
        this.examples = examples;
        return this;
    }
    /**
     * Adds a single example to the examples map.
     *
     * @param key the name of the example.
     * @param examplesItem the {@link Example} object.
     * @return the current {@code Header} instance.
     */
    public Header addExample(String key, Example examplesItem) {
        if (this.examples == null)
            this.examples = new LinkedHashMap<>();
        this.examples.put(key, examplesItem);
        return this;
    }

    /**
     * Returns a single example value for the header.
     *
     * @return the example object.
     */
    public Object getExample() {
        return example;
    }
    /**
     * Sets a single example value for the header.
     *
     * @param example the example value.
     */
    public void setExample(Object example) {
        this.example = example;
    }
    /**
     * Fluent setter for the single example.
     *
     * @param example the example value.
     * @return the current {@code Header} instance.
     */
    public Header example(Object example) {
        this.example = example;
        return this;
    }

    /**
     * Returns the content object associated with the header.
     *
     * @return the {@link Content} object.
     */
    public Content getContent() {
        return content;
    }
    /**
     * Sets the content object associated with the header.
     *
     * @param content the {@link Content} object.
     */
    public void setContent(Content content) {
        this.content = content;
    }
    /**
     * Fluent setter for the content.
     *
     * @param content the {@link Content} object.
     * @return the current {@code Header} instance.
     */
    public Header content(Content content) {
        this.content = content;
        return this;
    }

    /**
     * Returns the map of custom OpenAPI extensions for this header.
     *
     * @return map of extension keys and values.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a single extension to the header.
     * <p>Extension keys must start with {@code x-} as per OpenAPI specification.</p>
     *
     * @param name the extension name (must start with {@code x-}).
     * @param value the extension value.
     * @return the current {@code Header} instance.
     */
    public Header extensions(String name, Object value) {
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
     * Sets the map of OpenAPI extensions for this header.
     *
     * @param extensions the map of extension keys and values.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Fluent setter for the extensions map.
     *
     * @param extensions the map of extension keys and values.
     * @return the current {@code Header} instance.
     */
    public Header extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        Header header = (Header) object;
        return Objects.equals(description, header.description) &&
               Objects.equals($ref, header.$ref) &&
               Objects.equals(required, header.required) &&
               Objects.equals(deprecated, header.deprecated) &&
               style == header.style &&
               Objects.equals(explode, header.explode) &&
               Objects.equals(schema, header.schema) &&
               Objects.equals(examples, header.examples) &&
               Objects.equals(example, header.example) &&
               Objects.equals(content, header.content) &&
               Objects.equals(extensions, header.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, $ref, required, deprecated, style, explode, schema, examples, example, content, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Header {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("    deprecated: ").append(toIndentedString(deprecated)).append("\n");
        sb.append("    style: ").append(toIndentedString(style)).append("\n");
        sb.append("    explode: ").append(toIndentedString(explode)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("    examples: ").append(toIndentedString(examples)).append("\n");
        sb.append("    example: ").append(toIndentedString(example)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}