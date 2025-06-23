package io.github.kelari.core.validator.impl;

import io.github.kelari.core.validator.SpecValidator;
import io.github.kelari.core.validator.ValidationResult;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.parameters.Parameter;
import io.github.kelari.model.v3.paths.PathItem;

import java.util.List;
import java.util.Map;

/**
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public class OperationValidator implements SpecValidator {

    @Override
    public ValidationResult validate(OpenAPI spec) {
        ValidationResult result = new ValidationResult();
        if (spec == null) {
            result.addError("OP-001", "OpenAPI specification is null", "spec");
            return result;
        }
        if (spec.getPaths() == null || spec.getPaths().isEmpty()) {
            result.addError("OP-002", "No paths defined in the OpenAPI specification", "paths");
            return result;
        }
        for (Map.Entry<String, PathItem> entry : spec.getPaths().entrySet()) {
            String path = entry.getKey();
            PathItem pathItem = entry.getValue();
            pathItem.readOperationsMap().forEach((method, operation) -> {
                String context = "paths[" + path + "]." + method.name().toLowerCase();
                // Validate operationId
                if (operation.getOperationId() == null || operation.getOperationId().isBlank())
                    result.addError("OP-003", "Missing or empty operationId", context + ".operationId");
                // Validate summary (optional but recommended)
                if (operation.getSummary() == null || operation.getSummary().isBlank())
                    result.addWarning("OP-004", "Missing or empty summary (recommended for documentation)", context + ".summary");
                // Validate tags
                List<String> tags = operation.getTags();
                if (tags == null || tags.isEmpty())
                    result.addWarning("OP-005", "Operation should define at least one tag for grouping", context + ".tags");
                // Validate responses
                if (operation.getResponses() == null || operation.getResponses().isEmpty())
                    result.addError("OP-006", "Operation must define at least one response", context + ".responses");
                // Validate parameters
                List<Parameter> parameters = operation.getParameters();
                if (parameters != null) {
                    for (int i = 0; i < parameters.size(); i++) {
                        Parameter param = parameters.get(i);
                        String paramContext = context + ".parameters[" + i + "]";
                        if (param.getName() == null || param.getName().isBlank())
                            result.addError("OP-007", "Parameter is missing a name", paramContext + ".name");
                        if (param.getIn() == null || param.getIn().isBlank())
                            result.addError("OP-008", "Parameter is missing 'in' field (path, query, header, etc)", paramContext + ".in");
                    }
                }
                // Validate requestBody (optional, but should be defined for POST/PUT)
                if ((method.name().equals("POST") || method.name().equals("PUT")) && operation.getRequestBody() == null)
                    result.addWarning("OP-009", "POST/PUT operations should define a requestBody", context + ".requestBody");
            });
        }
        return result;
    }
}
