package io.github.kelari.annotation.v3.security;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Container annotation for multiple {@link SecurityRequirement} annotations.
 *
 * <p>This annotation is used to group multiple security requirements together, allowing
 * them to be applied to methods, types, or annotation types. It is often used in OpenAPI
 * specifications to define multiple security schemes or scopes that are required for an operation.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#security-requirement-object">OpenAPI Specification v3.1.0 – Security Requirement Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @SecurityRequirements({
 *     @SecurityRequirement(name = "OAuth2", scopes = {"read", "write"}),
 *     @SecurityRequirement(name = "ApiKey")
 * })
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#security-requirement-object">OpenAPI 3.1.0 – Security Requirement Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@Retention(RUNTIME)
@Target(value={METHOD,TYPE,ANNOTATION_TYPE})
@Inherited
public @interface SecurityRequirements {
    /**
     * An array of SecurityRequirement annotations
     * */
    SecurityRequirement[] value();
}
