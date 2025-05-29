package io.github.kelari.annotation.v3.parameters;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Container annotation for repeatable {@link Parameter} annotations.
 *
 * <p>Allows declaring multiple {@link Parameter} annotations on the same method
 * or annotation. This is especially useful when documenting multiple input parameters
 * for an API operation.
 *
 * <p>This annotation corresponds to the OpenAPI Specification's "parameters" field
 * under an operation object.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @Parameters({
 *     @Parameter(name = "id", in = ParameterIn.PATH, required = true, description = "Entity ID"),
 *     @Parameter(name = "filter", in = ParameterIn.QUERY, description = "Optional filter")
 * })
 * }
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @see Parameter
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value = {METHOD, ANNOTATION_TYPE})
@Retention(value = RUNTIME)
@Inherited
public @interface Parameters {

    /**
     * An array of {@link Parameter} objects that define input values for the operation.
     *
     * @return The list of parameters to apply to the method or annotation.
     */
    Parameter[] value() default {};
}