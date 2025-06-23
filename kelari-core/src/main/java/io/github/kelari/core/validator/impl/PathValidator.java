package io.github.kelari.core.validator.impl;

import io.github.kelari.core.validator.SpecValidator;
import io.github.kelari.core.validator.ValidationResult;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.operations.Operation;
import io.github.kelari.model.v3.paths.PathItem;

import java.util.Map;
import java.util.Set;

/**
 * Validates the path definitions in an OpenAPI specification.
 *
 * <p>This validator checks whether each path in the {@code paths} section:</p>
 * <ul>
 *     <li>Is not null or empty</li>
 *     <li>Starts with a forward slash ("/")</li>
 *     <li>Contains at least one valid HTTP operation (e.g., GET, POST)</li>
 * </ul>
 *
 * <p>Each validation error includes a code, a description, and a pointer to the affected element.</p>
 *
 * <h2>Error Codes</h2>
 * <ul>
 *     <li><b>PATH-001</b>: OpenAPI specification is {@code null}</li>
 *     <li><b>PATH-002</b>: No paths are defined in the specification</li>
 *     <li><b>PATH-003</b>: Path key is {@code null}, empty, or blank</li>
 *     <li><b>PATH-004</b>: Path does not start with {@code '/'}</li>
 *     <li><b>PATH-005</b>: Path does not define any supported HTTP operation (GET, POST, etc.)</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see io.github.kelari.core.validator.SpecValidator
 * @see io.github.kelari.core.validator.ValidationResult
 */
public class PathValidator implements SpecValidator {

    private static final Set<String> SUPPORTED_OPERATIONS = Set.of(
            "get", "put", "post", "delete", "options", "head", "patch", "trace"
    );

    /**
     * Validates the paths defined in the given OpenAPI specification.
     *
     * @param spec the {@link OpenAPI} specification object to validate.
     * @return a {@link ValidationResult} containing errors if any path is missing, malformed,
     *         or does not contain valid operations.
     */
    @Override
    public ValidationResult validate(OpenAPI spec) {
        ValidationResult result = new ValidationResult();
        if (spec == null) {
            result.addError("PATH-001", "OpenAPI specification is null", "spec");
            return result;
        }
        if (spec.getPaths() == null || spec.getPaths().isEmpty()) {
            result.addError("PATH-002", "No paths defined in the OpenAPI specification", "paths");
            return result;
        }
        for (Map.Entry<String, PathItem> entry : spec.getPaths().entrySet()) {
            String path = entry.getKey();
            PathItem pathItem = entry.getValue();
            if (path == null || path.isBlank()) {
                result.addError("PATH-003", "Path is null or empty", "paths[" + path + "]");
                continue;
            }
            if (!path.startsWith("/"))
                result.addError("PATH-004", "Path must start with '/'", "paths[" + path + "]");
            boolean hasAtLeastOneOperation = SUPPORTED_OPERATIONS.stream()
                    .anyMatch(op -> getOperationByName(pathItem, op) != null);
            if (!hasAtLeastOneOperation)
                result.addError("PATH-005", "No operations defined for path", "paths[" + path + "]");
        }

        return result;
    }

    /**
     * Retrieves the operation from a given {@link PathItem} by operation name (e.g., "get", "post").
     *
     * @param item the {@link PathItem} containing operations
     * @param name the HTTP operation name to retrieve
     * @return the {@link Operation} corresponding to the given name, or {@code null} if not present
     */
    private Operation getOperationByName(PathItem item, String name) {
        return switch (name) {
            case "get"    -> item.getGet();
            case "put"    -> item.getPut();
            case "post"   -> item.getPost();
            case "delete" -> item.getDelete();
            case "options"-> item.getOptions();
            case "head"   -> item.getHead();
            case "patch"  -> item.getPatch();
            case "trace"  -> item.getTrace();
            default       -> null;
        };
    }
}
