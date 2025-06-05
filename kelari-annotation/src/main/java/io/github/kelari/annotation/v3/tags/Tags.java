package io.github.kelari.annotation.v3.tags;

import io.github.kelari.annotation.v3.operations.Operation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Container annotation for defining multiple {@link Tag} annotations on a single element.
 * <p>
 * This annotation allows developers to apply more than one {@link Tag} to a method, type, or another annotation.
 * It serves como container da anotação {@link Tag}, que pode ser usada para organizar operações da API por grupos lógicos.
 * </p>
 *
 * <p>
 * Esta anotação modela o uso do objeto {@code Tag Object} da especificação OpenAPI 3.0.1, permitindo a associação
 * de metadados descritivos às operações.
 * </p>
 *
 * <p><strong>Specification Reference:</strong><br>
 * <a href="https://spec.openapis.org/oas/v3.0.1#tag-object">OpenAPI 3.0.1 - Tag Object</a>
 * </p>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Tags({
 *     @Tag(name = "users", description = "Operations about users"),
 *     @Tag(name = "admin", description = "Administrative operations")
 * })
 * }</pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Tag
 * @see Operation
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={METHOD,TYPE,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Inherited
public @interface Tags {
    /**
     * An array of Tag annotation objects which hold metadata for the API.
     * */
    Tag[] value();
}