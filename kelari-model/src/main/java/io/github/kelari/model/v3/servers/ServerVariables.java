package io.github.kelari.model.v3.servers;

import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a container of named {@link ServerVariable} objects for server URL substitution.
 * <p>
 * This object allows the definition of template variables that can be used within a Server URL.
 * Each variable is an entry keyed by the variable name.
 * </p>
 *
 * <p><strong>Example usage:</strong></p>
 * <pre>
 * variables:
 *   port:
 *     default: "8443"
 *     description: Secure port
 *     x-internal-id: "abc123"
 *     x-oai-info: "extra details"
 *     x-extra-info: "Some vendor extension"
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#servervariableobject">OpenAPI 3.0.1 – Server Variable Object</a>
 * @see ServerVariable
 * @copyright 2025 Kelari. All rights reserved.
 */
public class ServerVariables extends LinkedHashMap<String, ServerVariable> implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(ServerVariables.class.getName());

    private Map<String, Object> extensions = null; // <- here go x-*

    /**
     * Adds a named {@link ServerVariable} to the container.
     *
     * @param name the name of the variable
     * @param item the {@link ServerVariable} object
     * @return the updated {@code ServerVariables} instance
     */
    public ServerVariables addServerVariable(String name, ServerVariable item) {
        this.put(name, item);
        return this;
    }

    /**
     * Adds a vendor extension (key starting with "x-") to the extensions map.
     *
     * @param name the name of the extension property
     * @param value the value of the extension property
     * @return the updated {@code ServerVariables} instance
     */
    public ServerVariables extensions(String name, Object value) {
        if (OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return this;
        }
        if(Objects.isNull(extensions))
            extensions = new LinkedHashMap<>();
        extensions.put(name, value);
        return this;
    }

    /**
     * Returns the vendor extensions map.
     *
     * @return a map of extension properties, or {@code null} if none are present
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    /**
     * Sets the vendor extensions map.
     *
     * @param extensions a map of extension properties to set
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ServerVariables that = (ServerVariables) object;
        return Objects.equals(extensions, that.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServerVariables {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}