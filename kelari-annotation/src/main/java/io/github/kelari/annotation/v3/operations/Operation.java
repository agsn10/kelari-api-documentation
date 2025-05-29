package io.github.kelari.annotation.v3.operations;

import io.github.kelari.annotation.v3.extensions.Extension;
import io.github.kelari.annotation.v3.parameters.Parameter;
import io.github.kelari.annotation.v3.parameters.RequestBody;
import io.github.kelari.annotation.v3.responses.ApiResponse;
import io.github.kelari.annotation.v3.security.SecurityRequirement;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents an OpenAPI operation that can be invoked by a consumer.
 * <p>
 * An operation is a single API endpoint on a specific path and method that performs a defined action.
 * It contains details such as parameters, request bodies, responses, security requirements, etc.
 * </p>
 *
 * <p>
 * This annotation models the OpenAPI 3.0.1 {@code Operation Object} which describes a single API operation
 * on a path. It is used to provide metadata for generating documentation or integrating with tools.
 * </p>
 *
 * <p><strong>Specification Reference:</strong><br>
 * <a href="https://spec.openapis.org/oas/v3.0.1#operation-object">OpenAPI 3.0.1 - Operation Object</a>
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Operation(
 *     operationId = "createUser",
 *     summary = "Creates a new user in the system",
 *     description = "This operation creates a user and returns the newly created user object",
 *     method = "POST",
 *     parameters = {
 *         @Parameter(name = "X-Request-ID", description = "Request identifier", in = "header")
 *     },
 *     requestBody = @RequestBody(description = "User object to be created"),
 *     responses = {
 *         @ApiResponse(responseCode = "201", description = "User created successfully"),
 *         @ApiResponse(responseCode = "400", description = "Invalid input")
 *     },
 *     tags = {"User"},
 *     deprecated = false
 * )
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Parameter
 * @see ApiResponse
 * @see RequestBody
 * @see Server
 * @see SecurityRequirement
 * @see Extension
 * @see ExternalDocumentation
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={METHOD,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Inherited
public @interface Operation {

    /**
     * Allows an operation to be marked as deprecated. Alternatively use the @Deprecated annotation.
     * @return Whether or not this operation is deprecated.
     * */
    boolean deprecated() default false;
    /**
     * A verbose description of the operation.
     * @return A description of this operation.
     * */
    String description() default "";
    /**
     * The list of optional extensions.
     * @return An optional array of extensions.
     * */
    Extension[] extensions() default {};
    /**
     * Additional external documentation for this operation.
     * @return Additional documentation about this operation.
     * */
    ExternalDocumentation externalDocs() default @ExternalDocumentation;
    /**
     * Allows this operation to be marked as hidden.
     * @return Whether or not this operation is hidde.
     * */
    boolean hidden() default false;
    /**
     * Ignores JsonView annotations while resolving operations and types.
     * @return Whether or not to ignore JsonView annotations.
     * */
    boolean ignoreJsonView() default false;
    /**
     * The HTTP method for this operation.
     * @return The HTTP method of this operation.
     * */
    String method() default "";
    /**
     * The operationId is used by third-party tools to uniquely identify this operation.
     * @return The ID of this operation.
     * */
    String operationId() default "";
    /**
     * An optional array of parameters which will be added to any automatically detected parameters in the method itself.
     * @return The list of parameters for this operation.
     * */
    Parameter[] parameters() default {};
    /**
     * Request body associated to the operation.
     * @return A request body.
     * */
    RequestBody requestBody() default @RequestBody;
    /**
     * The list of possible responses as they are returned from executing this operation.
     * @return The list of responses for this operation.
     * */
    ApiResponse[] responses() default {};
    /**
     * A declaration of which security mechanisms can be used for this operation.
     * @return The array of security requirements for this Operation.
     * */
    SecurityRequirement[] security() default {};
    /**
     * An alternative server array to service this operation.
     * @return The list of servers hosting this operation.
     * */
    Server[] servers() default {};
    /**
     * Provides a brief description of this operation. Should be 120 characters or less for proper visibility in console.
     * @return A summary of this operation.
     * */
    String summary() default "";
    /**
     * Tags can be used for logical grouping of operations by resources or any other qualifier.
     * @return The list of tags associated with this operation.
     * */
    String[] tags() default {};
}
