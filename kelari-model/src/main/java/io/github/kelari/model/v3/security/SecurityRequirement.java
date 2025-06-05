package io.github.kelari.model.v3.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.kelari.model.v3.util.IndentedString;

import java.io.Serializable;
import java.util.*;

/**
 * Represents the {@code SecurityRequirement} object in the OpenAPI 3.0.1 specification.
 * <p>
 * The {@code SecurityRequirement} object lists the required security schemes to execute an operation.
 * Each name must correspond to a security scheme declared in the {@code SecuritySchemes} section of the OpenAPI document.
 * </p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @see io.github.kelari.model.v3.security.SecurityScheme
 * @see <a href="https://spec.openapis.org/oas/v3.0.1#securityRequirementObject">OpenAPI 3.0.1 – Security Requirement Object</a>
 * @copyright 2025 Kelari. All rights reserved.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SecurityRequirement extends LinkedHashMap<String, List<String>> implements Serializable, IndentedString {

    /**
     * Adds a security requirement with a single scope value.
     *
     * @param name the name of the security scheme.
     * @param item the scope or permission required for the scheme.
     * @return the current {@code SecurityRequirement} instance for method chaining.
     */
    public SecurityRequirement addList(String name, String item) {
        this.put(name, Arrays.asList(item));
        return this;
    }
    /**
     * Adds a security requirement with a list of scope values.
     *
     * @param name the name of the security scheme.
     * @param item the list of scopes or permissions required for the scheme.
     * @return the current {@code SecurityRequirement} instance for method chaining.
     */
    public SecurityRequirement addList(String name, List<String> item) {
        this.put(name, item);
        return this;
    }
    /**
     * Adds a security requirement without any specific scope values (e.g., API keys or basic auth).
     *
     * @param name the name of the security scheme.
     * @return the current {@code SecurityRequirement} instance for method chaining.
     */
    public SecurityRequirement addList(String name) {
        this.put(name, new ArrayList<>());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (Objects.isNull(o) || getClass() != o.getClass())
            return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SecurityRequirement {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}