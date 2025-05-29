package io.github.kelari.annotation.v3.extensions;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a vendor-specific or custom extension property, typically used to add additional metadata
 * to OpenAPI components that are not part of the official specification.
 *
 * <p>
 * Each {@code Extension} may define a set of {@link ExtensionProperty properties} and an optional
 * {@code name}, which will be prefixed with {@code x-} as required by the OpenAPI Specification.
 * </p>
 *
 * <p>
 * This annotation is {@link Repeatable} via the {@link Extensions} container, and can be applied
 * to types, methods, fields, parameters, or other annotations.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Extension(
 *     name = "rate-limit",
 *     properties = {
 *         @ExtensionProperty(name = "requestsPerMinute", value = "100"),
 *         @ExtensionProperty(name = "burstCapacity", value = "20")
 *     }
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @see ExtensionProperty
 * @see Extensions
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target({FIELD, METHOD, PARAMETER, TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Repeatable(Extensions.class)
public @interface Extension {

    /**
     * The extension properties that compose this extension definition.
     *
     * @return the actual extension properties.
     */
    ExtensionProperty[] properties();

    /**
     * An optional identifier for grouping this set of extension properties. This name will be
     * prefixed with {@code x-} when rendered in the OpenAPI document.
     *
     * @return the name for the extension.
     */
    String name() default "";
}
