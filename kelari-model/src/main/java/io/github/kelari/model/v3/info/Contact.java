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
 * Represents contact information for the exposed API.
 * <p>
 * This class allows specification of contact details for the API provider,
 * including name, URL, email, and custom extensions. It's commonly used
 * within the OpenAPI `info` section.
 * </p>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * contact:
 *   name: API Support
 *   url: https://example.com/support
 *   email: support@example.com
 * </pre>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Contact contact = new Contact()
 *     .name("API Support")
 *     .url("https://example.com/support")
 *     .email("support@example.com");
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#contact-object">OpenAPI 3.0.1 – Contact Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Contact.class.getName());

    private String name = null;
    private String url = null;
    private String email = null;
    private Map<String, Object> extensions = null;

    /**
     * Gets the contact name.
     *
     * @return the name of the contact person or organization.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the contact name.
     *
     * @param name the name of the contact person or organization.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Fluent setter for the contact name.
     *
     * @param name the name of the contact person or organization.
     * @return this {@code Contact} instance.
     */
    public Contact name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the URL pointing to the contact information.
     *
     * @return the URL to the contact information.
     */
    public String getUrl() {
        return url;
    }
    /**
     * Sets the URL pointing to the contact information.
     *
     * @param url the contact URL.
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Fluent setter for the contact URL.
     *
     * @param url the contact URL.
     * @return this {@code Contact} instance.
     */
    public Contact url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Gets the contact email address.
     *
     * @return the contact email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the contact email address.
     *
     * @param email the contact email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Fluent setter for the contact email.
     *
     * @param email the contact email.
     * @return this {@code Contact} instance.
     */
    public Contact email(String email) {
        this.email = email;
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
        Contact contact = (Contact) object;
        return Objects.equals(name, contact.name) &&
               Objects.equals(url, contact.url) &&
               Objects.equals(email, contact.email) &&
               Objects.equals(extensions, contact.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, email, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Contact {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}