package io.github.kelari.annotation.v3.media;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents the OpenAPI Schema Object, used to describe the structure and details
 * of request and response bodies or model properties in an API.
 *
 * <p>
 * This annotation is processed by the Kelari implementation to generate API documentation in compliance with
 * the OpenAPI specification.
 * </p>
 *
 * <p>
 * This annotation corresponds to the <strong>Example Object</strong> in the
 * <a href="https://spec.openapis.org/oas/v3.0.1#example-object">OpenAPI Specification 3.0.1</a>.
 * </p>
 *
 * <p><strong>Example:</strong></p>
 * <pre>{@code
 * public class User {
 *
 *     @Schema(
 *         name = "id",
 *         description = "Unique identifier of the user",
 *         example = "123",
 *         accessMode = Schema.AccessMode.READ_ONLY
 *     )
 *     private Long id;
 *
 *     @Schema(
 *         description = "User's full name",
 *         example = "Antonio Neto",
 *         required = true
 *     )
 *     private String name;
 * }
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @version 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Schema {

    /**
     * The name of the schema or property.
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(name = "userId")}</pre>
     *
     * @return the custom name.
     */
    String name() default "";

    /**
     * A brief description of the property.
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(description = "User's full name")}</pre>
     *
     * @return a short description.
     */
    String description() default "";

    /**
     * The default value for the property.
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(defaultValue = "Brasil")}</pre>
     *
     * @return the default value.
     */
    String defaultValue() default "";

    /**
     * An example of the property value.
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(example = "john.doe@example.com")}</pre>
     *
     * @return the example value.
     */
    String example() default "";

    /**
     * Whether the property is required.
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(required = true)}</pre>
     *
     * @return true if the property is mandatory.
     */
    boolean required() default false;

    /**
     * A pattern the string must match.
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(pattern = "^[A-Z]{3}-\\d{4}$")}</pre>
     *
     * @return regex pattern string.
     */
    String pattern() default "";

    /**
     * Defines how the property is accessed in the model.
     *
     * READ_ONLY: Visible in responses only.
     * WRITE_ONLY: Accepted in requests only.
     * READ_WRITE: Both request and response.
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(accessMode = Schema.AccessMode.READ_ONLY)}</pre>
     *
     * @return access mode.
     */
    AccessMode accessMode() default AccessMode.AUTO;

    /**
     * The minimum allowed value (for numeric types).
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(minimum = "0")}</pre>
     *
     * @return the minimum as string.
     */
    String minimum() default "";

    /**
     * The maximum allowed value (for numeric types).
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(maximum = "100")}</pre>
     *
     * @return the maximum as string.
     */
    String maximum() default "";

    /**
     * Enumeration of allowed values.
     *
     * <p><strong>Example:</strong></p>
     * <pre>{@code @Schema(allowableValues = {"MALE", "FEMALE", "OTHER"})}</pre>
     *
     * @return an array of allowed values.
     */
    String[] allowableValues() default {};

    /**
     * Enumeration of access modes: READ_ONLY, WRITE_ONLY, READ_WRITE, AUTO.
     */
    enum AccessMode {
        AUTO,
        READ_ONLY,
        WRITE_ONLY,
        READ_WRITE
    }
}