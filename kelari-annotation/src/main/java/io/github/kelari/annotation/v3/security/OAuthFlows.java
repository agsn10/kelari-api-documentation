package io.github.kelari.annotation.v3.security;

import io.github.kelari.annotation.v3.extensions.Extension;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Holds configuration information for supported OAuth2 authorization flows.
 *
 * <p>This annotation groups together different OAuth 2.0 flow types: {@code implicit}, {@code password},
 * {@code clientCredentials}, and {@code authorizationCode}. It is used within an OAuth2 security scheme to
 * declare available authentication mechanisms.</p>
 *
 * <p>Each flow can define its own {@link OAuthFlow} configuration, including URLs and available scopes.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#oauth-flows-object">OpenAPI Specification v3.1.0 – OAuth Flows Object</a></li>
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
 * @see OAuthFlow
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#oauth-flows-object">OpenAPI 3.1.0 – OAuth Flows Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={})
@Retention(value=RUNTIME)
@Inherited
public @interface OAuthFlows {

    /**
     * Configuration for the OAuth Authorization Code flow.
     * @return OAuthFloe authorizationCode.
     * */
    OAuthFlow authorizationCode() default @OAuthFlow;
    /**
     * Configuration for the OAuth Client Credentials flow.
     * @return OAuthFlow clientCredentials.
     * */
    OAuthFlow clientCredentials() default @OAuthFlow;
    /**
     * The list of optional extensions.
     * @return An optional array of extensions.
     * */
    Extension[] extensions() default {};
    /**
     * Configuration for the OAuth Implicit flow.
     * @return OAuthFlow implicit.
     * */
    OAuthFlow implicit() default @OAuthFlow;
    /**
     * Configuration for the OAuth Resource Owner Password flow.
     * @return OAuthFlow password.
     * */
    OAuthFlow password() default @OAuthFlow;
}