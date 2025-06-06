package io.github.kelari.model.v3.paths;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents the paths of the exposed API.
 * <p>
 * This class is used to specify the available operations for each API path,
 * including the path item details and custom extensions. It is commonly used
 * within the OpenAPI `paths` section to define the available HTTP operations
 * for an API.
 * </p>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * paths:
 *   /users:
 *     get:
 *       summary: Retrieve a list of users
 *       operationId: getUsers
 *       responses:
 *         200:
 *           description: A list of users
 * </pre>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Paths paths = new Paths();
 * paths.addPathItem("/users", new PathItem().get(new Operation().operationId("getUsers")));
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#paths-object">OpenAPI 3.0.1 – Paths Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paths extends LinkedHashMap<String, PathItem> implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Paths.class.getName());

    private Map<String, Object> extensions = null;

    /**
     * Adds a new path item to this collection.
     * <p>
     * This method allows you to define a new API path and associate it with a specific
     * path item, which contains the available HTTP operations for that path. The method
     * returns the current {@code Paths} instance to allow for method chaining.
     * </p>
     **
     * @param name the path name (e.g., "/users") to be added.
     * @param item the path item, which defines the operations for this path.
     * @return this {@code Paths} instance for method chaining.
     */
    public Paths addPathItem(String name, PathItem item) {
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
    public boolean equals(Object object) {
        if ( Objects.isNull(object) || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Paths paths = (Paths) object;
        return Objects.equals(extensions, paths.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Paths {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}