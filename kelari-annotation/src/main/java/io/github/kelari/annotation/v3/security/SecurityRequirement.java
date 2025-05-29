package io.github.kelari.annotation.v3.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Specifies a security requirement for a given operation or type.
 *
 * <p>This annotation is used to define security requirements for API operations. It associates
 * the operation with a security scheme and optionally specifies the required scopes. It is commonly
 * used to define OAuth2 or OpenID Connect security schemes for APIs.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#security-requirement-object">OpenAPI Specification v3.1.0 – Security Requirement Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @SecurityRequirement(
 *     name = "OAuth2",
 *     scopes = {"read", "write"}
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#security-requirement-object">OpenAPI 3.1.0 – Security Requirement Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@Retention(RUNTIME)
@Target(value= {METHOD,TYPE,ANNOTATION_TYPE})
@Repeatable(value = SecurityRequirements.class)
@Inherited
public @interface SecurityRequirement {
    /**
     * 	This name must correspond to a declared SecurityRequirement.
     * */
    String name() default "";
    /**
     * If the security scheme is of type "oauth2" or "openIdConnect", then the value is a list of scope names required for the execution. For other security scheme types, the array must be empty.
     *@return String array of scopes.
     * */
    String[] scopes() default {};
}