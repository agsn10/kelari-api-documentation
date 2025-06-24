package io.github.kelari.core.validator;

import io.github.kelari.model.v3.OpenAPI;

public interface SpecValidator {
    /**
     * Validates the given OpenAPI specification.
     *
     * @param spec the OpenAPI specification to validate.
     * @return a {@link ValidationResult} containing any validation errors found.
     */
    ValidationResult validate(OpenAPI spec);
}
