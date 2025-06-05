package io.github.kelari.model.v3.enums;

/**
 * Enumeration representing the available styles for the encoding properties
 * in multipart requests as defined by the OpenAPI 3.0.1 specification.
 * <p>
 * These styles are used to specify how fields within multipart form data
 * should be serialized.
 * </p>
 *
 * <p><strong>Supported Styles:</strong></p>
 * <ul>
 *   <li>{@code form} – Default style for most use cases.</li>
 *   <li>{@code spaceDelimited} – Used for space-separated array values.</li>
 *   <li>{@code pipeDelimited} – Used for pipe-separated array values.</li>
 *   <li>{@code deepObject} – Used for nested object structures in query parameters.</li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * EncodingPropertyStyleEnum style = EncodingPropertyStyleEnum.FORM;
 * System.out.println(style.toString()); // Outputs "form"
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a>
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#encoding-object">OpenAPI 3.0.1 – Encoding Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum EncodingPropertyStyleEnum {

    /** Default form-style serialization. */
    FORM("form"),

    /** Space-delimited style (e.g., `value=blue%20green%20red`). */
    SPACEDELIMITED("spaceDelimited"),

    /** Pipe-delimited style (e.g., `value=blue|green|red`). */
    PIPEDELIMITED("pipeDelimited"),

    /** Deep object-style for nested objects (e.g., `color[R]=100`). */
    DEEPOBJECT("deepObject");

    private final String value;

    /**
     * Constructs the enum with the specified string value.
     *
     * @param value The string representation of the encoding style.
     */
    EncodingPropertyStyleEnum(String value) {
        this.value = value;
    }

    /**
     * Returns the string representation of the encoding style.
     *
     * @return the string value associated with this enum.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}