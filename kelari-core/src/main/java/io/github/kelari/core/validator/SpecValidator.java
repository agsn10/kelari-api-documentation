package io.github.kelari.core.validator;

import io.github.kelari.model.v3.OpenAPI;

public interface SpecValidator {
    ValidationResult validate(OpenAPI spec);
}
