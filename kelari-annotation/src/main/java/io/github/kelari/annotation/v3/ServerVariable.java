package io.github.kelari.annotation.v3;

import io.github.kelari.annotation.v3.extensions.Extension;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a server variable in an OpenAPI specification.
 *
 * <p>This annotation is used to define a variable that can be part of a server URL template. Server variables
 * allow dynamic values to be substituted into the URL when making requests. This is typically used to represent
 * things like version numbers or environment-specific parameters in the server URL.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#server-variable-object">OpenAPI Specification v3.1.0 – Server Variable Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @ServerVariable(
 *     name = "version",
 *     defaultValue = "v1",
 *     allowableValues = {"v1", "v2", "v3"},
 *     description = "API version"
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#server-variable-object">OpenAPI 3.1.0 – Server Variable Object</a>
 * @see Extension
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={})
@Retention(RUNTIME)
@Inherited
public @interface ServerVariable {
    /**
     * Required.
     * */
    String defaultValue();
    /**
     * Required.
     * */
    String name();
    /**
     * An array of allowable values for this variable.
     * */
    String[] allowableValues() default "";
    /**
     * An optional description for the server variable.
     * */
    String description() default "";
    /**
     * The list of optional extensions.
     * */
    Extension[] extensions() default {};
}