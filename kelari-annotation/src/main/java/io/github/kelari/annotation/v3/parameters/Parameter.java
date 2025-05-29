package io.github.kelari.annotation.v3.parameters;

import io.github.kelari.annotation.v3.enums.Explode;
import io.github.kelari.annotation.v3.enums.ParameterIn;
import io.github.kelari.annotation.v3.enums.ParameterStyle;
import io.github.kelari.annotation.v3.extensions.Extension;
import io.github.kelari.annotation.v3.media.ArraySchema;
import io.github.kelari.annotation.v3.media.Content;
import io.github.kelari.annotation.v3.media.ExampleObject;
import io.github.kelari.annotation.v3.media.Schema;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Defines a single operation parameter. A parameter is a key-value pair that is used to pass information between the client and server.
 * This annotation allows fine-grained control over parameter characteristics and behavior.
 *
 * <p>It supports all types of parameters defined in the OpenAPI Specification, such as:
 * <ul>
 *   <li><strong>query</strong> – parameters appended to the URL</li>
 *   <li><strong>header</strong> – custom headers</li>
 *   <li><strong>path</strong> – values embedded in the URL path</li>
 *   <li><strong>cookie</strong> – values passed via cookies</li>
 * </ul>
 *
 * <p>Parameters may also be reused by referencing definitions from the OpenAPI Components section via the {@code ref} field.</p>
 *
 * <p>This annotation is repeatable using the {@link Parameters} container annotation.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see Content
 * @see Extension
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value = {PARAMETER, METHOD, FIELD, ANNOTATION_TYPE})
@Retention(value = RUNTIME)
@Repeatable(value = Parameters.class)
@Inherited
public @interface Parameter {

    /**
     * When true, allows sending an empty value. If false, the parameter will be considered "null" if no value is present.
     * This may cause validation errors if the parameter is required.
     */
    boolean allowEmptyValue() default false;

    /**
     * Determines whether the parameter value should allow reserved characters (like :/?#[]@!$&'()*+,;=).
     * This only applies to parameters with "in" value of "query".
     */
    boolean allowReserved() default false;

    /**
     * Specifies the schema if the parameter is an array.
     */
    ArraySchema array() default @ArraySchema;

    /**
     * Defines a representation of this parameter for different media types.
     */
    Content[] content() default {};

    /**
     * Marks the parameter as deprecated. Tools may use this to show a warning to API consumers.
     */
    boolean deprecated() default false;

    /**
     * An optional description for the parameter. CommonMark syntax MAY be used for rich text representation.
     */
    String description() default "";

    /**
     * A single example of the parameter's usage.
     */
    String example() default "";

    /**
     * An array of example objects showing possible values for the parameter.
     */
    ExampleObject[] examples() default {};

    /**
     * When true, values of type array/object generate separate parameters for each value/key.
     */
    Explode explode() default Explode.DEFAULT;

    /**
     * Optional vendor-specific extensions.
     */
    Extension[] extensions() default {};

    /**
     * Whether this parameter should be hidden from documentation or tooling.
     */
    boolean hidden() default false;

    /**
     * Location of the parameter (e.g., "query", "header", "path", or "cookie").
     */
    ParameterIn in() default ParameterIn.DEFAULT;

    /**
     * The name of the parameter. Required when not referencing via {@code ref}.
     */
    String name() default "";

    /**
     * A reference to a reusable parameter component definition.
     */
    String ref() default "";

    /**
     * Whether this parameter is mandatory. Required to be true when {@code in = path}.
     */
    boolean required() default false;

    /**
     * The schema that defines the type and format of the parameter.
     */
    Schema schema() default @Schema;

    /**
     * Serialization style of the parameter (e.g., form, simple, spaceDelimited, etc.).
     */
    ParameterStyle style() default ParameterStyle.DEFAULT;
}
