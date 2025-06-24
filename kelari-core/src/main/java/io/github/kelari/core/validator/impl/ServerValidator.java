package io.github.kelari.core.validator.impl;

import io.github.kelari.core.validator.SpecValidator;
import io.github.kelari.core.validator.ValidationResult;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.servers.Server;

import java.util.List;
import java.util.Objects;

/**
 * Validates the list of servers defined in the OpenAPI specification.
 * <p>
 * This validator ensures that at least one server is defined, and that each server has a valid URL.
 * </p>
 *
 * <p><strong>Validation Rules:</strong></p>
 * <ul>
 *     <li><b>SERVER-001:</b> No servers defined at the root of the OpenAPI specification (warning).</li>
 *     <li><b>SERVER-002:</b> Server URL is missing or empty (error).</li>
 * </ul>
 *
 * <p>This validation is important because the server URL determines the base path where the API is served.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class ServerValidator implements SpecValidator {

    @Override
    public ValidationResult validate(OpenAPI spec) {
        ValidationResult result = new ValidationResult();
        if (spec == null) {
            result.addError("SERVER-000", "OpenAPI specification is null", "spec");
            return result;
        }
        List<Server> servers = spec.getServers();
        if (Objects.isNull(servers) || servers.isEmpty()) {
            result.addWarning("SERVER-001", "No servers defined in the OpenAPI specification", "servers");
            return result;
        }
        for (int i = 0; i < servers.size(); i++) {
            Server server = servers.get(i);
            if (Objects.isNull(servers) || Objects.isNull(server.getUrl()) || server.getUrl().isBlank())
                result.addError("SERVER-002", "Server URL is missing or empty", "servers[" + i + "]");
        }
        return result;
    }
}
