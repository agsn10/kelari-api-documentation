package io.github.kelari.annotation.v3.parameters;

import io.github.kelari.annotation.v3.extensions.Extension;
import io.github.kelari.annotation.v3.media.Content;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Describes a single request body for an operation.
 *
 * <p>This annotation allows you to define the structure and metadata of the expected body
 * content in an API request. It maps to the OpenAPI Specification's <i>requestBody</i> field.
 * It can be applied to a method, parameter, or annotation type.</p>
 *
 * <p>Example:</p>
 * <pre>{@code
 * @RequestBody(
 *     description = "User to add to the system",
 *     required = true,
 *     content = @Content(
 *         mediaType = "application/json",
 *         schema = @Schema(implementation = User.class)
 *     )
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @see Content
 * @see Extension
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value = {METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(value = RUNTIME)
@Inherited
public @interface RequestBody {

    /**
     * The content definitions for the request body, each corresponding to a media type.
     *
     * @return An array of {@link Content} annotations that define the request body structure.
     */
    Content[] content() default {};

    /**
     * A brief, optional description of the request body.
     * CommonMark syntax MAY be used for rich text representation.
     *
     * @return A string description of the request body.
     */
    String description() default "";

    /**
     * An optional list of extensions to add vendor-specific metadata.
     *
     * @return An array of {@link Extension} annotations.
     */
    Extension[] extensions() default {};

    /**
     * A reference to a predefined request body in the OpenAPI components section.
     *
     * @return A string referencing the component, e.g., "#/components/requestBodies/MyRequest".
     */
    String ref() default "";

    /**
     * Determines whether the request body is required.
     * Defaults to {@code false}.
     *
     * @return {@code true} if the request body is required; {@code false} otherwise.
     */
    boolean required() default false;
}