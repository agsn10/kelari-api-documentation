package io.github.kelari.model.v3.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents license information for the exposed API.
 * <p>
 * This class allows specification of license details for the API provider,
 * including the license name, URL, and custom extensions. It is commonly used
 * within the OpenAPI `info` section to describe the terms of service for the API.
 * </p>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * license:
 *   name: Apache 2.0
 *   url: https://www.apache.org/licenses/LICENSE-2.0.html
 * </pre>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * License license = new License()
 *     .name("Apache 2.0")
 *     .url("https://www.apache.org/licenses/LICENSE-2.0.html");
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#license-object">OpenAPI 3.0.1 – License Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class License implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(License.class.getName());

    private String name = null;
    private String url = null;
    private Map<String, Object> extensions = null;

    /**
     * Gets the license name.
     *
     * @return the name of the license.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the license name.
     *
     * @param name the license name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Fluent setter for the license name.
     *
     * @param name the license name.
     * @return this instance for method chaining.
     */
    public License name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the license URL.
     *
     * @return the URL of the license.
     */
    public String getUrl() {
        return url;
    }
    /**
     * Sets the license URL.
     *
     * @param url the URL of the license.
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Fluent setter for the license URL.
     *
     * @param url the license URL.
     * @return this instance for method chaining.
     */
    public License url(String url) {
        this.url = url;
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
        if (object == null || getClass() != object.getClass()) return false;
        License license = (License) object;
        return Objects.equals(name, license.name) &&
               Objects.equals(url, license.url) &&
               Objects.equals(extensions, license.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class License {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}