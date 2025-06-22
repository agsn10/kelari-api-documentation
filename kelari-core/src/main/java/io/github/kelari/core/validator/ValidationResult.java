package io.github.kelari.core.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private boolean isValid;
    private List<String> errorMessages;

    public ValidationResult() {
        this.isValid = true;
        this.errorMessages = new ArrayList<>();
    }

    public void addError(String errorMessage) {
        this.isValid = false;
        this.errorMessages.add(errorMessage);
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public int getErrorCount() {
        return errorMessages.size();
    }

    public void clearErrors() {
        this.errorMessages.clear();
        this.isValid = true;
    }
}
