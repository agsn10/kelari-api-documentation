package io.github.kelari.core.validator;

import io.github.kelari.model.v3.OpenAPI;

/**
 * This class provides methods to validate different aspects of HTTP requests, responses,
 * parameters, content types, headers, and the OpenAPI specification itself, based on the OpenAPI standard.
 * It ensures that the requests and responses conform to the defined OpenAPI specifications.
 *
 * <p>Methods include validation for:</p>
 * <ul>
 *     <li>HTTP requests and responses</li>
 *     <li>Paths and HTTP methods</li>
 *     <li>Schemas and parameters</li>
 *     <li>Content types and headers</li>
 *     <li>OpenAPI specification formatting</li>
 * </ul>
 *
 * <p>Each method returns a {@link ValidationResult} containing validation status and any errors encountered.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public class OpenApiValidator {

    private OpenApiSpecValidator openApiSpecValidator;

    public OpenApiValidator() {
        this.openApiSpecValidator = new OpenApiSpecValidator();
    }

    /**
     * Valida a especificação OpenAPI utilizando todos os validadores.
     *
     * @param openAPISpec a especificação OpenAPI a ser validada.
     * @return um resultado de validação contendo mensagens de erro (se houver).
     */
    public ValidationResult validate(OpenAPI openAPISpec) {
        // Chama o OpenApiSpecValidator para validar a especificação
        return openApiSpecValidator.validateSpec(openAPISpec);
    }
}