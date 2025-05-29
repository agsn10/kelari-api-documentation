package io.github.kelari.annotation.v3.security;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Defines an OAuth2 scope that describes the level of access granted by the authorization.
 *
 * <p>OAuth2 scopes are used in the context of OAuth2 authentication to define permissions or roles
 * for access to protected resources. Each scope is associated with a description and a name.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#oauth-scope-object">OpenAPI Specification v3.1.0 – OAuth Scope Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @OAuthScope(
 *     name = "read",
 *     description = "Allows read access to resources"
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#oauth-scope-object">OpenAPI 3.1.0 – OAuth Scope Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={})
@Retention(value=RUNTIME)
@Inherited
public @interface OAuthScope {

    /**
     * Short description of the scope.
     * @return String description.
     * */
    String description() default "";
    /**
     * Name of the scope.
     * @return String name.
     * */
    String name() default "";
}