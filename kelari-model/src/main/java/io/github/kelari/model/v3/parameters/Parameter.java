package io.github.kelari.model.v3.parameters;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kelari.model.v3.enums.StyleParameterEnum;
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
 * Represents a parameter in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code Parameter} object defines a parameter for an operation in the OpenAPI specification.
 * This object describes the characteristics of the parameter, such as its name, location, data type,
 * whether it is required, among other details. It is used to document the parameters of
 * the inputs of an API endpoint.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Parameter parameter = new Parameter()
 *     .name("username")
 *     .in("query")
 *     .description("Username for search")
 *     .required(true)
 *     .schema(new Schema().type("string").example("johndoe"));
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * parameters:
 *   - name: username
 *     in: query
 *     description: Username for search
 *     required: true
 *     schema:
 *       type: string
 *       example: "johndoe"
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see StyleParameterEnum
 * @see Schema
 * @see Content
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#parameter-object">OpenAPI 3.0.1 – Parameter Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#reference-object">OpenAPI 3.0.1 – Reference Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parameter implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Parameter.class.getName());

    private String name = null;
    private String in = null;
    private String description = null;
    private Boolean required = null;
    private Boolean deprecated = null;
    private Boolean allowEmptyValue = null;
    @JsonProperty("$ref")
    private String $ref = null;
    private StyleParameterEnum style = null;
    private Boolean explode = null;
    private Boolean allowReserved = null;
    private Schema schema = null;
    private Map<String, Example> examples = null;
    private Object example = null;
    private Content content = null;
    private Map<String, Object> extensions = null;

    /**
     * Returns the name of the parameter.
     *
     * @return the name of the parameter
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the parameter.
     *
     * @param name the name of the parameter
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the name of the parameter and returns the current instance.
     *
     * @param name the name of the parameter
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Returns the location of the parameter (e.g., 'query', 'path').
     *
     * @return the location of the parameter
     */
    public String getIn() {
        return in;
    }
    /**
     * Sets the location of the parameter. If it is of type 'path', the parameter is marked as required.
     *
     * @param in the location of the parameter (e.g., 'query', 'path')
     */
    public void setIn(String in) {
        if ("path".equals(in)) {
            this.required = true;
        }
        this.in = in;
    }
    /**
     * Sets the location of the parameter and returns the current instance.
     *
     * @param in the location of the parameter (e.g., 'query', 'path')
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter in(String in) {
        setIn(in);
        return this;
    }

    /**
     * Returns the description of the parameter.
     *
     * @return the description of the parameter
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the parameter.
     *
     * @param description the description of the parameter
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Sets the description of the parameter and returns the current instance.
     *
     * @param description the description of the parameter
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns whether the parameter is required.
     *
     * @return {@code true} if the parameter is required, {@code false} otherwise
     */
    public Boolean getRequired() {
        return required;
    }
    /**
     * Sets whether the parameter is required.
     *
     * @param required {@code true} if the parameter is required, {@code false} otherwise
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }
    /**
     * Sets whether the parameter is required and returns the current instance.
     *
     * @param required {@code true} if the parameter is required, {@code false} otherwise
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * Returns whether the parameter is deprecated.
     *
     * @return {@code true} if the parameter is deprecated, {@code false} otherwise
     */
    public Boolean getDeprecated() {
        return deprecated;
    }
    /**
     * Sets whether the parameter is deprecated.
     *
     * @param deprecated {@code true} if the parameter is deprecated, {@code false} otherwise
     */
    public void setDeprecated(Boolean deprecated) {
        this.deprecated = deprecated;
    }
    /**
     * Sets whether the parameter is deprecated and returns the current instance.
     *
     * @param deprecated {@code true} if the parameter is deprecated, {@code false} otherwise
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter deprecated(Boolean deprecated) {
        this.deprecated = deprecated;
        return this;
    }

    /**
     * Returns whether the parameter allows empty values.
     *
     * @return {@code true} if the parameter allows empty values, {@code false} otherwise
     */
    public Boolean getAllowEmptyValue() {
        return allowEmptyValue;
    }
    /**
     * Sets whether the parameter allows empty values.
     *
     * @param allowEmptyValue {@code true} if the parameter allows empty values, {@code false} otherwise
     */
    public void setAllowEmptyValue(Boolean allowEmptyValue) {
        this.allowEmptyValue = allowEmptyValue;
    }
    /**
     * Sets whether the parameter allows empty values and returns the current instance.
     *
     * @param allowEmptyValue {@code true} if the parameter allows empty values, {@code false} otherwise
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter allowEmptyValue(Boolean allowEmptyValue) {
        this.allowEmptyValue = allowEmptyValue;
        return this;
    }

    /**
     * Returns the value of the {@code $ref} field, which represents a reference to a parameter
     * defined elsewhere in the OpenAPI document.
     * The returned value is either an absolute or relative reference to the parameter.
     *
     * <p>This field is used to reference parameters that are defined in another part of the specification,
     * allowing reuse of parameter definitions without duplication.</p>
     *
     * @return the value of the {@code $ref} field, which is a reference to a parameter
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the value of the {@code $ref} field, which represents a reference to a parameter.
     *
     * <p>If the provided value is not in the correct format, the method automatically adds the
     * prefix "#/components/parameters/" to ensure the reference is valid.</p>
     *
     * <p>This field is used to reference parameters defined in another part of the OpenAPI specification.</p>
     *
     * @param $ref the reference value for the parameter
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.IS_SIMPLE_REF_USING_CONTAINS.test($ref))
            $ref = "#/components/parameters/" + $ref;
        this.$ref = $ref;
    }
    /**
     * Sets the value of the {@code $ref} field and returns the current instance of the {@code Parameter} class.
     *
     * <p>This method allows setting the parameter reference with a fluent method call style.</p>
     *
     * @param $ref the reference value for the parameter
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /**
     * Returns the serialization style of the parameter.
     *
     * @return the serialization style
     */
    public StyleParameterEnum getStyle() {
        return style;
    }
    /**
     * Sets the serialization style of the parameter.
     *
     * @param style the serialization style
     */
    public void setStyle(StyleParameterEnum style) {
        this.style = style;
    }
    /**
     * Sets the serialization style and returns the current instance.
     *
     * @param style the serialization style
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter style(StyleParameterEnum style) {
        this.style = style;
        return this;
    }

    /**
     * Returns whether the parameter uses exploded serialization.
     *
     * @return {@code true} if the parameter uses exploded serialization, {@code false} otherwise
     */
    public Boolean getExplode() {
        return explode;
    }
    /**
     * Sets whether the parameter uses exploded serialization.
     *
     * @param explode {@code true} if the parameter uses exploded serialization, {@code false} otherwise
     */
    public void setExplode(Boolean explode) {
        this.explode = explode;
    }
    /**
     * Sets whether the parameter uses exploded serialization and returns the current instance.
     *
     * @param explode {@code true} if the parameter uses exploded serialization, {@code false} otherwise
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter explode(Boolean explode) {
        this.explode = explode;
        return this;
    }

    /**
     * Returns whether the parameter allows reserved values.
     *
     * @return {@code true} if the parameter allows reserved values, {@code false} otherwise
     */
    public Boolean getAllowReserved() {
        return allowReserved;
    }
    /**
     * Sets whether the parameter allows reserved values.
     *
     * @param allowReserved {@code true} if the parameter allows reserved values, {@code false} otherwise
     */
    public void setAllowReserved(Boolean allowReserved) {
        this.allowReserved = allowReserved;
    }
    /**
     * Sets whether the parameter allows reserved values and returns the current instance.
     *
     * @param allowReserved {@code true} if the parameter allows reserved values, {@code false} otherwise
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter allowReserved(Boolean allowReserved) {
        this.allowReserved = allowReserved;
        return this;
    }

    /**
     * Returns the schema of the parameter.
     *
     * @return the schema of the parameter
     */
    public Schema getSchema() {
        return schema;
    }
    /**
     * Sets the schema of the parameter.
     *
     * @param schema the schema of the parameter
     */
    public void setSchema(Schema schema) {
        this.schema = schema;
    }
    /**
     * Sets the schema of the parameter and returns the current instance.
     *
     * @param schema the schema of the parameter
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter schema(Schema schema) {
        this.schema = schema;
        return this;
    }

    /**
     * Returns the examples for the parameter.
     *
     * @return a map of example names to examples
     */
    public Map<String, Example> getExamples() {
        return examples;
    }
    /**
     * Sets the examples for the parameter.
     *
     * @param examples a map of example names to examples
     */
    public void setExamples(Map<String, Example> examples) {
        this.examples = examples;
    }
    /**
     * Sets the examples for the parameter and returns the current instance.
     *
     * @param examples a map of example names to examples
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter examples(Map<String, Example> examples) {
        this.examples = examples;
        return this;
    }

    /**
     * Adds an example for the parameter.
     *
     * @param name    the name of the example
     * @param example the example to add
     */
    @JsonAnySetter
    public void addExample(String name, Example example) {
        if (this.examples == null) {
            this.examples = new LinkedHashMap<>();
        }
        this.examples.put(name, example);
    }
    /**
     * Returns the example value for the parameter.
     *
     * @return the example value
     */
    public Object getExample() {
        return example;
    }
    /**
     * Sets the example value for the parameter.
     *
     * @param example the example value
     */
    public void setExample(Object example) {
        this.example = example;
    }
    /**
     * Sets the example value for the parameter and returns the current instance.
     *
     * @param example the example value
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter example(Object example) {
        this.example = example;
        return this;
    }

    /**
     * Returns the content of the parameter.
     *
     * @return the content of the parameter
     */
    public Content getContent() {
        return content;
    }
    /**
     * Sets the content of the parameter.
     *
     * @param content the content of the parameter
     */
    public void setContent(Content content) {
        this.content = content;
    }
    /**
     * Sets the content of the parameter and returns the current instance.
     *
     * @param content the content of the parameter
     * @return the current instance of the {@code Parameter} class
     */
    public Parameter content(Content content) {
        this.content = content;
        return this;
    }

    /**
     * Returns any extensions for the parameter.
     *
     * @return a map of extension names to extension values
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Sets any extensions for the parameter.
     *
     * @param extensions a map of extension names to extension values
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Adds a custom extension property to this object.
     * <p>
     * Extensions must follow the OpenAPI specification naming convention, where keys
     * must start with {@code "x-"}. If the provided name does not conform to this
     * requirement, the extension is ignored and a warning is logged.
     * </p>
     *
     * @param name  the name of the extension property. Must start with {@code "x-"}.
     * @param value the value associated with the extension property. Can be any Object.
     *
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameter parameter = (Parameter) o;
        return Objects.equals(name, parameter.name) &&
                Objects.equals(in, parameter.in) &&
                Objects.equals(description, parameter.description) &&
                Objects.equals(required, parameter.required) &&
                Objects.equals(deprecated, parameter.deprecated) &&
                Objects.equals(allowEmptyValue, parameter.allowEmptyValue) &&
                Objects.equals($ref, parameter.$ref) &&
                Objects.equals(style, parameter.style) &&
                Objects.equals(explode, parameter.explode) &&
                Objects.equals(allowReserved, parameter.allowReserved) &&
                Objects.equals(schema, parameter.schema) &&
                Objects.equals(examples, parameter.examples) &&
                Objects.equals(example, parameter.example) &&
                Objects.equals(content, parameter.content) &&
                Objects.equals(extensions, parameter.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, in, description, required, deprecated, allowEmptyValue, $ref, style, explode, allowReserved, schema, examples, example, content, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Parameter {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    in: ").append(toIndentedString(in)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("    deprecated: ").append(toIndentedString(deprecated)).append("\n");
        sb.append("    allowEmptyValue: ").append(toIndentedString(allowEmptyValue)).append("\n");
        sb.append("    style: ").append(toIndentedString(style)).append("\n");
        sb.append("    explode: ").append(toIndentedString(explode)).append("\n");
        sb.append("    allowReserved: ").append(toIndentedString(allowReserved)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("    examples: ").append(toIndentedString(examples)).append("\n");
        sb.append("    example: ").append(toIndentedString(example)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}