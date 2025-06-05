    package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.examples.Example;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents the {@code MediaType} object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code MediaType} object provides schema and examples for a particular media type.
 * It is used within the {@code content} property of request and response bodies, as well as parameters.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * MediaType mediaType = new MediaType();
 * mediaType.schema(new Schema().type("string"))
 *     .example("sample string")
 *     .addExamples("example1", new Example().summary("A string example"))
 *     .addEncoding("field", new Encoding().contentType("application/json"));
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * content:
 *   application/json:
 *     schema:
 *       type: string
 *     example: "sample string"
 *     examples:
 *       example1:
 *         summary: A string example
 *         value: "sample string"
 *     encoding:
 *       field:
 *         contentType: application/json
 * </pre>
 *
 * <p>
 * This class encapsulates the media type information including the schema definition,
 * example value, named examples, encoding metadata, and optional extensions.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see Example
 * @see Encoding
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#mediaTypeObject">OpenAPI 3.0.1 – Media Type Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
 @JsonInclude(JsonInclude.Include.NON_NULL)
public class MediaType implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(MediaType.class.getName());

    private Schema schema = null;
    private Map<String, Example> examples = null;
    private Object example = null;
    private Map<String, Encoding> encoding = null;
    private Map<String, Object> extensions = null;
    private boolean exampleSetFlag;

    /**
     * Returns the schema definition associated with this media type.
     *
     * @return the {@link Schema} object.
     */
    public Schema getSchema() {
        return schema;
    }
    /**
     * Sets the schema definition for this media type.
     *
     * @param schema the {@link Schema} object to set.
     */
    public void setSchema(Schema schema) {
        this.schema = schema;
    }
    /**
     * Fluent setter for the schema definition.
     *
     * @param schema the {@link Schema} object to set.
     * @return this {@link MediaType} instance.
     */
    public MediaType schema(Schema schema) {
        this.schema = schema;
        return this;
    }

    /**
     * Returns the named examples associated with this media type.
     *
     * @return a map of example names to {@link Example} objects.
     */
    public Map<String, Example> getExamples() {
        return examples;
    }
    /**
     * Sets the named examples for this media type.
     *
     * @param examples a map of example names to {@link Example} objects.
     */
    public void setExamples(Map<String, Example> examples) {
        this.examples = examples;
    }
    /**
     * Fluent setter for named examples.
     *
     * @param examples a map of example names to {@link Example} objects.
     * @return this {@link MediaType} instance.
     */
    public MediaType examples(Map<String, Example> examples) {
        this.examples = examples;
        return this;
    }
    /**
     * Adds a single named example to this media type.
     *
     * @param key          the name of the example.
     * @param examplesItem the {@link Example} object.
     * @return this {@link MediaType} instance.
     */
    public MediaType addExamples(String key, Example examplesItem) {
        if (Objects.isNull(this.examples))
            this.examples = new LinkedHashMap<>();
        this.examples.put(key, examplesItem);
        return this;
    }

    /**
     * Returns the single example object.
     *
     * @return the example value.
     */
    public Object getExample() {
        return example;
    }
    /**
     * Sets the single example object. If a schema is defined, it will try to cast the example.
     *
     * @param example the example value to set.
     */
    public void setExample(Object example) {
        if (Objects.isNull(this.schema)) {
            this.example = example;
            this.exampleSetFlag = true;
            return;
        }
        this.example = this.schema.cast(example);
        if (!(example != null && this.example == null))
            this.exampleSetFlag = true;
    }
    /**
     * Fluent setter for the example object.
     *
     * @param example the example value to set.
     * @return this {@link MediaType} instance.
     */
    public MediaType example(Object example) {
        setExample(example);
        return this;
    }

    /**
     * Returns the encoding map associated with this media type.
     *
     * @return a map of property names to {@link Encoding} objects.
     */
    public Map<String, Encoding> getEncoding() {
        return encoding;
    }
    /**
     * Sets the encoding map for this media type.
     *
     * @param encoding a map of property names to {@link Encoding} objects.
     */
    public void setEncoding(Map<String, Encoding> encoding) {
        this.encoding = encoding;
    }
    /**
     * Fluent setter for encoding map.
     *
     * @param encoding a map of property names to {@link Encoding} objects.
     * @return this {@link MediaType} instance.
     */
    public MediaType encoding(Map<String, Encoding> encoding) {
        this.encoding = encoding;
        return this;
    }
    /**
     * Adds a single encoding entry to this media type.
     *
     * @param key          the property name.
     * @param encodingItem the {@link Encoding} object.
     * @return this {@link MediaType} instance.
     */
    public MediaType addEncoding(String key, Encoding encodingItem) {
        if (Objects.isNull(this.encoding))
            this.encoding = new LinkedHashMap<>();
        this.encoding.put(key, encodingItem);
        return this;
    }

    /**
     * Indicates whether the example has been explicitly set.
     *
     * @return {@code true} if an example has been set, {@code false} otherwise.
     */
    public boolean getExampleSetFlag() {
        return exampleSetFlag;
    }
    /**
     * Sets the example set flag.
     *
     * @param exampleSetFlag the flag value to set.
     */
    public void setExampleSetFlag(boolean exampleSetFlag) {
        this.exampleSetFlag = exampleSetFlag;
    }
    /**
     * Fluent setter for the example set flag.
     *
     * @param exampleSetFlag the flag value to set.
     * @return this {@link MediaType} instance.
     */
    public MediaType exampleSetFlag(boolean exampleSetFlag) {
        this.exampleSetFlag = exampleSetFlag;
        return this;
    }

    /**
     * Returns the extension properties of this media type.
     *
     * @return a map of extension names to values.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a single extension property.
     * The extension name must follow the OpenAPI extension naming convention (i.e., start with "x-").
     *
     * @param name  the name of the extension property.
     * @param value the value of the extension property.
     */
    public void addExtension(String name, Object value) {
        if (OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (this.extensions == null)
            this.extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }
    /**
     * Sets the entire extension map for this media type.
     *
     * @param extensions a map of extension names to values.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Fluent setter for extensions.
     *
     * @param extensions a map of extension names to values.
     * @return this {@link MediaType} instance.
     */
    public MediaType extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        MediaType mediaType = (MediaType) object;
        return exampleSetFlag == mediaType.exampleSetFlag &&
               Objects.equals(schema, mediaType.schema) &&
               Objects.equals(examples, mediaType.examples) &&
               Objects.equals(example, mediaType.example) &&
               Objects.equals(encoding, mediaType.encoding) &&
               Objects.equals(extensions, mediaType.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schema, examples, example, encoding, extensions, exampleSetFlag);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MediaType {\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("    examples: ").append(toIndentedString(examples)).append("\n");
        sb.append("    example: ").append(toIndentedString(example)).append("\n");
        sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
