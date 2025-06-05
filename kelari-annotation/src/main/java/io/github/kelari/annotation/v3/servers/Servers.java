package io.github.kelari.annotation.v3.servers;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Container annotation for defining multiple {@link Server} annotations on a single element.
 * <p>
 * This annotation is used when more than one server object is applicable to a method, type, or annotation.
 * It serves as the container for the repeatable {@link Server} annotation.
 * </p>
 *
 * <p>
 * This annotation models the OpenAPI 3.0.1 {@code Server Object} applied in plural form, allowing developers
 * to declare multiple server alternatives for the same API context.
 * </p>
 *
 * <p><strong>Specification Reference:</strong><br>
 * <a href="https://spec.openapis.org/oas/v3.0.1#server-object">OpenAPI 3.0.1 - Server Object</a>
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Servers({
 *     @Server(
 *         url = "https://api.example.com/v1",
 *         description = "Production server"
 *     ),
 *     @Server(
 *         url = "https://staging-api.example.com/v1",
 *         description = "Staging server"
 *     )
 * })
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Server
 * @see Extension
 * @see ServerVariable
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={METHOD,TYPE,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Inherited
public @interface Servers {

    /**
     * An array of Server Objects which is used to provide connectivity information to a target server.
     * @return The servers used for this API.
     * */
    Server[] value();
}