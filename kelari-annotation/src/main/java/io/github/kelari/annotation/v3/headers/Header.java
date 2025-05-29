package io.github.kelari.annotation.v3.headers;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Represents a custom HTTP header used in OpenAPI specifications. This annotation is typically used
 * to define headers that are part of request or response in the OpenAPI documentation.
 *
 * <p>The {@code @Header} annotation allows specifying the name, description, deprecation status,
 * and whether the header is required, as well as the schema definition for the header.</p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @ApiResponse(
 *     responseCode = "200",
 *     description = "Success",
 *     headers = {
 *         @Header(
 *             name = "X-Rate-Limit",
 *             description = "The number of allowed requests in a given time frame",
 *             required = true,
 *             deprecated = false
 *         )
 *     }
 * )}
 *</pre>
 *
 * <p>For more information on headers in OpenAPI, refer to the OpenAPI specification:</p>
 * <p><a href="https://spec.openapis.org/oas/v3.0.1#headers">OpenAPI Specification - Headers</a></p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 * @see Schema
 */
@Target(value={})
@Retention(value=RUNTIME)
@Inherited
public @interface Header {

    /**
     * The name of the header. This name is used as the key to store this header in a map.
     *
     * @return The name of the header.
     */
    String name();

    /**
     * Specifies that a header is deprecated and should be transitioned out of usage.
     *
     * @return Whether or not the header is deprecated.
     */
    boolean deprecated() default false;

    /**
     * A description of the purpose of the header, providing more context on its usage.
     *
     * @return The description of the header.
     */
    String description() default "";

    /**
     * A reference to a header defined in the OpenAPI components section.
     *
     * @return The reference to the header.
     */
    String ref() default "";

    /**
     * Specifies whether this header is mandatory for the request or response.
     *
     * @return Whether or not the header is required.
     */
    boolean required() default false;

    /**
     * The schema definition of the header.
     *
     * @return The schema of the header.
     */
    io.swagger.v3.oas.annotations.media.Schema schema() default @Schema;
}
