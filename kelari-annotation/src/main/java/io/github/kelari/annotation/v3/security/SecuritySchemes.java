package io.github.kelari.annotation.v3.security;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Container annotation for multiple {@link SecurityScheme} annotations.
 *
 * <p>This annotation is used to group multiple security scheme definitions together,
 * allowing them to be applied at the class or annotation level. It is commonly used
 * in OpenAPI specifications to define various authentication mechanisms supported by the API.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#security-scheme-object">OpenAPI Specification v3.1.0 – Security Scheme Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @SecuritySchemes({
 *     @SecurityScheme(
 *         name = "basicAuth",
 *         type = SecuritySchemeType.HTTP,
 *         scheme = "basic"
 *     ),
 *     @SecurityScheme(
 *         name = "apiKeyAuth",
 *         type = SecuritySchemeType.APIKEY,
 *         in = SecuritySchemeIn.HEADER,
 *         paramName = "X-API-KEY"
 *     )
 * })
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see SecurityScheme
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#security-scheme-object">OpenAPI 3.1.0 – Security Scheme Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={TYPE,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Inherited
public @interface SecuritySchemes {

    /**
     * An array of SecurityScheme annotations
     * @return The array of the SecurityScheme.
     * */
    SecurityScheme[] value() default {};
}