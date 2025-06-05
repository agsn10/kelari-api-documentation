package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents the XML metadata for a property or model in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code XML} class is used to define how a property should be represented when serialized in XML.
 * It allows configuration of element name, namespace, prefix, whether it should be represented as
 * an attribute, and whether it should be wrapped in an enclosing element.
 * </p>
 *
 * <p>This class supports method chaining for fluent configuration of XML metadata.</p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * XML xml = new XML()
 *     .name("item")
 *     .namespace("http://example.com/schema")
 *     .prefix("ex")
 *     .attribute(false)
 *     .wrapped(true)
 *     .extensions("x-custom", "value");
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * properties:
 *   id:
 *     type: string
 *     xml:
 *       name: id
 *       namespace: http://example.com/schema
 *       prefix: ex
 *       attribute: true
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#xml-object">OpenAPI 3.0.1 – XML Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XML implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(XML.class.getName());

    private String name = null;
    private String namespace = null;
    private String prefix = null;
    private Boolean attribute = null;
    private Boolean wrapped = null;
    private Map<String, Object> extensions = null;

    /**
     * Gets the XML element name.
     *
     * @return the name of the XML element
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the XML element name.
     *
     * @param name the name of the XML element
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Fluent setter for the XML element name.
     *
     * @param name the name of the XML element
     * @return this {@code XML} instance
     */
    public XML name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the XML namespace URI.
     *
     * @return the namespace URI
     */
    public String getNamespace() {
        return namespace;
    }
    /**
     * Sets the XML namespace URI.
     *
     * @param namespace the namespace URI
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    /**
     * Fluent setter for the XML namespace URI.
     *
     * @param namespace the namespace URI
     * @return this {@code XML} instance
     */
    public XML namespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * Gets the XML prefix to use for the namespace.
     *
     * @return the XML prefix
     */
    public String getPrefix() {
        return prefix;
    }
    /**
     * Sets the XML prefix to use for the namespace.
     *
     * @param prefix the XML prefix
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    /**
     * Fluent setter for the XML prefix.
     *
     * @param prefix the XML prefix
     * @return this {@code XML} instance
     */
    public XML prefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Gets whether the property is an XML attribute.
     *
     * @return {@code true} if it is an attribute, {@code false} if it is an element
     */
    public Boolean getAttribute() {
        return attribute;
    }
    /**
     * Sets whether the property is an XML attribute.
     *
     * @param attribute {@code true} if it is an attribute, {@code false} if it is an element
     */
    public void setAttribute(Boolean attribute) {
        this.attribute = attribute;
    }
    /**
     * Fluent setter for attribute indicator.
     *
     * @param attribute {@code true} if it is an attribute
     * @return this {@code XML} instance
     */
    public XML attribute(Boolean attribute) {
        this.attribute = attribute;
        return this;
    }

    /**
     * Gets whether the element should be wrapped in an outer container.
     *
     * @return {@code true} if wrapped, {@code false} otherwise
     */
    public Boolean getWrapped() {
        return wrapped;
    }
    /**
     * Sets whether the element should be wrapped in an outer container.
     *
     * @param wrapped {@code true} if wrapped, {@code false} otherwise
     */
    public void setWrapped(Boolean wrapped) {
        this.wrapped = wrapped;
    }
    /**
     * Fluent setter for the wrapped indicator.
     *
     * @param wrapped {@code true} if wrapped
     * @return this {@code XML} instance
     */
    public XML wrapped(Boolean wrapped) {
        this.wrapped = wrapped;
        return this;
    }

    /**
     * Adds a vendor extension (key starting with {@code x-}) to this XML object.
     *
     * @param name  the extension name (must start with {@code x-})
     * @param value the extension value
     * @return this {@code XML} instance
     */
    public XML extensions(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return this;
        }
        if (Objects.isNull(extensions)) {
            extensions = new LinkedHashMap<>();
        }
        extensions.put(name, value);
        return this;
    }
    /**
     * Gets the map of vendor extensions.
     *
     * @return a map of vendor extensions, or {@code null} if none are set
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Sets the vendor extensions map.
     *
     * @param extensions a map containing vendor extensions
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        XML xml = (XML) object;
        return Objects.equals(name, xml.name) &&
               Objects.equals(namespace, xml.namespace) &&
               Objects.equals(prefix, xml.prefix) &&
               Objects.equals(attribute, xml.attribute) &&
               Objects.equals(wrapped, xml.wrapped) &&
               Objects.equals(extensions, xml.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, namespace, prefix, attribute, wrapped, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class XML {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    namespace: ").append(toIndentedString(namespace)).append("\n");
        sb.append("    prefix: ").append(toIndentedString(prefix)).append("\n");
        sb.append("    attribute: ").append(toIndentedString(attribute)).append("\n");
        sb.append("    wrapped: ").append(toIndentedString(wrapped)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
