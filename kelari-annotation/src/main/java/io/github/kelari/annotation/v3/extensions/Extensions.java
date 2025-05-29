package io.github.kelari.annotation.v3.extensions;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a container for multiple {@link Extension} annotations, allowing the definition of several custom
 * or vendor-specific metadata properties within the OpenAPI specification.
 *
 * <p>
 * This annotation is {@link Inherited}, meaning that it can be inherited by subclasses. It can be applied to types,
 * fields, or other annotations to define multiple extensions in one place. The extensions can be used to add non-standard
 * attributes to OpenAPI components.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Extensions({
 *     @Extension(name = "rate-limit", properties = {
 *         @ExtensionProperty(name = "requestsPerMinute", value = "100"),
 *         @ExtensionProperty(name = "burstCapacity", value = "20")
 *     }),
 *     @Extension(name = "another-extension", properties = {
 *         @ExtensionProperty(name = "example", value = "true")
 *     })
 * })
 * public class ApiController {
 *     // API logic here
 * }
 * }</pre>
 *
 * <p>For more information, refer to the OpenAPI Specification:</p>
 * <a href="https://spec.openapis.org/oas/v3.0.1#specification-extensions">OpenAPI Specification - Extensions</a>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 * @see Extension
 * @see ExtensionProperty
 */
@Retention(RUNTIME)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Inherited
public @interface Extensions {

    /**
     * An array of {@link Extension} annotations.
     *
     * @return an array of Extension annotations.
     */
    Extension[] value();
}
