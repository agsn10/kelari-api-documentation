package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a Boolean Schema in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code BooleanSchema} class extends {@link Schema} to support boolean values
 * compliant with the OpenAPI specification. It allows setting a default value, casting
 * arbitrary objects into booleans, and defining enum constraints.
 * </p>
 *
 * <p>
 * This schema type defaults to:
 * <ul>
 *   <li>{@code type} = "boolean"</li>
 * </ul>
 * </p>
 *
 * <p><strong>Casting Behavior:</strong></p>
 * <p>
 * The {@code cast(Object)} method attempts to convert any object into a {@code Boolean}
 * using {@link Boolean#parseBoolean(String)}. If the conversion fails, {@code null} is returned,
 * and the error is logged.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * BooleanSchema booleanSchema = new BooleanSchema();
 * booleanSchema._default(true)
 *              .addEnumItem(true)
 *              .addEnumItem(false);
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * schema:
 *   type: boolean
 *   default: true
 *   enum:
 *     - true
 *     - false
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Schema
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#schema-object">OpenAPI 3.0.1 – Schema Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#data-types">OpenAPI 3.0.1 – Data Types</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooleanSchema extends Schema<Boolean> {

    private static final Logger LOGGER = Logger.getLogger(BooleanSchema.class.getName());

    /**
     * Constructs a new {@code BooleanSchema} with the type set to {@code "boolean"}.
     */
    public BooleanSchema() {
        super("boolean", null);
    }

    /**
     * Sets the schema type.
     *
     * @param type the type to set (typically "boolean")
     * @return the updated {@code BooleanSchema} instance
     */
    @Override
    public BooleanSchema type(String type) {
        super.setType(type);
        return this;
    }

    /**
     * Sets multiple schema types.
     *
     * @param types a set of types to assign to the schema
     * @return the updated {@code BooleanSchema} instance
     */
    @Override
    public BooleanSchema types(Set<String> types) {
        super.setTypes(types);
        return this;
    }

    /**
     * Sets the default boolean value for the schema.
     *
     * @param _default the default value
     * @return the updated {@code BooleanSchema} instance
     */
    public BooleanSchema _default(Boolean _default) {
        super.setDefault(_default);
        return this;
    }

    /**
     * Attempts to cast a given object to a {@link Boolean}.
     * <p>
     * Uses {@code Boolean.parseBoolean(String)} for conversion. If parsing fails,
     * logs the error and returns {@code null}.
     *
     * @param value the object to cast
     * @return the parsed boolean value, or {@code null} if casting fails
     */
    @Override
    protected Boolean cast(Object value) {
        if (Objects.nonNull(value)) {
            try {
                return Boolean.parseBoolean(value.toString());
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    /**
     * Sets the enumeration of acceptable boolean values.
     *
     * @param _enum the list of allowed boolean values
     * @return the updated {@code BooleanSchema} instance
     */
    public BooleanSchema _enum(List<Boolean> _enum) {
        this._enum = _enum;
        return this;
    }

    /**
     * Adds a single boolean value to the enumeration list.
     * If the list is {@code null}, it will be initialized.
     *
     * @param _enumItem the boolean value to add
     * @return the updated {@code BooleanSchema} instance
     */
    public BooleanSchema addEnumItem(Boolean _enumItem) {
        if (Objects.isNull(this._enum)) {
            this._enum = new ArrayList<Boolean>();
        }
        this._enum.add(_enumItem);
        return this;
    }

    /**
     * Returns a string representation of the {@code BooleanSchema},
     * including all inherited properties indented for readability.
     *
     * @return the string representation of the schema
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BooleanSchema {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}