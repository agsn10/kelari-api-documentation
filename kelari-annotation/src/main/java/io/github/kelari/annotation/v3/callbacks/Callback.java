package io.github.kelari.annotation.v3.callbacks;

import io.github.kelari.annotation.v3.extensions.Extension;
import io.github.kelari.annotation.v3.operations.Operation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Defines a single out-of-band {@code callback}, typically used to describe an asynchronous
 * webhook-like response that an API can invoke after an operation is initiated.
 *
 * <p>
 * This annotation is {@link Repeatable} via the {@link Callbacks} container and can be applied to methods,
 * fields, parameters, types, or other annotations to define callback behavior associated with a given element.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Callback(
 *     name = "onStatus",
 *     callbackUrlExpression = "http://example.com/callbacks/status"
 * )
 * public void onStatusUpdate() {
 *     // Callback logic here
 * }
 * }</pre>
 *
 * <p>For multiple callbacks, use the container annotation {@link Callbacks}:</p>
 * <pre>{@code
 * @Callbacks({
 *     @Callback(name = "onData", callbackUrlExpression = "http://example.com/callbacks/data"),
 *     @Callback(name = "onStatus", callbackUrlExpression = "http://example.com/callbacks/status")
 * })
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @see Callbacks
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#callbackObject">Callback (OpenAPI Specification)</a>
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target({FIELD, METHOD, PARAMETER, TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Repeatable(Callbacks.class)
@Inherited
public @interface Callback {

    /**
     * The friendly name used to refer to this callback.
     *
     * @return the name of the callback.
     */
    String name() default "";

    /**
     * An absolute URL expression that defines the destination which will be invoked
     * as the callback endpoint (e.g., a webhook URL).
     *
     * @return the callback URL expression.
     */
    String callbackUrlExpression() default "";

    /**
     * An array of {@link Operation} definitions that describe the operations to be
     * invoked asynchronously at the callback URL.
     *
     * @return the array of callback operations.
     */
    Operation[] operation() default {};

    /**
     * A reference to a predefined callback definition from OpenAPI components.
     *
     * @return the reference identifier.
     */
    String ref() default "";

    /**
     * Optional array of {@link Extension} annotations for vendor-specific or custom properties.
     *
     * @return the array of extensions.
     */
    Extension[] extensions() default {};
}