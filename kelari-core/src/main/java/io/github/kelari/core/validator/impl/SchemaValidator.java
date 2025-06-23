package io.github.kelari.core.validator.impl;

import io.github.kelari.core.validator.SpecValidator;
import io.github.kelari.core.validator.ValidationHelper;
import io.github.kelari.core.validator.ValidationResult;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.media.Schema;
import io.github.kelari.model.v3.paths.PathItem;

import java.util.*;
import java.util.logging.Logger;

/**
 * Validator for schemas in the OpenAPI specification.
 * <p>
 * Validates if the schemas defined in OpenAPI are correct and conform to the specification.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class SchemaValidator implements SpecValidator {

    private static final Logger LOGGER = Logger.getLogger(SchemaValidator.class.getName());

    /**
     * Validates the OpenAPI specification by checking all defined schemas and path parameters.
     *
     * @param spec the OpenAPI specification to validate
     * @return the validation result, containing any errors found
     */
    @Override
    public ValidationResult validate(OpenAPI spec) {
        LOGGER.info("Starting OpenAPI schema validation...");
        ValidationResult result = new ValidationResult();

        if (spec.getComponents() != null && spec.getComponents().getSchemas() != null) {
            for (Map.Entry<String, Schema> schemaEntry : spec.getComponents().getSchemas().entrySet()) {
                String schemaName = schemaEntry.getKey();
                Schema schema = schemaEntry.getValue();
                validateSchema(schemaName, schema, result);
            }
        }

        if (spec.getPaths() != null) {
            for (Map.Entry<String, PathItem> pathEntry : spec.getPaths().entrySet()) {
                PathItem pathItem = pathEntry.getValue();
                ValidationHelper.validateParameters(pathEntry.getKey(), pathItem.getParameters(), result);
                ValidationHelper.validateParameters(pathEntry.getKey(), pathItem.getGet() != null ? pathItem.getGet().getParameters() : null, result);
                ValidationHelper.validateParameters(pathEntry.getKey(), pathItem.getPost() != null ? pathItem.getPost().getParameters() : null, result);
                ValidationHelper.validateParameters(pathEntry.getKey(), pathItem.getPut() != null ? pathItem.getPut().getParameters() : null, result);
                ValidationHelper.validateParameters(pathEntry.getKey(), pathItem.getDelete() != null ? pathItem.getDelete().getParameters() : null, result);
                ValidationHelper.validateParameters(pathEntry.getKey(), pathItem.getHead() != null ? pathItem.getHead().getParameters() : null, result);
                ValidationHelper.validateParameters(pathEntry.getKey(), pathItem.getOptions() != null ? pathItem.getOptions().getParameters() : null, result);
                ValidationHelper.validateParameters(pathEntry.getKey(), pathItem.getPatch() != null ? pathItem.getPatch().getParameters() : null, result);
            }
        }

        return result;
    }

    /**
     * Validates a single schema by checking for required properties, types, references, and format.
     *
     * @param schemaName the name of the schema
     * @param schema     the schema to validate
     * @param result     the validation result to store any errors found
     */
    private void validateSchema(String schemaName, Schema schema, ValidationResult result) {

        if (schema.getType() == null || schema.getType().isEmpty()) {
            result.addError(
                    "SCHEMA_MISSING_TYPE",
                    "The schema '" + schemaName + "' does not define a type.",
                    "Schema: " + schemaName
            );
        }

        if (schema.getRequired() != null) {
            for (Object requiredProp : schema.getRequired()) {
                if (!schema.getProperties().containsKey(requiredProp)) {
                    result.addError(
                            "SCHEMA_REQUIRED_PROPERTY_MISSING",
                            "The required property '" + requiredProp.toString() + "' is missing in schema '" + schemaName + "'.",
                            "Schema: " + schemaName
                    );
                }
            }
        }

        // Validate schema reference
        if (schema.get$ref() != null && !schema.get$ref().startsWith("#/components/schemas/")) {
            result.addError(
                    "SCHEMA_INVALID_REFERENCE",
                    "The reference in schema '" + schemaName + "' is invalid. It must start with '#/components/schemas/'.",
                    "Schema: " + schemaName
            );
        }

        if (schema.getFormat() != null && schema.getExample() != null) {
            String format = schema.getFormat();
            String example = schema.getExample().toString();

            switch (format) {
                case "email" -> {
                    if (!ValidationHelper.isValidEmailFormat(example)) {
                        result.addError(
                                "SCHEMA_INVALID_EMAIL_FORMAT",
                                "The example for schema '" + schemaName + "' is not a valid email format.",
                                "Schema: " + schemaName
                        );
                    }
                }
                case "uri" -> {
                    if (!ValidationHelper.isValidUriFormat(example)) {
                        result.addError(
                                "SCHEMA_INVALID_URI_FORMAT",
                                "The example for schema '" + schemaName + "' is not a valid URI.",
                                "Schema: " + schemaName
                        );
                    }
                }
                case "uuid" -> {
                    if (!ValidationHelper.isValidUUIDFormat(example)) {
                        result.addError(
                                "SCHEMA_INVALID_UUID_FORMAT",
                                "The example for schema '" + schemaName + "' is not a valid UUID.",
                                "Schema: " + schemaName
                        );
                    }
                }
                case "date" -> {
                    if (!ValidationHelper.isValidDateFormat(example)) {
                        result.addError(
                                "SCHEMA_INVALID_DATE_FORMAT",
                                "The example for schema '" + schemaName + "' is not in the 'YYYY-MM-DD' date format.",
                                "Schema: " + schemaName
                        );
                    }
                }
                case "date-time" -> {
                    if (!ValidationHelper.isValidDateTimeFormat(example)) {
                        result.addError(
                                "SCHEMA_INVALID_DATETIME_FORMAT",
                                "The example for schema '" + schemaName + "' is not a valid ISO 8601 datetime format.",
                                "Schema: " + schemaName
                        );
                    }
                }
                case "ipv4" -> {
                    if (!ValidationHelper.isValidIPv4Format(example)) {
                        result.addError(
                                "SCHEMA_INVALID_IPV4_FORMAT",
                                "The example for schema '" + schemaName + "' is not a valid IPv4 address.",
                                "Schema: " + schemaName
                        );
                    }
                }
                case "ipv6" -> {
                    if (!ValidationHelper.isValidIPv6Format(example)) {
                        result.addError(
                                "SCHEMA_INVALID_IPV6_FORMAT",
                                "The example for schema '" + schemaName + "' is not a valid IPv6 address.",
                                "Schema: " + schemaName
                        );
                    }
                }
                case "hostname" -> {
                    if (!ValidationHelper.isValidHostnameFormat(example)) {
                        result.addError(
                                "SCHEMA_INVALID_HOSTNAME_FORMAT",
                                "The example for schema '" + schemaName + "' is not a valid hostname.",
                                "Schema: " + schemaName
                        );
                    }
                }
                default -> {
                    // Unrecognized format - no validation performed
                }
            }
        }
    }
}
