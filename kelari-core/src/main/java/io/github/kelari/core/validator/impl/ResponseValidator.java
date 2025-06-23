package io.github.kelari.core.validator.impl;

import io.github.kelari.core.validator.SpecValidator;
import io.github.kelari.core.validator.ValidationResult;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.responses.ApiResponse;

import java.util.Map;
import java.util.Objects;

/**
 * Validates the responses defined in the OpenAPI specification.
 * <p>
 * This validator ensures that each response has a description and that content is properly defined.
 * </p>
 *
 * <p><strong>Validation Rules:</strong></p>
 * <ul>
 *     <li><b>RESPONSE-001:</b> No responses defined at the root of the OpenAPI specification (warning).</li>
 *     <li><b>RESPONSE-002:</b> Response description is missing or empty (error).</li>
 *     <li><b>RESPONSE-003:</b> Response content is missing or not properly defined (error).</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class ResponseValidator implements SpecValidator {

    @Override
    public ValidationResult validate(OpenAPI spec) {
        ValidationResult result = new ValidationResult();
        if (Objects.isNull(spec)) {
            result.addError("RESPONSE-000", "OpenAPI specification is null", "spec");
            return result;
        }
        Map<String, ApiResponse> responses = spec.getComponents().getResponses();
        // Check if no responses are defined
        if (Objects.isNull(responses) || responses.isEmpty()) {
            result.addWarning("RESPONSE-001", "No responses defined in the OpenAPI specification", "responses");
            return result;
        }
        // Validate each response
        for (Map.Entry<String, ApiResponse> entry : responses.entrySet()) {
            String statusCode = entry.getKey();
            ApiResponse apiResponse = entry.getValue();
            // Check if the description is null or empty
            if (apiResponse.getDescription() == null || apiResponse.getDescription().isBlank())
                result.addError("RESPONSE-002", "Response description is missing or empty", "responses[" + statusCode + "]");
            // Check if content is missing or not properly defined
            if (apiResponse.getContent() == null)
                result.addError("RESPONSE-003", "Response content is missing or not properly defined", "responses[" + statusCode + "]");
        }
        return result;
    }
}
