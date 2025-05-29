package io.github.kelari.annotation.v3.media;

import io.github.kelari.annotation.v3.extensions.Extension;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a single example to illustrate the usage of a schema or request/response body.
 *
 * <p>
 * This annotation corresponds to the <strong>Example Object</strong> in the
 * <a href="https://spec.openapis.org/oas/v3.0.1#example-object">OpenAPI Specification 3.0.1</a>.
 * </p>
 *
 * <p>
 * This annotation can be used to define inline examples or link to external example files via a URL.
 * It is applied to another annotation (e.g., {@code @Content}) to enrich the documentation with sample data.
 * </p>
 *
 * <p><strong>Example:</strong></p>
 * <pre>{@code
 * @ExampleObject(
 *   name = "userExample",
 *   summary = "A simple user example",
 *   value = "{\"id\":1,\"name\":\"Antonio\"}"
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 * */
@Target(value = ANNOTATION_TYPE)
@Retention(value = RUNTIME)
@Inherited
public @interface ExampleObject {

    /**
     * A list of optional extensions that provide additional metadata for the example.
     *
     * @return An optional array of {@link Extension} annotations.
     */
    Extension[] extensions() default {};

    /**
     * A URL that points to an external document to be used as the example.
     * This property is mutually exclusive with {@link #value()}.
     *
     * @return The URL of the external example.
     */
    String externalValue() default "";

    /**
     * A unique identifier name for the example.
     *
     * @return The name of the example.
     */
    String name() default "";

    /**
     * A reference to a reusable example defined in the OpenAPI components section.
     *
     * @return The reference string (e.g., {@code "#/components/examples/UserExample"}).
     */
    String ref() default "";

    /**
     * A brief summary explaining the context or purpose of this example.
     *
     * @return A summary string.
     */
    String summary() default "";

    /**
     * A string representation of the example. Ignored if {@link #externalValue()} is specified.
     * May be parsed into an object if applicable for the associated media type.
     *
     * @return The value of the example.
     */
    String value() default "";
}
