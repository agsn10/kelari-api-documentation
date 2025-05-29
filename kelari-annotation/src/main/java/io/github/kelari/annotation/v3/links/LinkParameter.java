package io.github.kelari.annotation.v3.links;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a parameter to be passed to a linked OpenAPI operation.
 *
 * <p>
 * This annotation is used within the {@link Link} annotation to define named parameters
 * and their values (literal or expressions) that should be passed when invoking a linked operation.
 * </p>
 *
 * <p>
 * It models the <strong>Link Parameter Object</strong> as defined in the OpenAPI 3.0.1 specification.
 * </p>
 *
 * <p><strong>Specification Reference:</strong><br>
 * <a href="https://spec.openapis.org/oas/v3.0.1#link-object">OpenAPI 3.0.1 - Link Object (parameters)</a>
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Link(
 *     name = "getUserById",
 *     operationId = "getUser",
 *     parameters = {
 *         @LinkParameter(name = "userId", expression = "$response.body#/id")
 *     }
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Link
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={})
@Retention(value=RUNTIME)
@Inherited
public @interface LinkParameter {

    /**
     * A constant or an expression to be evaluated and passed to the linked operation.
     * The expression can use runtime variables such as {@code $method}, {@code $url}, {@code $request.body#/id}, etc.
     *
     * @return The value or expression of the parameter.
     */
    String expression() default "";

    /**
     * The name of the parameter to pass to the linked operation.
     *
     * @return The name of the link parameter.
     */
    String name() default "";
}
