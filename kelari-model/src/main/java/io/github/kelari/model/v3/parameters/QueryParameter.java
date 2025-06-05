package io.github.kelari.model.v3.parameters;

import java.util.Objects;

/**
 * Represents a Query parameter object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code QueryParameter} class extends {@link Parameter} and sets the {@code in} property to {@code "query"},
 * indicating that the parameter is passed as part of the query string in the URL.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>{@code
 * QueryParameter queryParam = new QueryParameter();
 * queryParam.setName("filter");
 * }</pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * parameters:
 *   - name: filter
 *     in: query
 *     required: false
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
public class QueryParameter extends Parameter {

    private String in = "query";

    /**
     * Returns the {@code in} value indicating the parameter is in the query string.
     *
     * @return the string {@code "query"}.
     */
    @Override
    public String getIn() {
        return in;
    }

    /**
     * Sets the {@code in} value.
     * <p>
     * This is typically fixed to {@code "query"}.
     * </p>
     *
     * @param in the location of the parameter (should be {@code "query"}).
     */
    @Override
    public void setIn(String in) {
        this.in = in;
    }

    /**
     * Fluent setter for the {@code in} value.
     *
     * @param in the location of the parameter.
     * @return this {@code QueryParameter} instance.
     */
    @Override
    public QueryParameter in(String in) {
        this.in = in;
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
        QueryParameter that = (QueryParameter) object;
        return Objects.equals(in, that.in);
    }

    /**
     * Returns a hash code for this object.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(in, super.hashCode());
    }

    /**
     * Returns a string representation of the {@code QueryParameter}.
     *
     * @return a formatted string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class QueryParameter {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    in: ").append(toIndentedString(in)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}