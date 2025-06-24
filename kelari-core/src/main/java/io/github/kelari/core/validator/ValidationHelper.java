package io.github.kelari.core.validator;

import io.github.kelari.model.v3.parameters.Parameter;

import java.util.List;
import java.util.UUID;

/**
 * Utility class containing helper methods for validation tasks.
 * <p>
 * Provides methods to validate various formats such as email, URI, UUID, date, datetime, IPv4, IPv6, and hostname.
 * Also provides a method for validating parameters in an OpenAPI specification.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public final class ValidationHelper {

    // Private constructor to prevent instantiation
    private ValidationHelper(){}

    /**
     * Validates if the given value is in a valid email format.
     *
     * @param value the string value to validate
     * @return true if the value matches the email format, false otherwise
     */
    public static boolean isValidEmailFormat(String value) {
        return value != null && value.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    /**
     * Validates if the given value is in a valid URI format.
     *
     * @param value the string value to validate
     * @return true if the value is a valid URI, false otherwise
     */
    public static boolean isValidUriFormat(String value) {
        try {
            new java.net.URI(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates if the given value is in a valid UUID format.
     *
     * @param value the string value to validate
     * @return true if the value is a valid UUID, false otherwise
     */
    public static boolean isValidUUIDFormat(String value) {
        try {
            UUID.fromString(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates if the given value is in a valid date format (YYYY-MM-DD).
     *
     * @param value the string value to validate
     * @return true if the value matches the date format, false otherwise
     */
    public static boolean isValidDateFormat(String value) {
        return value != null && value.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }

    /**
     * Validates if the given value is in a valid datetime format (ISO 8601).
     *
     * @param value the string value to validate
     * @return true if the value is a valid ISO 8601 datetime, false otherwise
     */
    public static boolean isValidDateTimeFormat(String value) {
        try {
            java.time.OffsetDateTime.parse(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Validates if the given value is in a valid IPv4 format.
     *
     * @param value the string value to validate
     * @return true if the value is a valid IPv4 address, false otherwise
     */
    public static boolean isValidIPv4Format(String value) {
        return value != null && value.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$");
    }

    /**
     * Validates if the given value is in a valid IPv6 format.
     *
     * @param value the string value to validate
     * @return true if the value is a valid IPv6 address, false otherwise
     */
    public static boolean isValidIPv6Format(String value) {
        return value != null && value.matches("([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}");
    }

    /**
     * Validates if the given value is in a valid hostname format.
     *
     * @param value the string value to validate
     * @return true if the value is a valid hostname, false otherwise
     */
    public static boolean isValidHostnameFormat(String value) {
        return value != null && value.matches("^[a-zA-Z0-9.-]+$");
    }

    /**
     * Validates parameters in an OpenAPI path item by checking if they have a schema or content defined.
     *
     * @param path       the path of the API endpoint
     * @param parameters the list of parameters to validate
     * @param result     the validation result object where errors are reported
     */
    public static void validateParameters(String path, List<Parameter> parameters, ValidationResult result) {
        if (parameters != null) {
            for (Parameter param : parameters) {
                String name = param.getName() != null ? param.getName() : "<no name>";

                if (param.get$ref() != null)
                    continue;

                boolean hasSchema = param.getSchema() != null && param.getSchema().getType() != null;
                boolean hasContent = param.getContent() != null && !param.getContent().isEmpty();

                if (!hasSchema && !hasContent) {
                    result.addError(
                            "PARAMETER_MISSING_SCHEMA_OR_CONTENT",
                            "The parameter '" + name + "' must contain a valid 'schema' or 'content'.",
                            "Path: " + path + ", Parameter: " + name
                    );
                }

                if (param.getSchema() != null && param.getSchema().getType() == null) {
                    result.addError(
                            "PARAMETER_SCHEMA_TYPE_MISSING",
                            "The schema for the parameter '" + name + "' is present but does not define a type.",
                            "Path: " + path + ", Parameter: " + name
                    );
                }
            }
        }
    }
}
