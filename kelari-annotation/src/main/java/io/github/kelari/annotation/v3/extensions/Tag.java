package io.github.kelari.annotation.v3.extensions;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a tag for categorizing and describing operations in the OpenAPI specification.
 *
 * <p>
 * The {@code @Tag} annotation is used to add metadata about the operation grouping.
 * It can include a name, description, extensions, and external documentation. These tags
 * allow for better organization of API operations in the OpenAPI documentation.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Tag(
 *     name = "User Operations",
 *     description = "Operations related to user management",
 *     extensions = {
 *         @Extension(name = "version", properties = {
 *             @ExtensionProperty(name = "value", value = "1.0")
 *         })
 *     }
 * )
 * public class UserController {
 *     // API logic here
 * }
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#tag-object">OpenAPI Tag Object</a>
 */
@Target(value={METHOD,TYPE,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Repeatable(value=Tags.class)
@Inherited
public @interface Tag {
    /**
     * The name of this tag.
     */
    String name();

    /**
     * A brief description of the tag.
     * Provides additional context or information about the tag.
     */
    String description() default "";

    /**
     * The list of optional extensions for this tag.
     * These can be used to add custom, vendor-specific information.
     */
    Extension[] extensions() default {};

    /**
     * Additional external documentation for this tag.
     * Provides more detailed or reference material for the tag.
     */
    ExternalDocumentation externalDocs() default @ExternalDocumentation;
}