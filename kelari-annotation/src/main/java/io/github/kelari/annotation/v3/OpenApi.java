package io.github.kelari.annotation.v3;

import io.github.kelari.annotation.v3.extensions.Extension;
import io.github.kelari.annotation.v3.extensions.Tag;
import io.github.kelari.annotation.v3.operations.Server;
import io.github.kelari.annotation.v3.security.SecurityRequirement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents the OpenAPI definition for an API.
 *
 * <p>This annotation is used to specify the metadata and configurations for an OpenAPI definition. It serves
 * as the main entry point for an OpenAPI specification, containing information such as security schemes,
 * external documentation, servers, and tags.</p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#openapi-object">OpenAPI Specification v3.1.0 – OpenAPI Object</a></li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @OpenApi(
 *     info = @Info(
 *         title = "Sample API",
 *         version = "1.0.0",
 *         description = "This is an example of an OpenAPI definition"
 *     ),
 *     servers = {
 *         @Server(url = "https://api.example.com")
 *     },
 *     security = {
 *         @SecurityRequirement(name = "OAuth2", scopes = {"read", "write"})
 *     },
 *     tags = {
 *         @Tag(name = "User", description = "Operations related to users")
 *     }
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see <a href="https://spec.openapis.org/oas/v3.1.0#openapi-object">OpenAPI 3.1.0 – OpenAPI Object</a>
 * @see Info
 * @see Server
 * @see SecurityRequirement
 * @see Tag
 * @see ExternalDocumentation
 * @copyright 2025 Kelari. All rights reserved.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface OpenApi {

    /**
     * The list of optional extensions.
     * @return An optional array of extensions.
     * */
    Extension[] extensions() default {};
    /**
     * Any additional external documentation for the API.
     * @return The external documentation for this API.
     * */
    ExternalDocumentation externalDocs() default @ExternalDocumentation;
    /**
     * Provides metadata about the API. The metadata MAY be used by tooling as required.
     * @return The metadata about this API.
     * */
    Info info() default @Info;
    /**
     * A declaration of which security mechanisms can be used across the API.
     * @return The array of servers used for this API.
     * */
    SecurityRequirement[] security() default {};
    /**
     * An array of Server Objects, which provide connectivity information to a target server. If the servers property is not provided, or is an empty array, the default value would be a Server Object with a url value of /.
     * @return The servers of this API.
     * */
    Server[] servers() default {};
    /**
     * A list of tags used by the specification with additional metadata. The order of the tags can be used to reflect on their order by the parsing tools.
     * @return The tags used by the specification with any additional metadata.
     * */
    Tag[] tags() default {};
}