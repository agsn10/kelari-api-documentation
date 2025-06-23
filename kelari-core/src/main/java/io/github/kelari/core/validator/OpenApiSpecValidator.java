package io.github.kelari.core.validator;

import io.github.kelari.core.validator.impl.*;
import io.github.kelari.model.v3.OpenAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregates multiple SpecValidator implementations to validate a complete OpenAPI specification.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public class OpenApiSpecValidator {

    private final List<SpecValidator> validators;

    public OpenApiSpecValidator() {
        this.validators = new ArrayList<>();
        this.validators.add(new PathValidator());
        this.validators.add(new SchemaValidator());
        this.validators.add(new RequestBodyValidator());
        this.validators.add(new ResponseValidator());
        this.validators.add(new OperationValidator());
        this.validators.add(new ServerValidator());
        this.validators.add(new ParameterValidator());
    }

    /**
     * Validates the OpenAPI specification using all registered validators.
     *
     * @param openAPISpec the OpenAPI specification to validate.
     * @return a {@link ValidationResult} containing all errors and warnings found.
     */
    public ValidationResult validateSpec(OpenAPI openAPISpec) {
        ValidationResult finalResult = new ValidationResult();

        for (SpecValidator validator : validators) {
            ValidationResult partialResult = validator.validate(openAPISpec);
            // Copy all errors
            for (ValidationResult.ValidationIssue error : partialResult.getErrors())
                finalResult.addError(error.code(), error.message(), error.context());
            // Copy all warnings
            for (ValidationResult.ValidationIssue warning : partialResult.getWarnings())
                finalResult.addWarning(warning.code(), warning.message(), warning.context());
        }
        return finalResult;
    }
}
