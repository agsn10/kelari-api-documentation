package io.github.kelari.annotation.v3.security;

import io.github.kelari.annotation.v3.extensions.Extension;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a single OAuth2 flow configuration within a security scheme.
 *
 * <p>This annotation defines details specific to an OAuth 2.0 flow, such as authorization, token, and refresh URLs,
 * as well as supported scopes and optional vendor-specific extensions.</p>
 *
 * <p>It is intended to be used as part of an OAuth2 security scheme definition, typically within an {@code @OAuthFlows} container.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#oauth-flow-object">OpenAPI Specification v3.1.0 – OAuth Flow Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @SecurityScheme(
 *     name = "oauth2Scheme",
 *     type = SecuritySchemeType.OAUTH2,
 *     flows = @OAuthFlows(
 *         authorizationCode = @OAuthFlow(
 *             authorizationUrl = "https://example.com/oauth/authorize",
 *             tokenUrl = "https://example.com/oauth/token",
 *             scopes = {
 *                 @OAuthScope(name = "read", description = "Allows read access"),
 *                 @OAuthScope(name = "write", description = "Allows write access")
 *             }
 *         )
 *     )
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see OAuthFlows
 * @see OAuthScope
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#oauth-flow-object">OpenAPI 3.1.0 – OAuth Flow Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={})
@Retention(value=RUNTIME)
@Inherited
public @interface OAuthFlow {

    /**
     * The authorization URL to be used for this flow. This must be in the form of a URL. Applies to oauth2 ("implicit", "authorizationCode") type.
     * @return The authorization url.
     * */
    String authorizationUrl() default "";
    /**
     * The list of optional extensions.
     * @return An optional array of extensions.
     * */
    Extension[] extensions() default {};
    /**
     * The URL to be used for obtaining refresh tokens. This must be in the form of a URL. Applies to oauth2 type.
     * @return The refresh url.
     * */
    String refreshUrl() default "";
    /**
     * The available scopes for the OAuth2 security scheme. Applies to oauth2 type.
     * @return Array of scopes.
     * */
    OAuthScope[] scopes() default {};
    /**
     * The token URL to be used for this flow. This must be in the form of a URL. Applies to oauth2 ("password", "clientCredentials", "authorizationCode") type.
     * @return The token url.
     * */
    String tokenUrl() default "";
}