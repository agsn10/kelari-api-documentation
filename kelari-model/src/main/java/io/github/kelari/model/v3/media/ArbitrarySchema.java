package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an arbitrary schema object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code ArbitrarySchema} class extends the generic {@link Schema} for cases where
 * the schema can represent any type of value (i.e., a free-form object or untyped structure).
 * It is commonly used when the structure of the data is not strictly defined.
 * </p>
 *
 * <p>This class allows the specification of schema type and example value for better
 * documentation and client generation.</p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * ArbitrarySchema schema = new ArbitrarySchema()
 *     .type("object")
 *     .example(Map.of("foo", "bar", "count", 10));
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * components:
 *   schemas:
 *     AnyData:
 *       type: object
 *       example:
 *         id: 12345
 *         payload:
 *           message: Hello
 *           timestamp: 2025-06-04T12:00:00Z
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArbitrarySchema extends Schema<Object> implements Serializable, IndentedString {

    @Override
    public ArbitrarySchema type(String type) {
        super.setType(type);
        return this;
    }

    @Override
    public ArbitrarySchema example(Object example) {
        if (Objects.nonNull(example))
            super.setExample(example);
        return this;
    }

    @Override
    protected Object cast(Object value) {
        return value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ArbitrarySchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}