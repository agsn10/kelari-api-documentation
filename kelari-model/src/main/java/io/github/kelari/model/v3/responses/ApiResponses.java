package io.github.kelari.model.v3.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents a container for the responses of an API operation in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code ApiResponses} object holds a set of reusable {@link ApiResponse} objects, keyed by HTTP status code
 * or the string "default", describing the expected responses of an operation.
 * This object also allows the inclusion of specification extensions prefixed with {@code x-}.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * ApiResponses responses = new ApiResponses();
 * responses.addApiResponse("200", new ApiResponse().description("Successful operation"));
 * responses.addExtension("x-custom-flag", true);
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * responses:
 *   '200':
 *     description: Successful operation
 *   '404':
 *     description: Not found
 *   default:
 *     description: Unexpected error
 *     content:
 *       application/json:
 *         schema:
 *           $ref: '#/components/schemas/ErrorModel'
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see ApiResponse
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#responses-object">OpenAPI 3.0.1 – Responses Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#response-object">OpenAPI 3.0.1 – Response Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponses extends LinkedHashMap<String, ApiResponse> implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(ApiResponses.class.getName());

    private Map<String, Object> extensions = null;

    /**
     * Adds an {@link ApiResponse} to the map.
     *
     * @param name the HTTP status code or "default" key.
     * @param item the response to associate with the given key.
     * @return this {@code ApiResponses} instance for method chaining.
     */
    public ApiResponses addApiResponse(String name, ApiResponse item) {
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
     * Adds a custom extension to the response map.
     * <p>Only keys starting with {@code x-} are considered valid.</p>
     *
     * @param name  the name of the extension.
     * @param value the value of the extension.
     */
    public void addExtension(String name, Object value) {
        if (OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (Objects.isNull(this.extensions))
            this.extensions = new LinkedHashMap<>();
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
     * Sets the extensions and returns the current instance for method chaining.
     *
     * @param extensions a map of extension names to values.
     * @return this {@code ApiResponses} instance.
     */
    public ApiResponses extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    /**
     * Compares this {@code ApiResponses} object to another for equality.
     *
     * @param object the object to compare to.
     * @return {@code true} if the objects are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (Objects.isNull(object) || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ApiResponses that = (ApiResponses) object;
        return Objects.equals(extensions, that.extensions);
    }

    /**
     * Computes the hash code for this {@code ApiResponses} object.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), extensions);
    }

    /**
     * Returns a string representation of this {@code ApiResponses} object.
     *
     * @return a formatted string of this instance.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiResponses {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
