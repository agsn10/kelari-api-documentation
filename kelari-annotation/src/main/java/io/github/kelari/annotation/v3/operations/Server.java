package io.github.kelari.annotation.v3.operations;

import io.github.kelari.annotation.v3.ServerVariable;
import io.github.kelari.annotation.v3.extensions.Extension;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a server object used to specify an API server.
 * <p>
 * A server object provides connectivity information to a target server. It includes the target URL,
 * optional description, variable substitutions, and custom extensions.
 * </p>
 *
 * <p>
 * This annotation models the OpenAPI 3.0.1 {@code Server Object}, which specifies a base URL for an API operation
 * or for the entire API. It can also define variables within the URL to be substituted at runtime.
 * </p>
 *
 * <p><strong>Specification Reference:</strong><br>
 * <a href="https://spec.openapis.org/oas/v3.0.1#server-object">OpenAPI 3.0.1 - Server Object</a>
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Server(
 *     url = "https://api.example.com/v1",
 *     description = "Production server",
 *     variables = {
 *         @ServerVariable(name = "port", defaultValue = "443", description = "Port number")
 *     }
 * )
 * }</pre>
 *
 * <p>This annotation is repeatable using {@link Servers}.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see ServerVariable
 * @see Servers
 * @see Extension
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={METHOD,TYPE,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Repeatable(value=Servers.class)
@Inherited
public @interface Server {
    /**
     * An optional string describing the host designated by the URL. CommonMark syntax MAY be used for rich text representation.
     * @return String description.
     * */
    String description() default "";
    /**
     * The list of optional extensions.
     * @return An optional array of extensions.
     * */
    Extension[] extensions() default {};
    /**
     * Required. A URL to the target host. This URL supports Server Variables and may be relative, to indicate that the host location is relative to the location where the OpenAPI definition is being served. Variable substitutions will be made when a variable is named in {brackets}.
     * @return String url.
     * */
    String 	url() default "";
    /**
     * An array of variables used for substitution in the server's URL template.
     * @return Array of ServerVariables.
     * */
    ServerVariable[]  variables() default {};
}
