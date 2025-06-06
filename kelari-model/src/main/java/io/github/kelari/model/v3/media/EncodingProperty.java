package io.github.kelari.model.v3.media;

import io.github.kelari.model.v3.enums.EncodingPropertyStyleEnum;
import io.github.kelari.model.v3.headers.Header;
import io.github.kelari.model.v3.util.IndentedString;
import io.github.kelari.model.v3.util.OpenApiPredicates;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Represents an encoding property of a multipart request in accordance with the OpenAPI 3 specification.
 * <p>
 * This class defines how individual properties in a multipart/form-data request should be encoded.
 * It supports content type overrides, header specifications, and various serialization styles.
 * </p>
 *
 * <p><strong>Example usage:</strong></p>
 * <pre>{@code
 * EncodingProperty encoding = new EncodingProperty()
 *     .contentType("application/json")
 *     .style(EncodingPropertyStyleEnum.FORM)
 *     .explode(true)
 *     .allowReserved(false)
 *     .addHeaderObject("X-Custom-Header", new Header().description("Example header"));
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a>
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#encoding-object">OpenAPI Specification: Encoding Object</a>
 */
public class EncodingProperty implements Serializable, IndentedString {

    private static final Logger LOGGER = Logger.getLogger(EncodingProperty.class.getName());

    /** The media type for encoding a specific property. */
    private String contentType = null;
    /** Additional headers to include with the property. */
    private Map<String, Header> headers = null;
    /** The style of the property value serialization. */
    private EncodingPropertyStyleEnum style = null;
    /** Determines whether the property should be exploded into multiple parameters. */
    private Boolean explode = null;
    /** Determines whether reserved characters are allowed in the parameter value. */
    private Boolean allowReserved = null;
    /** Vendor-specific extensions. Keys must start with {@code "x-"}. */
    private Map<String, Object> extensions = null;

    /**
     * @return the content type of the encoding.
     * */
    public String getContentType() {
        return contentType;
    }
    /**
     *  @param contentType the media type to use for the encoding.
     * */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    /**
     *  @param contentType the media type to use for the encoding.
     * @return the updated {@link EncodingProperty} instance.
     */
    public EncodingProperty contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     *  @return the headers to include with the encoding.
     * */
    public Map<String, Header> getHeaders() {
        return headers;
    }
    /**
     * @param headers a map of header names to {@link Header} objects.
     * */
    public void setHeaders(Map<String, Header> headers) {
        this.headers = headers;
    }
    /**
     * @param headers a map of header names to {@link Header} objects.
     * @return the updated {@link EncodingProperty} instance.
     */
    public EncodingProperty headers(Map<String, Header> headers) {
        this.headers = headers;
        return this;
    }
    /**
     * Adds a single header to the encoding.
     *
     * @param name   the name of the header
     * @param header the {@link Header} object
     * @return the updated {@link EncodingProperty} instance
     */
    public EncodingProperty addHeaderObject(String name, Header header) {
        if (Objects.isNull(this.headers))
            headers = new LinkedHashMap<>();
        headers.put(name, header);
        return this;
    }

    /**
     *  @return the encoding style used.
     * */
    public EncodingPropertyStyleEnum getStyle() {
        return style;
    }
    /**
     * @param style the encoding style to set.
     * */
    public void setStyle(EncodingPropertyStyleEnum style) {
        this.style = style;
    }
    /**
     * @param style the encoding style to set.
     * @return the updated {@link EncodingProperty} instance.
     */
    public EncodingProperty style(EncodingPropertyStyleEnum style) {
        this.style = style;
        return this;
    }

    /**
     *  @return whether the property is exploded into separate parameters.
     *  */
    public Boolean getExplode() {
        return explode;
    }
    /**
     * @param explode whether to explode the property.
     * */
    public void setExplode(Boolean explode) {
        this.explode = explode;
    }
    /**
     * @param explode whether to explode the property.
     * @return the updated {@link EncodingProperty} instance.
     */
    public EncodingProperty explode(Boolean explode) {
        this.explode = explode;
        return this;
    }

    /**
     * @return whether reserved characters are allowed.
     * */
    public Boolean getAllowReserved() {
        return allowReserved;
    }
    /** @param allowReserved whether reserved characters are allowed. */
    public void setAllowReserved(Boolean allowReserved) {
        this.allowReserved = allowReserved;
    }
    /**
     * @param allowReserved whether reserved characters are allowed.
     * @return the updated {@link EncodingProperty} instance.
     */
    public EncodingProperty allowReserved(Boolean allowReserved) {
        this.allowReserved = allowReserved;
        return this;
    }

    /**
     * @return a map of custom extension properties for this encoding.
     */
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    /**
     * Sets all custom extension properties for this encoding.
     *
     * @param extensions a map of extension names (must start with {@code "x-"}) to values
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
     * @param value the value associated with the extension property.
     */
    public void addExtension(String name, Object value) {
        if (!OpenApiPredicates.IS_VALID_EXTENSION_NAME.test(name)) {
            LOGGER.warning(() -> String.format("Ignored invalid extension key: '%s'. Keys must start with 'x-'.", name));
            return;
        }
        if (Objects.isNull(extensions))
            extensions = new LinkedHashMap<>();
        this.extensions.put(name, value);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        EncodingProperty that = (EncodingProperty) object;
        return Objects.equals(contentType, that.contentType) &&
                Objects.equals(headers, that.headers) &&
                style == that.style &&
                Objects.equals(explode, that.explode) &&
                Objects.equals(allowReserved, that.allowReserved) &&
                Objects.equals(extensions, that.extensions);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return Objects.hash(contentType, headers, style, explode, allowReserved, extensions);
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EncodingProperty {\n");
        sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
        sb.append("    headers: ").append(toIndentedString(headers)).append("\n");
        sb.append("    style: ").append(toIndentedString(style)).append("\n");
        sb.append("    explode: ").append(toIndentedString(explode)).append("\n");
        sb.append("    allowReserved: ").append(toIndentedString(allowReserved)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}