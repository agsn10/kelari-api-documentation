package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a discriminator object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code Discriminator} class is used to support polymorphism in OpenAPI documents.
 * It allows specifying a property name whose value determines the target schema for dynamic resolution,
 * along with an optional mapping of discriminator values to schema references.
 * </p>
 *
 * <p>This class supports method chaining for setting the property name, mapping, and vendor extensions.</p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * Discriminator discriminator = new Discriminator()
 *     .propertyName("type")
 *     .mappingRef("dog", "Dog")
 *     .mappingRef("cat", "Cat");
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * discriminator:
 *   propertyName: type
 *   mapping:
 *     dog: '#/components/schemas/Dog'
 *     cat: '#/components/schemas/Cat'
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#discriminator-object">OpenAPI 3.0.1 – Discriminator Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Discriminator implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Discriminator.class.getName());

    /**
     * The name of the property whose value will be used to determine the type.
     */
    private String propertyName;

    /**
     * A map that associates property values with specific type identifiers or schema references.
     */
    private Map<String, String> mapping;

    /**
     * A map for storing vendor-specific or user-defined extensions.
     */
    private Map<String, Object> extensions;

    /**
     * Sets the name of the property that acts as the discriminator.
     *
     * @param propertyName the name of the discriminator property
     * @return this instance for method chaining
     */
    public Discriminator propertyName(String propertyName) {
        this.propertyName = propertyName;
        return this;
    }

    /**
     * Returns the name of the discriminator property.
     *
     * @return the property name
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the name of the discriminator property.
     *
     * @param propertyName the property name
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Adds a mapping entry that links a discriminator value to a schema reference
     * using a standardized format.
     *
     * @param type       the discriminator value
     * @param schemaName the schema name to reference
     * @return this instance for method chaining
     */
    public Discriminator mappingRef(String type, String schemaName) {
        return mapping(type, "#/components/schemas/" + schemaName);
    }

    /**
     * Adds a mapping entry that links a discriminator value to a schema reference.
     *
     * @param name  the discriminator value
     * @param value the schema reference
     * @return this instance for method chaining
     */
    public Discriminator mapping(String name, String value) {
        if (Objects.isNull(this.mapping))
            this.mapping = new LinkedHashMap<>();
        this.mapping.put(name, value);
        return this;
    }

    /**
     * Sets the entire mapping between discriminator values and schema references.
     *
     * @param mapping the mapping map
     * @return this instance for method chaining
     */
    public Discriminator mapping(Map<String, String> mapping) {
        if (Objects.isNull(mapping))
            this.mapping = null;
        else
            this.mapping = new LinkedHashMap<>(mapping); // defensive copy
        return this;
    }

    /**
     * Returns the current mapping as an unmodifiable map.
     *
     * @return the mapping map, or {@code null} if not set
     */
    public Map<String, String> getMapping() {
        return mapping != null ? Collections.unmodifiableMap(mapping) : null;
    }

    /**
     * Sets the mapping between discriminator values and schema references.
     *
     * @param mapping the mapping map
     */
    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping != null ? new LinkedHashMap<>(mapping) : null;
    }

    /**
     * Adds a custom extension property to this discriminator.
     * Only keys starting with {@code "x-"} are allowed.
     *
     * @param name  the extension key
     * @param value the extension value
     * @return this instance for method chaining
     */
    public Discriminator extensions(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return this;
        }
        if (Objects.isNull(extensions))
            extensions = new LinkedHashMap<>();
        extensions.put(name, value);
        return this;
    }

    /**
     * Returns the map of extensions.
     *
     * @return an unmodifiable map of extensions, or {@code null} if none exist
     */
    public Map<String, Object> getExtensions() {
        return extensions != null ? Collections.unmodifiableMap(extensions) : null;
    }

    /**
     * Sets the entire extensions map.
     *
     * @param extensions the extensions to set
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions != null ? new LinkedHashMap<>(extensions) : null;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Discriminator)) return false;
        Discriminator that = (Discriminator) obj;
        return Objects.equals(propertyName, that.propertyName)
                && Objects.equals(mapping, that.mapping)
                && Objects.equals(extensions, that.extensions);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(propertyName, mapping, extensions);
    }

    /**
     * Returns a string representation of the object with indentation.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Discriminator {\n");
        sb.append("    propertyName: ").append(toIndentedString(propertyName)).append("\n");
        sb.append("    mapping: ").append(toIndentedString(mapping)).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}