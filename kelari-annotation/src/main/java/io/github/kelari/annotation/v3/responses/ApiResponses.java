package io.github.kelari.annotation.v3.responses;

import io.github.kelari.annotation.v3.extensions.Extension;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Container annotation for multiple {@link ApiResponse} annotations.
 *
 * <p>Esta anotação é usada para definir múltiplas respostas possíveis para uma operação,
 * geralmente aplicada a métodos ou tipos em controladores REST.</p>
 *
 * <p>Ela complementa a anotação {@link ApiResponse}, que é marcada como {@code @Repeatable(ApiResponses.class)}.</p>
 *
 * <p><strong>Referência da Especificação:</strong></p>
 * <ul>
 *     <li><a href="https://spec.openapis.org/oas/v3.1.0#responses-object">OpenAPI Specification v3.1.0 – Responses Object</a></li>
 * </ul>
 *
 * <p>Exemplo de uso:</p>
 * <pre>
 * {@code
 * @ApiResponses({
 *     @ApiResponse(responseCode = "200", description = "Requisição bem-sucedida"),
 *     @ApiResponse(responseCode = "400", description = "Requisição inválida"),
 *     @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
 * })
 * }
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
@Target(value={METHOD,TYPE,ANNOTATION_TYPE})
@Retention(value=RUNTIME)
@Inherited
public @interface ApiResponses {

    /**
     * The list of optional extensions
     * @return An optional array of extensions.
     * */
    Extension[] extensions() default {};
    /**
     * An array of ApiResponse annotations.
     * @return The array of the ApiResponse.
     * */
    ApiResponse[] value() default {};
}
