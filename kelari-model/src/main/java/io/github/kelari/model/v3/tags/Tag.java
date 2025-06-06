package io.github.kelari.model.v3.tags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.ExternalDocumentation;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a tag used for logical grouping of OpenAPI operations.
 * <p>
 * Tags provide metadata for API documentation, helping to categorize operations
 * and enhance the readability of the OpenAPI specification. This class allows
 * specification of a tag's name, description, external documentation, and custom extensions.
 * </p>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * tags:
 *   - name: user
 *     description: Operations about user
 *     externalDocs:
 *       description: More info about the user API
 *       url: https://example.com/user-api
 * </pre>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Tag userTag = new Tag()
 *     .name("user")
 *     .description("Operations about user")
 *     .externalDocs(new ExternalDocumentation()
 *         .description("More info about the user API")
 *         .url("https://example.com/user-api"));
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see ExternalDocumentation
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#tag-object">OpenAPI 3.0.1 – Tag Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Tag.class.getName());

    private String name = null;
    private String description = null;
    private ExternalDocumentation externalDocs = null;
    private Map<String, Object> extensions = null;

    /**
     * Returns the name of the tag.
     *
     * @return the tag name.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the tag.
     *
     * @param name the tag name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Fluent method to set the tag name.
     *
     * @param name the tag name.
     * @return this Tag instance for method chaining.
     */
    public Tag name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Returns the description of the tag.
     *
     * @return the tag description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the tag.
     *
     * @param description the tag description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Fluent method to set the tag description.
     *
     * @param description the tag description.
     * @return this Tag instance for method chaining.
     */
    public Tag description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns the external documentation associated with the tag.
     *
     * @return an {@link ExternalDocumentation} object or {@code null} if not set.
     */
    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }
    /**
     * Sets the external documentation for the tag.
     *
     * @param externalDocs an {@link ExternalDocumentation} object.
     */
    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }
    /**
     * Fluent method to set external documentation.
     *
     * @param externalDocs an {@link ExternalDocumentation} object.
     * @return this Tag instance for method chaining.
     */
    public Tag externalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
        return this;
    }

    /**
     * Returns the custom extensions defined for this tag.
     *
     * @return a map of extension keys to values, or {@code null} if none are defined.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    /**
     * Sets the custom extensions for this tag.
     *
     * @param extensions a map of extension keys to values.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    /**
     * Adds a custom extension property to this tag.
     * <p>
     * Keys must follow the OpenAPI convention and start with {@code "x-"}.
     * If the name is invalid, it is ignored and a warning is logged.
     * </p>
     *
     * @param name  the name of the extension key.
     * @param value the associated value.
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
     * Checks whether this tag is equal to another object.
     *
     * @param object the object to compare.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Tag tag = (Tag) object;
        return Objects.equals(name, tag.name) &&
                Objects.equals(description, tag.description) &&
                Objects.equals(externalDocs, tag.externalDocs) &&
                Objects.equals(extensions, tag.extensions);
    }

    /**
     * Returns the hash code for this tag.
     *
     * @return the hash code based on tag fields.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, description, externalDocs, extensions);
    }

    /**
     * Returns a string representation of the tag in an indented format.
     *
     * @return an indented string representation of the tag.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Tag {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    externalDocs: ").append(toIndentedString(externalDocs)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}