package io.github.kelari.model.v3.callbacks;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.kelari.model.v3.paths.PathItem;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a Callback object in the OpenAPI 3.0.1 specification.
 * <p>
 * A {@code Callback} is a map of possible out-of-band callbacks related to the parent operation.
 * Each value in the map is a {@link PathItem} that describes a request that may be initiated by the API provider
 * and the expected responses.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Callback callback = new Callback();
 * callback.addPathItem("{$request.body#/callbackUrl}", new PathItem());
 * callback.$ref("MyCallbackRef");
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * callbacks:
 *   myEvent:
 *     '{$request.body#/callbackUrl}':
 *       post:
 *         requestBody:
 *           description: Callback payload
 *           content:
 *             application/json:
 *               schema:
 *                 $ref: '#/components/schemas/SomeSchema'
 *         responses:
 *           '200':
 *             description: Callback received
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see PathItem
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#callback-object">OpenAPI 3.0.1 – Callback Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#reference-object">OpenAPI 3.0.1 – Reference Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Callback extends LinkedHashMap<String, PathItem> implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Callback.class.getName());

    private Map<String, Object> extensions = null;
    @JsonProperty("$ref")
    private String $ref = null;

    /**
     * Returns the callback reference string.
     *
     * @return the value of the {@code $ref} field.
     */
    public String get$ref() {
        return $ref;
    }
    /**
     * Sets the callback reference. If the reference is a simple name, it is expanded to a full component reference.
     *
     * @param $ref the reference string to set.
     */
    public void set$ref(String $ref) {
        if (OpenApiPredicates.IS_SIMPLE_REF_USING_INDEXOF.test($ref))
            $ref = "#/components/callbacks/" + $ref;
        this.$ref = $ref;
    }
    /**
     * Fluent setter for the callback reference.
     *
     * @param $ref the reference string.
     * @return this {@link Callback} instance.
     */
    public Callback $ref(String $ref) {
        set$ref($ref);
        return this;
    }

    /**
     * Adds a {@link PathItem} to this callback definition.
     *
     * @param name the expression or key name.
     * @param item the path item describing the callback.
     * @return this {@link Callback} instance.
     */
    public Callback addPathItem(String name, PathItem item) {
        this.put(name, item);
        return this;
    }

    /**
     * Gets the OpenAPI specification extensions.
     *
     * @return a map of extension names to values.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a custom extension to the callback.
     * <p>Keys must start with "x-" to be valid.</p>
     *
     * @param name  the name of the extension.
     * @param value the value of the extension.
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (Objects.isNull(this.extensions))
            this.extensions = new java.util.LinkedHashMap<>();
        this.extensions.put(name, value);
    }
    /**
     * Sets the OpenAPI specification extensions.
     *
     * @param extensions a map of extension names to values.
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Fluent setter for the OpenAPI specification extensions.
     *
     * @param extensions a map of extension names to values.
     * @return this {@link Callback} instance.
     */
    public Callback extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Callback callback = (Callback) object;
        return Objects.equals(extensions, callback.extensions) &&
               Objects.equals($ref, callback.$ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extensions, $ref);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Callback {\n");
        sb.append("    $ref: ").append(toIndentedString($ref)).append("\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}