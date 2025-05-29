package io.github.kelari.annotation.v3;

import io.github.kelari.annotation.v3.extensions.Extension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Additional external documentation for the API.
 *
 * <p>This annotation is used to provide a reference to external documentation related to
 * a specific part of the API. It can be used to link to guides, tutorials, or any other
 * resources that may help consumers understand and use the API.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#external-documentation-object">OpenAPI Specification v3.1.0 – External Documentation Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @ExternalDocumentation(
 *     description = "Find more info here",
 *     url = "https://example.com/docs"
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#external-documentation-object">OpenAPI 3.1.0 – External Documentation Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExternalDocumentation {

    /**
     * A short description of the target documentation.
     * @return The documentation description.
     * */
    String description() default "";
    /**
     * The list of optional extensions.
     * @return An optional array of extensions.
     * */
    Extension[] extensions() default {};
    /**
     * The URL for the target documentation. Value must be in the format of a URL.
     * @return The documentation URL.
     * */
    String url() default "";
}