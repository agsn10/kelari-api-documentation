package io.github.kelari.core.builder;

import io.github.kelari.model.v3.operations.Operation;
import io.github.kelari.model.v3.parameters.Parameter;
import io.github.kelari.model.v3.parameters.RequestBody;
import io.github.kelari.model.v3.responses.ApiResponse;
import io.github.kelari.model.v3.responses.ApiResponses;

import java.util.*;

/**
 * Builder class for constructing OpenAPI Operation objects.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public class OperationBuilder {

    private final Operation operation;

    private final List<Parameter> parameters = new ArrayList<>();
    private final List<String> tags = new ArrayList<>();
    private final Map<String, ApiResponse> responses = new LinkedHashMap<>();

    public OperationBuilder() {
        this.operation = new Operation();
    }

    public static OperationBuilder create() {
        return new OperationBuilder();
    }

    public OperationBuilder summary(String summary) {
        this.operation.setSummary(summary);
        return this;
    }

    public OperationBuilder description(String description) {
        this.operation.setDescription(description);
        return this;
    }

    public OperationBuilder operationId(String operationId) {
        this.operation.setOperationId(operationId);
        return this;
    }

    public OperationBuilder tag(String tag) {
        this.tags.add(tag);
        return this;
    }

    public OperationBuilder tags(List<String> tags) {
        this.tags.addAll(tags);
        return this;
    }

    public OperationBuilder parameter(Parameter parameter) {
        this.parameters.add(parameter);
        return this;
    }

    public OperationBuilder parameters(List<Parameter> parameters) {
        this.parameters.addAll(parameters);
        return this;
    }

    public OperationBuilder requestBody(RequestBody requestBody) {
        this.operation.setRequestBody(requestBody);
        return this;
    }

    public OperationBuilder response(String statusCode, ApiResponse response) {
        this.responses.put(statusCode, response);
        return this;
    }

    public OperationBuilder responses(Map<String, ApiResponse> responses) {
        this.responses.putAll(responses);
        return this;
    }

    public OperationBuilder deprecated(boolean deprecated) {
        this.operation.setDeprecated(deprecated);
        return this;
    }

    public Operation build() {
        if (!tags.isEmpty()) operation.setTags(tags);
        if (!parameters.isEmpty()) operation.setParameters(parameters);
        if (!responses.isEmpty()) {
            ApiResponses apiResponses = new ApiResponses();
            responses.forEach(apiResponses::put);
            operation.setResponses(apiResponses);
        }
        return operation;
    }
}
