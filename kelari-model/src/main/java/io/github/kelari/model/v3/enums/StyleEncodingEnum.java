package io.github.kelari.model.v3.enums;

/**
 * Enum representing different encoding styles used in the OpenAPI 3.0.1 specification.
 * <p>
 * The encoding style describes how the data of an object will be serialized in a specific format, depending on how the data is grouped. This enum reflects the style options for encoding data in the context of the OpenAPI specification, as part of the {@code Encoding} object.
 * </p>
 *
 * <p><strong>Encoding Style Options:</strong></p>
 * <ul>
 *     <li>{@code form} - Common format used for form data encoding.</li>
 *     <li>{@code spaceDelimited} - Values separated by spaces.</li>
 *     <li>{@code pipeDelimited} - Values separated by a pipe (|).</li>
 *     <li>{@code deepObject} - Encoding where objects are encoded deeply.</li>
 * </ul>
 *
 * <p>This enum is used to specify the encoding style for serializing data in content types like {@code application/x-www-form-urlencoded} or {@code multipart}.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<-->] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#encodingObject">OpenAPI 3.0.1 – Encoding Object</a>
 */
public enum StyleEncodingEnum {

    /**
     * Represents the form encoding style.
     */
    FORM("form"),

    /**
     * Represents the space delimited encoding style.
     */
    SPACE_DELIMITED("spaceDelimited"),

    /**
     * Represents the pipe delimited encoding style.
     */
    PIPE_DELIMITED("pipeDelimited"),

    /**
     * Represents the deep object encoding style.
     */
    DEEP_OBJECT("deepObject");

    private String value;

    /**
     * Constructor for the {@code StyleEncodingEnum} enum.
     *
     * @param value The value associated with the encoding style.
     */
    StyleEncodingEnum(String value) {
        this.value = value;
    }

    /**
     * Returns the string representation of the encoding style.
     *
     * @return The string representing the encoding style.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Returns the encoding style corresponding to the provided value.
     *
     * @param value The string value to be converted to the encoding style.
     * @return The corresponding encoding style, or {@code null} if no match is found.
     */
    public static StyleEncodingEnum fromString(String value) {
        for (StyleEncodingEnum e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }
}
