package io.github.kelari.model.v3.enums;

/**
 * Enum representing parameter serialization styles as defined by the
 * OpenAPI 3.1 specification. These styles determine how values are serialized
 * in the request URI (path, query, header, or cookie).
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#style-values">OpenAPI 3.1.0 - Style Values</a>
 */
public enum StyleParameterEnum {

    /**
     * Matrix style: parameters are serialized as path segments preceded by a semicolon.
     * Example: {@code /users;id=123}
     */
    MATRIX("matrix"),

    /**
     * Label style: parameters are prefixed with a period.
     * Example: {@code /users/.123}
     */
    LABEL("label"),

    /**
     * Form style: parameters are serialized as key=value pairs.
     * This is the default for query and formData parameters.
     * Example: {@code id=123&name=foo}
     */
    FORM("form"),

    /**
     * Simple style: values are comma-separated.
     * Commonly used for path and header parameters.
     * Example: {@code id=123,456}
     */
    SIMPLE("simple"),

    /**
     * Space-delimited style: values are separated by spaces.
     * Example: {@code id=123 456}
     */
    SPACEDELIMITED("spaceDelimited"),

    /**
     * Pipe-delimited style: values are separated by pipe symbols.
     * Example: {@code id=123|456}
     */
    PIPEDELIMITED("pipeDelimited"),

    /**
     * Deep object style: used to serialize nested objects in query parameters using bracket notation.
     * Example: {@code user[name]=alex&user[age]=30}
     */
    DEEPOBJECT("deepObject");

    private final String value;

    StyleParameterEnum(String value) {
        this.value = value;
    }

    /**
     * Returns the string representation of the style.
     *
     * @return the style as a string
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}