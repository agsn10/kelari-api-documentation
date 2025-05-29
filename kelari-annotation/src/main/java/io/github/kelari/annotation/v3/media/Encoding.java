package io.github.kelari.annotation.v3.media;

import io.github.kelari.annotation.v3.extensions.Extension;
import io.github.kelari.annotation.v3.headers.Header;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents an encoding definition for a single property of a multipart or form-urlencoded request body.
 *
 * <p>
 * This annotation is used to specify how a specific property should be serialized and transmitted
 * as part of a media type such as {@code multipart/form-data}.
 * </p>
 *
 * <p>
 * Corresponds to the <strong>Encoding Object</strong> in the
 * <a href="https://spec.openapis.org/oas/v3.0.1#encoding-object">OpenAPI 3.0.1 Specification</a>.
 * </p>
 *
 * <p><strong>Example:</strong></p>
 * <pre>{@code
 * @Encoding(
 *   name = "profileImage",
 *   contentType = "image/png",
 *   headers = {@Header(name = "X-Custom-Header", description = "Custom header")},
 *   style = "form",
 *   explode = true
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a>
 * @since 1.0
 * @see Content
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value = {})
@Retention(value = RUNTIME)
@Inherited
public @interface Encoding {

    /**
     * Determines whether the parameter value should allow reserved characters,
     * as defined by RFC3986, to be included without percent-encoding.
     *
     * @return {@code true} if reserved characters are allowed without encoding; {@code false} otherwise.
     */
    boolean allowReserved() default false;

    /**
     * The media type to use for encoding a specific property.
     * This value overrides the default content type for the request body.
     *
     * @return The content type used for the property (e.g. "application/json", "image/png").
     */
    String contentType() default "";

    /**
     * When {@code true}, property values of type array or object generate separate parameters
     * for each item or key-value pair.
     *
     * @return {@code true} to explode complex objects into individual parameters; {@code false} otherwise.
     */
    boolean explode() default false;

    /**
     * A list of optional extensions that can be used to provide extra metadata.
     *
     * @return An array of {@link Extension} objects.
     */
    Extension[] extensions();

    /**
     * An array of header definitions to apply to this encoding.
     * Each header must be unique and correspond to an actual header used during transmission.
     *
     * @return An array of {@link Header} annotations.
     */
    Header[] headers() default {};

    /**
     * The name of this encoding instance.
     * This should match a property name defined in the associated schema.
     *
     * @return The name of the encoding.
     */
    String name() default "";

    /**
     * Describes how a specific property value will be serialized depending on its type.
     * Common values are "form", "spaceDelimited", or "pipeDelimited".
     *
     * @return A string representing the serialization style.
     */
    String style() default "";
}
