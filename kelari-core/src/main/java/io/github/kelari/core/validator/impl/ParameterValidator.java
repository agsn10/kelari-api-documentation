package io.github.kelari.core.validator.impl;

import io.github.kelari.core.validator.SpecValidator;
import io.github.kelari.core.validator.ValidationResult;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.operations.Operation;
import io.github.kelari.model.v3.parameters.Parameter;
import io.github.kelari.model.v3.paths.PathItem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Validates the parameters defined in the OpenAPI specification.
 * <p>
 * This validator ensures that each parameter has required fields like name, location (in),
 * and schema, and also checks for common issues like missing descriptions or invalid references.
 * </p>
 *
 * <p><strong>Validation Rules:</strong></p>
 * <ul>
 *     <li><b>PARAMETER-001:</b> Parameter name is missing or empty (error).</li>
 *     <li><b>PARAMETER-002:</b> Parameter location (in) is missing or invalid (error).</li>
 *     <li><b>PARAMETER-003:</b> Parameter schema is missing or improperly defined (error).</li>
 *     <li><b>PARAMETER-004:</b> Parameter description is missing (warning).</li>
 *     <li><b>PARAMETER-005:</b> Parameter reference ($ref) is incorrectly formatted (warning).</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class ParameterValidator implements SpecValidator {

    private static final Logger LOGGER = Logger.getLogger(ParameterValidator.class.getName());

    @Override
    public ValidationResult validate(OpenAPI spec) {
        ValidationResult result = new ValidationResult();
        if (spec == null) {
            result.addError("PARAMETER-000", "OpenAPI specification is null", "spec");
            return result;
        }
        // Assume that parameters are part of the paths in the OpenAPI specification
        Map<String, PathItem> paths = spec.getPaths();
        if (paths == null || paths.isEmpty()) {
            result.addWarning("PARAMETER-001", "No paths defined in the OpenAPI specification", "paths");
            return result;
        }
        List<String> operations = Arrays.asList("get", "post", "put", "delete", "patch", "head", "options");
        // Iterate over each path and its associated operations
        for (Map.Entry<String, PathItem> pathEntry : paths.entrySet()) {
            String path = pathEntry.getKey();
            PathItem pathItem = pathEntry.getValue();
            for (String operation : operations) {
                try {
                    Method operationMethod = PathItem.class.getMethod(operation);
                    Operation operationInstance = (Operation) operationMethod.invoke(pathItem);
                    if (operationInstance != null && operationInstance.getParameters() != null)
                        checkParameters(result, path, operationInstance.getParameters());
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    LOGGER.warning(() -> String.format("Operation '%s' is not defined for path '%s'.", operation, path));
                }
            }
        }
        return result;
    }

    private void checkParameters(ValidationResult result, String path, List<Parameter> parameters) {
        if (parameters == null || parameters.isEmpty()) return;
        for (Parameter parameter : parameters) {
            // Validate name
            if (parameter.getName() == null || parameter.getName().isEmpty())
                result.addError("PARAMETER-001", "Parameter name is missing or empty", "path[" + path + "] parameter[" + parameter.getName() + "]");
            // Validate location (in)
            if (parameter.getIn() == null || parameter.getIn().isEmpty())
                result.addError("PARAMETER-002", "Parameter location (in) is missing or invalid", "path[" + path + "] parameter[" + parameter.getName() + "]");
            // Validate schema
            if (parameter.getSchema() == null)
                result.addError("PARAMETER-003", "Parameter schema is missing or improperly defined", "path[" + path + "] parameter[" + parameter.getName() + "]");
            // Validate description (optional but recommended)
            if (parameter.getDescription() == null || parameter.getDescription().isEmpty())
                result.addWarning("PARAMETER-004", "Parameter description is missing", "path[" + path + "] parameter[" + parameter.getName() + "]");
            // Validate $ref format
            if (parameter.get$ref() != null && !parameter.get$ref().startsWith("#/components/parameters/"))
                result.addWarning("PARAMETER-005", "Parameter $ref is incorrectly formatted", "path[" + path + "] parameter[" + parameter.getName() + "]");
        }
    }
}
