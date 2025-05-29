package io.github.kelari.annotation.v3.media;

import io.github.kelari.annotation.v3.extensions.Extension;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Describes a single media type definition used in request or response content.
 *
 * <p>
 * This annotation allows the specification of metadata such as the schema used to define
 * the structure of the content, examples, encoding strategies, and custom extensions.
 * </p>
 *
 * <p>
 * Corresponds to the <strong>Media Type Object</strong> as defined in the
 * <a href="https://spec.openapis.org/oas/v3.0.1#media-type-object">OpenAPI 3.0.1 Specification</a>.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Content(
 *     mediaType = "application/json",
 *     schema = @Schema(implementation = User.class),
 *     examples = {@ExampleObject(name = "example", value = "{\"name\":\"John\"}")}
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see ArraySchema
 * @see Encoding
 * @see ExampleObject
 * @see Extension
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value = ANNOTATION_TYPE)
@Retention(value = RUNTIME)
@Inherited
public @interface Content {

    /**
     * The schema of the array that defines the type used for the content.
     *
     * @return The schema of the array content.
     */
    ArraySchema array() default @ArraySchema;

    /**
     * An array of encodings. The key (property name) MUST exist in the schema as a property.
     *
     * @return The array of encodings to apply to individual properties.
     */
    Encoding[] encoding() default {};

    /**
     * An array of examples used to illustrate the usage of the associated schema.
     *
     * @return An array of example objects.
     */
    ExampleObject[] examples() default {};

    /**
     * An optional list of extensions for the content definition.
     *
     * @return An array of extensions.
     */
    Extension[] extensions() default {};

    /**
     * Specifies the media type the content applies to (e.g., "application/json").
     *
     * @return The media type as a string.
     */
    String mediaType() default "";

    /**
     * The schema defining the structure and type used for the content.
     *
     * @return The schema of this media type.
     */
    Schema schema() default @Schema;
}
