package io.github.kelari.annotation.v3.other;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated element (method, type, field, or annotation) should be hidden from generated documentation or processing tools.
 * <p>
 * This is commonly used in OpenAPI generation tools to exclude specific API endpoints, models, or properties from being exposed in the final specification.
 * </p>
 *
 * <p><strong>Specification Reference:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0">OpenAPI Specification v3.1.0</a> — While not an official property, many tools such as Swagger and Springdoc support `@Hidden` for excluding items from generated documentation.</li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Hidden
 * public class InternalModel {
 *     // This class will not be exposed in the OpenAPI documentation
 * }
 * }</pre>
 *
 * <p><strong>Targets:</strong></p>
 * <ul>
 *     <li>METHOD – hides specific operations</li>
 *     <li>TYPE – hides entire classes or interfaces</li>
 *     <li>FIELD – hides specific fields from schema</li>
 *     <li>ANNOTATION_TYPE – allows meta-annotation to propagate hiding behavior</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Operation
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={METHOD, TYPE, FIELD, ANNOTATION_TYPE})
@Retention(value=RUNTIME)
public @interface Hidden {
}
