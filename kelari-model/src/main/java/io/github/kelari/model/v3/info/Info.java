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
 * Represents metadata about the API for the OpenAPI specification.
 * <p>
 * This class provides general information about the API, such as its title,
 * description, terms of service, contact information, license, version, and
 * custom extensions. It is used in the root level of the OpenAPI document.
 * </p>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * info:
 *   title: Sample API
 *   description: API for demonstration purposes
 *   termsOfService: http://example.com/terms/
 *   contact:
 *     name: API Support
 *     email: support@example.com
 *   license:
 *     name: Apache 2.0
 *     url: https://www.apache.org/licenses/LICENSE-2.0.html
 *   version: 1.0.0
 * </pre>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Info apiInfo = new Info()
 *     .title("Sample API")
 *     .description("API for demonstration purposes")
 *     .termsOfService("http://example.com/terms/")
 *     .contact(new Contact().name("API Support").email("support@example.com"))
 *     .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
 *     .version("1.0.0");
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Contact
 * @see License
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#info-object">OpenAPI 3.0.1 – Info Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Info implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Info.class.getName());

    private String title = null;
    private String description = null;
    private String termsOfService = null;
    private Contact contact = null;
    private License license = null;
    private String version = null;
    private Map<String, Object> extensions = null;

    /**
     * Gets the title of the API.
     *
     * @return the API title.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title of the API.
     *
     * @param title the API title.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Fluent setter for the API title.
     *
     * @param title the API title.
     * @return this {@code Info} instance.
     */
    public Info title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Gets the description of the API.
     *
     * @return the API description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description of the API.
     *
     * @param description the API description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Fluent setter for the API description.
     *
     * @param description the API description.
     * @return this {@code Info} instance.
     */
    public Info description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Gets the terms of service URL.
     *
     * @return the terms of service URL.
     */
    public String getTermsOfService() {
        return termsOfService;
    }
    /**
     * Sets the terms of service URL.
     *
     * @param termsOfService the URL for the terms of service.
     */
    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }
    /**
     * Fluent setter for the terms of service URL.
     *
     * @param termsOfService the URL for the terms of service.
     * @return this {@code Info} instance.
     */
    public Info termsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
        return this;
    }

    /**
     * Gets the contact information.
     *
     * @return the contact information.
     */
    public Contact getContact() {
        return contact;
    }
    /**
     * Sets the contact information.
     *
     * @param contact the contact information.
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    /**
     * Fluent setter for the contact information.
     *
     * @param contact the contact information.
     * @return this {@code Info} instance.
     */
    public Info contact(Contact contact) {
        this.contact = contact;
        return this;
    }

    /**
     * Gets the license information.
     *
     * @return the license.
     */
    public License getLicense() {
        return license;
    }
    /**
     * Sets the license information.
     *
     * @param license the license.
     */
    public void setLicense(License license) {
        this.license = license;
    }
    /**
     * Fluent setter for the license.
     *
     * @param license the license.
     * @return this {@code Info} instance.
     */
    public Info license(License license) {
        this.license = license;
        return this;
    }

    /**
     * Gets the version of the API.
     *
     * @return the API version.
     */
    public String getVersion() {
        return version;
    }
    /**
     * Sets the version of the API.
     *
     * @param version the API version.
     */
    public void setVersion(String version) {
        this.version = version;
    }
    /**
     * Fluent setter for the API version.
     *
     * @param version the API version.
     * @return this {@code Info} instance.
     */
    public Info version(String version) {
        this.version = version;
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
        Info info = (Info) object;
        return Objects.equals(title, info.title) &&
               Objects.equals(description, info.description) &&
               Objects.equals(termsOfService, info.termsOfService) &&
               Objects.equals(contact, info.contact) &&
               Objects.equals(license, info.license) &&
               Objects.equals(version, info.version) &&
               Objects.equals(extensions, info.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, termsOfService, contact, license, version, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Info {\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    termsOfService: ").append(toIndentedString(termsOfService)).append("\n");
        sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
        sb.append("    license: ").append(toIndentedString(license)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}