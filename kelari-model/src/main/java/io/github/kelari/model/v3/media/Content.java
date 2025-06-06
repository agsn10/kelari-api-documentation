package io.github.kelari.model.v3.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Represents the {@code Content} object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code Content} object maps media types (e.g. {@code application/json}) to their corresponding
 * {@link MediaType} definitions. It is used in request bodies, responses, and parameters
 * to describe the available representations.
 * </p>
 *
 * <p><strong>Usage Example (Java):</strong></p>
 * <pre>
 * Content content = new Content();
 * content.put("application/json", new MediaType()
 *     .schema(new Schema().type("object")
 *         .properties(Map.of(
 *             "name", new Schema().type("string"),
 *             "age", new Schema().type("integer")
 *         )));
 * </pre>
 *
 * <p><strong>OpenAPI YAML Example:</strong></p>
 * <pre>
 * content:
 *   application/json:
 *     schema:
 *       type: object
 *       properties:
 *         name:
 *           type: string
 *         age:
 *           type: integer
 * </pre>
 *
 * <p>This class extends {@link LinkedHashMap} to preserve insertion order of media types.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see MediaType
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#mediaTypeObject">OpenAPI 3.0.1 – Media Type Object</a>
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#contentObject">OpenAPI 3.0.1 – Content Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Content extends LinkedHashMap<String, MediaType> implements Serializable, IndentedString {

    /**
     * Creates a new empty {@code Content} object.
     */
    public Content() {
    }

    /**
     * Adds a new media type entry to this content.
     *
     * @param name the media type name (e.g. {@code application/json})
     * @param item the {@link MediaType} definition associated with this media type
     * @return this {@code Content} instance for method chaining
     */
    public Content addMediaType(String name, MediaType item) {
        this.put(name, item);
        return this;
    }

    /**
     * Compares this content object with another for equality.
     *
     * @param o the object to compare
     * @return {@code true} if the other object is equal to this one, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     * Returns the hash code value for this content.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Returns a string representation of the content object, formatted with indentation.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Content {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}