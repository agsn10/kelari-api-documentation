package io.github.kelari.model.v3.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a set of OAuth2 scopes for use in a security scheme.
 * <p>
 * Scopes define fine-grained access control and are used in the context of OAuth2 flows
 * to describe the permissions required by an API operation.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * Scopes scopes = new Scopes()
 *     .addString("read:pets", "read your pets")
 *     .addString("write:pets", "modify pets in your account")
 *     .addExtension("x-custom", Map.of("example", "value"));
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * scopes:
 *   read:pets: read your pets
 *   write:pets: modify pets in your account
 *   x-custom:
 *     example: value
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#oauth-flow-object">OpenAPI 3.0.1 – OAuth Flow Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Scopes extends LinkedHashMap<String, String> implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Scopes.class.getName());

    private Map<String, Object> extensions = null;

    /**
     * Adds a scope and its description to this map.
     *
     * @param name the name of the scope (e.g., {@code "read:pets"})
     * @param item the description of the scope (e.g., {@code "read your pets"})
     * @return this {@code Scopes} instance for method chaining
     */
    public Scopes addString(String name, String item) {
        this.put(name, item);
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
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (Objects.isNull(extensions)) {
            extensions = new LinkedHashMap<>();
        }
        this.extensions.put(name, value);
    }

    /**
     * Compares this {@code Scopes} object to another for equality.
     *
     * @param object the object to compare to
     * @return {@code true} if both objects are equal in content, {@code false} otherwise
     */
    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Scopes scopes = (Scopes) object;
        return Objects.equals(extensions, scopes.extensions);
    }

    /**
     * Returns a hash code value for this {@code Scopes} object.
     *
     * @return a hash code computed from the scopes and extensions
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extensions);
    }

    /**
     * Returns a string representation of this {@code Scopes} object,
     * formatted for readability.
     *
     * @return a formatted string describing the scopes
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Scopes {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
