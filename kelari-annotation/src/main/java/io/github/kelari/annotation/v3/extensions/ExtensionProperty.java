package io.github.kelari.annotation.v3.extensions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents a single property of an {@link Extension}, which is used to define custom or vendor-specific metadata
 * in the OpenAPI specification.
 *
 * <p>
 * This annotation allows the definition of custom properties within an extension. Each property consists of a name
 * and a value, and they are typically used for adding non-standard attributes to OpenAPI components.
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
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 * @see Extension
 * @see Extensions
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExtensionProperty {

    /**
     * The name of the property.
     *
     * @return the name of the extension property.
     */
    String name();

    /**
     * The value of the property.
     *
     * @return the value of the extension property.
     */
    String value();
}
