package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents a composed schema object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code ComposedSchema} class extends {@link Schema} to support composition constructs
 * such as {@code allOf}, {@code oneOf}, and {@code anyOf} defined in the OpenAPI Specification.
 * It is commonly used to model inheritance or alternative schemas in API definitions.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * ComposedSchema schema = new ComposedSchema();
 * schema.setAllOf(List.of(new Schema<>().$ref("#/components/schemas/Base")));
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * components:
 *   schemas:
 *     Pet:
 *       allOf:
 *         - $ref: '#/components/schemas/Base'
 *         - type: object
 *           properties:
 *             name:
 *               type: string
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComposedSchema extends Schema<Object>{

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ComposedSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}