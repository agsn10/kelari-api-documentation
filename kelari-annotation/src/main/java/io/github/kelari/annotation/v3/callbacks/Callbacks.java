package io.github.kelari.annotation.v3.callbacks;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Container annotation for grouping multiple {@link Callback} annotations.
 *
 * <p>
 * This annotation enables associating multiple asynchronous, out-of-band callbacks
 * (such as webhooks) with a single method or meta-annotation. It's typically used
 * in OpenAPI/Swagger-style specifications.
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Callbacks({
 *     @Callback(name = "onData", expression = "http://example.com/callbacks/data"),
 *     @Callback(name = "onStatus", expression = "http://example.com/callbacks/status")
 * })
 * public void process() {
 *     // implementation
 * }
 * }</pre>
 *
 * <p>
 * This annotation is also used implicitly when {@link Callback} is applied multiple times
 * to the same element via {@code @Repeatable(Callbacks.class)}.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] - Initial implementation.
 * @see Callback
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#callbackObject">Callback (OpenAPI Specification)</a>
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target({METHOD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Inherited
public @interface Callbacks {
    /**
     * Array of {@link Callback} annotations that describe the callback definitions
     * associated with the annotated method or annotation.
     *
     * @return the list of callback annotations
     */
    Callback[] value() default {};
}
