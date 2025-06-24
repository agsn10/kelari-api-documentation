package io.github.kelari.core.validator.impl;

import io.github.kelari.core.validator.SpecValidator;
import io.github.kelari.core.validator.ValidationResult;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.parameters.RequestBody;

import java.util.Map;
import java.util.Objects;

/**
 * Validates the request body defined in the OpenAPI specification.
 * <p>
 * This validator ensures that each request body has a description and content properly defined.
 * </p>
 *
 * <p><strong>Validation Rules:</strong></p>
 * <ul>
 *     <li><b>REQUEST-BODY-001:</b> Request body description is missing or empty (error).</li>
 *     <li><b>REQUEST-BODY-002:</b> Request body content is missing or not properly defined (error).</li>
 *     <li><b>REQUEST-BODY-003:</b> Request body requirement flag is missing (warning).</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class RequestBodyValidator implements SpecValidator {

    @Override
    public ValidationResult validate(OpenAPI spec) {
        ValidationResult result = new ValidationResult();
        if (Objects.isNull(spec)) {
            result.addError("REQUEST-BODY-000", "OpenAPI specification is null", "spec");
            return result;
        }
        // Assume that the request bodies are part of the components section
        Map<String, RequestBody> requestBodies = spec.getComponents().getRequestBodies();
        // If no request bodies are defined, issue a warning
        if (requestBodies == null || requestBodies.isEmpty())
            result.addWarning("REQUEST-BODY-001", "No request bodies defined in the OpenAPI specification", "requestBodies");
        // Validate each request body
        for (Map.Entry<String, RequestBody> entry : requestBodies.entrySet()) {
            String bodyName = entry.getKey();
            RequestBody requestBody = entry.getValue();
            // Check if description is missing or empty
            if (requestBody.getDescription() == null || requestBody.getDescription().isBlank())
                result.addError("REQUEST-BODY-002", "Request body description is missing or empty", "requestBodies[" + bodyName + "]");
            // Check if content is missing or not properly defined
            if (requestBody.getContent() == null)
                result.addError("REQUEST-BODY-003", "Request body content is missing or not properly defined", "requestBodies[" + bodyName + "]");
            // If the required field is not set, issue a warning
            if (requestBody.getRequired() == null)
                result.addWarning("REQUEST-BODY-004", "Request body requirement flag is missing", "requestBodies[" + bodyName + "]");
        }
        return result;
    }
}