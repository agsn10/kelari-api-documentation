package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Represents an array schema object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code ArraySchema} class is a specialized {@link Schema} used to define arrays in the OpenAPI document.
 * It specifies that the type of the schema is {@code array} and can contain a reference to the schema
 * of the items within the array.
 * </p>
 *
 * <p>This class supports method chaining for setting the type and item schema.</p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * ArraySchema schema = new ArraySchema()
 *     .items(new Schema<>().type("string"));
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * components:
 *   schemas:
 *     Tags:
 *       type: array
 *       items:
 *         type: string
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArraySchema extends Schema<Object>{

    public ArraySchema() {
        super("array", null);
    }

    @Override
    public ArraySchema type(String type) {
        super.setType(type);
        return this;
    }

    @Override
    public ArraySchema items(Schema items) {
        super.setItems(items);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArraySchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
