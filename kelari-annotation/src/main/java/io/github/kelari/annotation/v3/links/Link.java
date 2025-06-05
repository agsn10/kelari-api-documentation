package io.github.kelari.annotation.v3.links;

import io.github.kelari.annotation.v3.extensions.Extension;
import io.github.kelari.annotation.v3.servers.Server;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a possible design-time link for a response.
 * <p>
 * The presence of a link indicates that the developer can invoke the operation
 * specified in the link by using the response values.
 * </p>
 *
 * <p>
 * This annotation models the OpenAPI 3.0.1 {@code Link Object} which defines a possible
 * relationship to another operation. It can be used within annotations for response definitions
 * to define transitions or relationships between operations.
 * </p>
 *
 * <p><strong>Specification Reference:</strong><br>
 * <a href="https://spec.openapis.org/oas/v3.0.1#link-object">OpenAPI 3.0.1 - Link Object</a>
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @ApiResponse(
 *     responseCode = "201",
 *     description = "User created",
 *     links = {
 *         @Link(
 *             name = "getUserById",
 *             operationId = "getUser",
 *             parameters = {
 *                 @LinkParameter(name = "userId", expression = "$response.body#/id")
 *             }
 *         )
 *     }
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see LinkParameter
 * @see Server
 * @see Extension
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value = ANNOTATION_TYPE)
@Retention(value = RUNTIME)
@Inherited
public @interface Link {

    /**
     * A description of the link.
     * CommonMark syntax may be used for rich text representation.
     *
     * @return The link's description.
     */
    String description() default "";

    /**
     * An optional array of specification extensions.
     *
     * @return The list of extensions.
     */
    Extension[] extensions() default {};

    /**
     * The name of the link.
     *
     * @return The link's name.
     */
    String name() default "";

    /**
     * The name of an existing, resolvable OAS operation, as defined with a unique operationId.
     * This property is mutually exclusive with {@code operationRef}.
     *
     * @return An operation ID.
     */
    String operationId() default "";

    /**
     * A relative or absolute reference to an OAS operation.
     * This property is mutually exclusive with {@code operationId}, and is ignored if {@code operationId} is specified.
     *
     * @return An operation reference.
     */
    String operationRef() default "";

    /**
     * An array of parameters to pass to the operation specified with {@code operationId} or {@code operationRef}.
     *
     * @return The parameters to be used in the linked operation.
     */
    LinkParameter[] parameters();

    /**
     * A reference to a predefined link defined in the components section.
     *
     * @return The reference identifier.
     */
    String ref() default "";

    /**
     * A literal value or {expression} to use as a request body when calling the target operation.
     *
     * @return The request body to use in the linked operation.
     */
    String requestBody() default "";

    /**
     * An optional alternative server to service this operation.
     *
     * @return The server to be used for the linked operation.
     */
    Server server() default @Server;
}
