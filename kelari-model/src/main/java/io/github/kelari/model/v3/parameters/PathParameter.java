package io.github.kelari.model.v3.parameters;

import java.util.Objects;

/**
 * Represents a Path parameter object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code PathParameter} class extends {@link Parameter} and sets the {@code in} property to {@code "path"}
 * to indicate that the parameter is part of the URL path. Path parameters are always required by specification.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * PathParameter pathParam = new PathParameter();
 * pathParam.setName("userId");
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * parameters:
 *   - name: userId
 *     in: path
 *     required: true
 *     schema:
 *       type: string
 * </pre>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see Parameter
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#parameter-object">OpenAPI 3.0.1 – Parameter Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
public class PathParameter extends Parameter {

    private String in = "path";
    private Boolean required = true;

    /**
     * Returns the {@code in} value indicating the parameter is in the path.
     *
     * @return the string {@code "path"}.
     */
    @Override
    public String getIn() {
        return in;
    }

    /**
     * Sets the {@code in} value.
     * <p>
     * This is typically fixed to {@code "path"}.
     * </p>
     *
     * @param in the location of the parameter (should be {@code "path"}).
     */
    @Override
    public void setIn(String in) {
        this.in = in;
    }

    /**
     * Fluent setter for the {@code in} value.
     *
     * @param in the location of the parameter.
     * @return this {@code PathParameter} instance.
     */
    @Override
    public PathParameter in(String in) {
        this.in = in;
        return this;
    }

    /**
     * Returns whether this parameter is required.
     * <p>
     * Path parameters must be required in OpenAPI.
     * </p>
     *
     * @return {@code true} if the parameter is required, otherwise {@code false}.
     */
    @Override
    public Boolean getRequired() {
        return required;
    }

    /**
     * Sets whether this parameter is required.
     *
     * @param required {@code true} if required, otherwise {@code false}.
     */
    @Override
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * Fluent setter for the {@code required} property.
     *
     * @param required whether the parameter is required.
     * @return this {@code PathParameter} instance.
     */
    @Override
    public PathParameter required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * Indicates whether this object is equal to another.
     *
     * @param object the other object.
     * @return {@code true} if equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PathParameter that = (PathParameter) object;
        return Objects.equals(in, that.in) && Objects.equals(required, that.required);
    }

    /**
     * Returns a hash code for this object.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(in, required, super.hashCode());
    }

    /**
     * Returns a string representation of the {@code PathParameter}.
     *
     * @return a formatted string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PathParameter {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    in: ").append(toIndentedString(in)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}