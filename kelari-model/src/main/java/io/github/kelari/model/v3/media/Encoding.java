package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.enums.StyleEncodingEnum;
import io.github.kelari.model.v3.headers.Header;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents the {@code Encoding} object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code Encoding} object allows you to describe how a specific property value will be serialized depending
 * on its type. This is applicable to {@code requestBody} content of type {@code multipart} or {@code application/x-www-form-urlencoded}.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Encoding encoding = new Encoding();
 * encoding.contentType("image/png, image/jpeg")
 *     .headers(Map.of(
 *         "X-Rate-Limit-Limit", new Header().description("The number of allowed requests in the current period")
 *             .schema(new Schema().type("integer"))
 *     ))
 *     .style(StyleEncodingEnum.FORM)
 *     .explode(true);
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * encoding:
 *   profileImage:
 *     contentType: image/png, image/jpeg
 *     headers:
 *       X-Rate-Limit-Limit:
 *         description: The number of allowed requests in the current period
 *         schema:
 *           type: integer
 *     style: form
 *     explode: true
 * </pre>
 *
 * <p>This class encapsulates encoding metadata including content type, headers, style, and additional extensions.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see StyleEncodingEnum
 * @see Header
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#encodingObject">OpenAPI 3.0.1 – Encoding Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Encoding implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(Encoding.class.getName());

    private String contentType;
    private Map<String, Header> headers;
    private StyleEncodingEnum style;
    private Boolean explode;
    private Boolean allowReserved;
    private Map<String, Object> extensions = null;

    /**
     * Sets the content type for this encoding.
     *
     * @param contentType the media type (e.g. application/json)
     * @return this Encoding instance
     */
    public Encoding contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
    /**
     * Returns the content type for this encoding.
     *
     * @return the media type string
     */
    public String getContentType() {
        return contentType;
    }
    /**
     * Sets the content type.
     *
     * @param contentType the media type
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Sets the headers map.
     *
     * @param headers a map of header names to Header objects
     * @return this Encoding instance
     */
    public Encoding headers(Map<String, Header> headers) {
        this.headers = headers;
        return this;
    }
    /**
     * Returns the headers map.
     *
     * @return a map of header names to Header objects
     */
    public Map<String, Header> getHeaders() {
        return headers;
    }
    /**
     * Sets the headers map.
     *
     * @param headers a map of header names to Header objects
     */
    public void setHeaders(Map<String, Header> headers) {
        this.headers = headers;
    }
    /**
     * Adds a single header to the headers map.
     *
     * @param name   the header name
     * @param header the Header object
     * @return this Encoding instance
     */
    public Encoding addHeader(String name, Header header) {
        if (this.headers == null)
            this.headers = new LinkedHashMap<>();
        this.headers.put(name, header);
        return this;
    }

    /**
     * Sets the style for this encoding.
     *
     * @param style the serialization style
     * @return this Encoding instance
     */
    public Encoding style(StyleEncodingEnum style) {
        this.style = style;
        return this;
    }
    /**
     * Returns the serialization style.
     *
     * @return the style enum
     */
    public StyleEncodingEnum getStyle() {
        return style;
    }
    /**
     * Sets the serialization style.
     *
     * @param style the style enum
     */
    public void setStyle(StyleEncodingEnum style) {
        this.style = style;
    }

    /**
     * Sets whether the parameter should explode.
     *
     * @param explode true if explode is enabled
     * @return this Encoding instance
     */
    public Encoding explode(Boolean explode) {
        this.explode = explode;
        return this;
    }
    /**
     * Returns whether the explode flag is set.
     *
     * @return true if explode is enabled, false otherwise
     */
    public Boolean getExplode() {
        return explode;
    }
    /**
     * Sets the explode flag.
     *
     * @param explode true or false
     */
    public void setExplode(Boolean explode) {
        this.explode = explode;
    }

    /**
     * Sets whether reserved characters are allowed.
     *
     * @param allowReserved true if allowed
     * @return this Encoding instance
     */
    public Encoding allowReserved(Boolean allowReserved) {
        this.allowReserved = allowReserved;
        return this;
    }
    /**
     * Returns whether reserved characters are allowed.
     *
     * @return true or false
     */
    public Boolean getAllowReserved() {
        return allowReserved;
    }
    /**
     * Sets the allowReserved flag.
     *
     * @param allowReserved true or false
     */
    public void setAllowReserved(Boolean allowReserved) {
        this.allowReserved = allowReserved;
    }

    /**
     * Returns the map of vendor extensions.
     *
     * @return a map of extensions
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Adds a vendor extension. Only keys starting with "x-" are allowed.
     *
     * @param name  the extension name
     * @param value the extension value
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name))
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
        if (this.extensions == null)
            this.extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }
    /**
     * Sets the entire map of extensions.
     *
     * @param extensions a map of extensions
     */
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }
    /**
     * Fluent setter for the extensions map.
     *
     * @param extensions a map of extensions
     * @return this Encoding instance
     */
    public Encoding extensions(Map<String, Object> extensions) {
        this.extensions = extensions;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Encoding encoding = (Encoding) object;
        return Objects.equals(contentType, encoding.contentType) &&
               Objects.equals(headers, encoding.headers) &&
               style == encoding.style &&
               Objects.equals(explode, encoding.explode) &&
               Objects.equals(allowReserved, encoding.allowReserved) &&
               Objects.equals(extensions, encoding.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentType, headers, style, explode, allowReserved, extensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Encoding {\n");
        sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
        sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
        sb.append("    style: ").append(toIndentedString(style)).append("\n");
        sb.append("    explode: ").append(toIndentedString(explode)).append("\n");
        sb.append("    allowReserved: ").append(toIndentedString(allowReserved)).append("\n");
        sb.append("    extensions: ").append(toIndentedString(extensions)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}