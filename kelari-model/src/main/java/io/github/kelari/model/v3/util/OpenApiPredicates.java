package io.github.kelari.model.v3.util;

import io.github.kelari.model.v3.media.Schema;

import java.util.function.Predicate;

/**
 * Utility class for OpenAPI-related validation predicates.
 * <p>
 * This class provides reusable {@link Predicate} instances to validate and
 * filter various components according to the OpenAPI 3.0.1 specification.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 * */
public final class OpenApiPredicates {

    private OpenApiPredicates() {
        // Prevent instantiation
    }

    /**
     * Predicate to validate whether an extension key is valid
     * according to OpenAPI 3.0.1 specification.
     * <p>
     * A valid extension key must be non-null, non-empty,
     * and start with "x-".
     */
    public static final Predicate<String> IS_VALID_EXTENSION_NAME =
            name -> name != null && !name.isEmpty() && name.startsWith("x-");

    /**
     * Predicate that returns true if the reference is non-null
     * and does not contain '.' or '/'.
     */
    public static final Predicate<String> IS_SIMPLE_REF_USING_CONTAINS =
            ref -> ref != null && !ref.contains(".") && !ref.contains("/");

    /**
     * Predicate that checks if the provided reference string
     * is a simple reference by ensuring the index of '.' and '/'
     * characters is -1.
     * <p>
     * Equivalent to {@link #IS_SIMPLE_REF_USING_CONTAINS} using {@code indexOf} instead.
     * </p>
     */
    public static final Predicate<String> IS_SIMPLE_REF_USING_INDEXOF =
            ref -> ref != null && (ref.indexOf('.') == -1 && ref.indexOf('/') == -1);

    /**
     * Predicate that checks whether a given {@link Number} can safely
     * be cast to an {@code Integer} without overflow.
     * <p>
     * This includes values within the range from {@link Integer#MIN_VALUE}
     * to {@link Integer#MAX_VALUE}.
     * </p>
     */
    public static final Predicate<Number> IS_WITHIN_INTEGER_RANGE = casted ->
            casted != null &&
                    casted.longValue() >= Integer.MIN_VALUE &&
                    casted.longValue() <= Integer.MAX_VALUE;

    /**
     * Predicate that checks if a Schema's {@code additionalProperties} field contains an invalid value.
     * <p>
     * According to the OpenAPI Specification, the value of {@code additionalProperties} must be
     * either {@code null}, a {@code Boolean}, or an instance of {@code Schema}.
     * This predicate returns {@code true} when the value is not {@code null} and is neither
     * a {@code Boolean} nor a {@code Schema} object — i.e., it is invalid.
     * </p>
     */
    public static final Predicate<Object> SCHEMA_INVALID_ADDITIONAL_PROPERTIES =
            ap -> ap != null
                    && !(ap instanceof Boolean)
                    && !(ap instanceof Schema);

    /**
     * Predicate that tests if a $ref string in a Schema is a plain reference name,
     * meaning it does not start with "#" and does not contain "." or "/" characters.
     * <p>
     * This is used to determine if the $ref value needs to be converted into a full
     * JSON pointer like "#/components/schemas/RefName".
     * </p>
     *
     * <p><strong>Example match:</strong> "MySchema"</p>
     * <p><strong>Example non-match:</strong> "#/components/schemas/MySchema", "common/MySchema"</p>
     */
    public static final Predicate<String> SCHEMA_PLAIN_REFERENCE =
            ref -> ref != null && !ref.startsWith("#") && !ref.contains(".") && !ref.contains("/");
}