package io.github.kelari.core.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the result of a validation process.
 * It holds the status (valid or invalid) and any associated errors and warnings with codes and contexts.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class ValidationResult {

    private boolean isValid;
    private final List<ValidationIssue> errors;
    private final List<ValidationIssue> warnings;

    public ValidationResult() {
        this.isValid = true;
        this.errors = new ArrayList<>();
        this.warnings = new ArrayList<>();
    }

    /**
     * Adds an error to the validation result and marks the result as invalid.
     *
     * @param errorCode    The error code.
     * @param errorMessage The error message.
     * @param errorContext The context (e.g., "path", "schema").
     */
    public void addError(String errorCode, String errorMessage, String errorContext) {
        this.isValid = false;
        this.errors.add(new ValidationIssue(errorCode, errorMessage, errorContext));
    }

    /**
     * Adds a warning to the validation result (does not change validity).
     *
     * @param warningCode    The warning code.
     * @param warningMessage The warning message.
     * @param warningContext The context.
     */
    public void addWarning(String warningCode, String warningMessage, String warningContext) {
        this.warnings.add(new ValidationIssue(warningCode, warningMessage, warningContext));
    }

    /**
     * Checks if the result is valid (no errors).
     */
    public boolean isValid() {
        return isValid;
    }

    public List<ValidationIssue> getErrors() {
        return errors;
    }

    public List<ValidationIssue> getWarnings() {
        return warnings;
    }

    public int getErrorCount() {
        return errors.size();
    }

    public int getWarningCount() {
        return warnings.size();
    }

    /**
     * Clears all errors and warnings and resets the validity.
     */
    public void clear() {
        this.errors.clear();
        this.warnings.clear();
        this.isValid = true;
    }

    /**
         * Represents a validation issue (error or warning).
         */
        public record ValidationIssue(String code, String message, String context) {

        @Override
            public String toString() {
                return String.format("[%s] %s (%s)", code, message, context);
            }
        }
}
