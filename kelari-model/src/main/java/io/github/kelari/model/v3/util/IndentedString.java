package io.github.kelari.model.v3.util;

import java.util.Objects;

/**
 * Functional interface that deals with converting objects to indented strings.
 * <p>
 * This interface provides a default method for converting an object to a string with indentation,
 * adding spaces before each new line in the string.
 * </p>
 */
public interface IndentedString {

    /**
     /**
     * Converts the given object to string with each line indented by 4 spaces
     * (except the first line).
     *
     * <p>If the object is null, the string "null" will be returned. If the string contains
     * newline characters, they will be replaced with a new line followed by four spaces.</p>
     *
     * @param o the object to be converted.
     * @return The converted string, with indentation if new lines are present.
     */
    default String toIndentedString(Object o) {
        if (Objects.isNull(o))
            return "null";
        String str = o.toString();
        if (str.contains("\n"))
            return str.replace("\n", "\n    ");
        return str;
    }
}
