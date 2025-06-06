package io.github.kelari.model.v3.examples;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Represents an Example object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code Example} class is used to provide example values for request and response payloads,
 * parameters, or other schema-related objects. It allows for better documentation and understanding
 * of how to use an API by showing concrete sample data.
 * </p>
 *
 * <p>Examples can be defined inline or via a reference to the global examples component.</p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Example example = new Example()
 *     .summary("A user example")
 *     .value(Map.of("name", "John Doe", "age", 30));
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * components:
 *   examples:
 *     user:
 *       summary: A user example
 *       value:
 *         name: John Doe
 *         age: 30
 * </pre>
 *
 * <p>If an external value is provided via {@code externalValue}, it points to a URL containing
 * the example content, and the {@code value} field is ignored.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#example-object">OpenAPI 3.0.1 – Example Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Example implements Serializable, IndentedString {

    private String summary = null;
    private String description = null;
    private Object value = null;
    private String externalValue = null;
    private String $ref = null;
    private Map<String, Object> extensions = null;

    private boolean valueSetFlag;

    /**
     * Returns a short summary of the example.
     * @return a brief summary as a String.
     */
    public String getSummary() {
        return summary;
    }
    /**
     * Sets a short summary of the example.
     * @param summary a brief summary as a String.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }
    /**
     * Fluent setter for the summary field.
     * @param summary the example summary.
     * @return the current {@code Example} instance.
     */
    public Example summary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Returns a detailed description of the example.
     * @return the example description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the detailed description of the example.
     * @param description the example description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Fluent setter for the description field.
     * @param description the example description.
     * @return the current {@code Example} instance.
     */
    public Example description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the actual value of the example.
     * @return the example value.
     */
    public Object getValue() {
        return value;
    }
    /**
     * Sets the value of the example and marks it as explicitly set.
     * @param value the example value.
     */
    public void setValue(Object value) {
        this.value = value;
        valueSetFlag = true;
    }
    /**
     * Fluent setter for the value field.
     * @param value the example value.
     * @return the current {@code Example} instance.
     */
    public Example value(Object value) {
        setValue(value);
        return this;
    }

    /**
     * Returns the external value reference URL of the example.
     * @return the external value as a String.
     */
    public String getExternalValue() {
        return externalValue;
    }
    /**
     * Sets the external value reference URL of the example.
     * @param externalValue the external URL to an example payload.
     */
    public void setExternalValue(String externalValue) {
        this.externalValue = externalValue;
    }
    /**
     * Fluent setter for the externalValue field.
     * @param externalValue the external URL reference.
     * @return the current {@code Example} instance.
     */
    public Example externalValue(String externalValue) {
        this.externalValue = externalValue;
        return this;
    }

    /**
     * Returns the reference string to a reusable example component.
     * @return the $ref value.
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the $ref property and automatically formats it if using a simple reference.
     * @param $ref the reference string.
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.IS_SIMPLE_REF_USING_INDEXOF.test($ref))
            $ref = "#/components/examples/" + $ref;
        this.$ref = $ref;
    }
    /**
     * Fluent setter for the $ref field.
     * @param $ref the reference string.
     * @return the current {@code Example} instance.
     */
    public Example $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /**
     * Returns a map of custom extensions associated with this example.
     * @return a map of extension key-value pairs.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a custom extension to the example if the extension name is valid.
     * @param name the extension name (should start with "x-").
     * @param value the extension value.
     */
    public void addExtension(String name, Object value) {
        if (OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name))
            return;
        if (this.extensions == null)
            this.extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }
    /**
     * Sets the map of custom extensions for this example.
     * @param extensions the map of extensions.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Fluent setter for the extensions map.
     * @param extensions the map of custom extensions.
     * @return the current {@code Example} instance.
     */
    public Example extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    /**
     * Indicates whether the value property has been explicitly set.
     * @return true if the value was set, false otherwise.
     */
    public boolean isValueSetFlag() {
        return valueSetFlag;
    }
    /**
     * Sets the valueSetFlag status.
     * @param valueSetFlag the flag indicating if value was set.
     */
    public void setValueSetFlag(boolean valueSetFlag) {
        this.valueSetFlag = valueSetFlag;
    }
    /**
     * Fluent setter for the valueSetFlag.
     * @param valueSetFlag the flag value.
     * @return the current {@code Example} instance.
     */
    public Example valueSetFlag(boolean valueSetFlag) {
        this.valueSetFlag = valueSetFlag;
        return this;
    }

    /**
     * Compares this example with another object for equality.
     * @param object the object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        Example example = (Example) object;
        return valueSetFlag == example.valueSetFlag &&
                Objects.equals(summary, example.summary) &&
                Objects.equals(description, example.description) &&
                Objects.equals(value, example.value) &&
                Objects.equals(externalValue, example.externalValue) &&
                Objects.equals($ref, example.$ref) &&
                Objects.equals(extensions, example.extensions);
    }

    /**
     * Returns a hash code value for the example.
     * @return a hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(summary, description, value, externalValue,
                $ref, extensions, valueSetFlag);
    }

    /**
     * Returns a string representation of the example object.
     * @return a formatted string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Example {\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    externalValue: ").append(toIndentedString(externalValue)).append("\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
