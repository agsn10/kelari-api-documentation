package io.github.kelari.annotation.v3.media;

import io.github.kelari.annotation.v3.extensions.Extension;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Describes an OpenAPI Schema Object for an array type.
 * <p>
 * This annotation allows detailed specification of array-type schemas including the
 * constraints on the array itself (e.g., min/max items, uniqueness), as well as the schema
 * of the items contained in the array.
 * </p>
 *
 * <p>
 * This models the OpenAPI 3.0.1 <strong>Schema Object</strong> for types of <code>array</code>.
 * </p>
 *
 * <p><strong>Specification Reference:</strong><br>
 * <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 - Schema Object</a>
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @ArraySchema(
 *     schema = @Schema(type = "string"),
 *     minItems = 1,
 *     maxItems = 10,
 *     uniqueItems = true
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see Extension
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value = {FIELD, METHOD, PARAMETER, TYPE, ANNOTATION_TYPE})
@Retention(value = RUNTIME)
@Inherited
public @interface ArraySchema {

    /**
     * Defines schema-level properties for the array itself.
     * This is distinct from the {@code schema()} element which defines the item schema.
     *
     * @return A schema describing the array as a whole.
     */
    Schema arraySchema() default @Schema;

    /**
     * An optional list of specification extensions.
     *
     * @return An array of extensions.
     */
    Extension[] extensions() default {};

    /**
     * Sets the maximum number of items allowed in the array.
     * Ignored if the value is equal to {@code Integer.MIN_VALUE}.
     *
     * @return Maximum number of items.
     */
    int maxItems() default Integer.MIN_VALUE;

    /**
     * Sets the minimum number of items required in the array.
     * Ignored if the value is equal to {@code Integer.MAX_VALUE}.
     *
     * @return Minimum number of items.
     */
    int minItems() default Integer.MAX_VALUE;

    /**
     * Defines the schema for the items contained in the array.
     *
     * @return The item schema.
     */
    Schema schema() default @Schema;

    /**
     * Specifies whether array items must be unique.
     *
     * @return {@code true} if items must be unique, {@code false} otherwise.
     */
    boolean uniqueItems() default false;
}
