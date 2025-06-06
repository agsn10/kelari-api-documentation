package io.github.kelari.model.v3;

import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents external documentation for a tag or schema in an OpenAPI definition.
 * <p>
 * The {@code ExternalDocumentation} object allows referencing additional external
 * information or resources relevant to a given OpenAPI component. It includes a URL
 * and an optional description, and may contain vendor-specific extensions.
 * </p>
 *
 * <p><strong>Example usage:</strong></p>
 * <pre>
 * externalDocs:
 *   description: Find more info here
 *   url: https://example.com
 *   x-resource-version: "v1.2.3"
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#externalDocumentationObject">OpenAPI 3.0.1 – External Documentation Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#specification-extensions">OpenAPI 3.0.1 – Specification Extensions</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public class ExternalDocumentation implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(ExternalDocumentation.class.getName());

    private String description = null;
    private String url = null;
    private Map<String, Object> extensions = null;

    /**
     * Returns the short description of the target external documentation.
     *
     * @return the documentation description, or {@code null} if not defined
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets a short description for the external documentation.
     *
     * @param description the description text
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Sets the description and returns this {@code ExternalDocumentation} instance for method chaining.
     *
     * @param description the documentation description
     * @return the updated {@code ExternalDocumentation} instance
     */
    public ExternalDocumentation description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the URL to the target external documentation.
     *
     * @return the documentation URL, or {@code null} if not defined
     */
    public String getUrl() {
        return url;
    }
    /**
     * Sets the URL for the external documentation resource.
     *
     * @param url the documentation URL
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Sets the URL and returns this {@code ExternalDocumentation} instance for method chaining.
     *
     * @param url the documentation URL
     * @return the updated {@code ExternalDocumentation} instance
     */
    public ExternalDocumentation url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Returns the vendor-specific extensions associated with this object.
     *
     * @return a map of extension properties, or {@code null} if not set
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a vendor-specific extension property to this object.
     * <p>
     * Extension keys must start with {@code x-}, otherwise the extension is ignored.
     * </p>
     *
     * @param name  the name of the extension property
     * @param value the value of the extension property
     */
    public void addExtension(String name, Object value) {
        if (OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (this.extensions == null)
            this.extensions = new java.util.LinkedHashMap<>();
        this.extensions.put(name, value);
    }
    /**
     * Sets the entire map of vendor-specific extensions for this object.
     *
     * @param extensions a map of extension properties
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    /**
     * Compares this {@code ExternalDocumentation} object with another for equality.
     *
     * @param object the object to compare with
     * @return {@code true} if all fields are equal, otherwise {@code false}
     */
    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        ExternalDocumentation that = (ExternalDocumentation) object;
        return Objects.equals(description, that.description) &&
                Objects.equals(url, that.url) &&
                Objects.equals(extensions, that.extensions);
    }

    /**
     * Computes the hash code based on {@code description}, {@code url}, and {@code extensions}.
     *
     * @return the computed hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, url, extensions);
    }

    /**
     * Returns a string representation of this object in a structured format.
     *
     * @return a formatted string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExternalDocumentation {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}