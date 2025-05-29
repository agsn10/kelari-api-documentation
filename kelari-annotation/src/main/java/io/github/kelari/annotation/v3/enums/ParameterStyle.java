package io.github.kelari.annotation.v3.enums;

import java.io.Serializable;

/**
 * Defines the style of parameter serialization as specified in the OpenAPI Specification.
 *
 * <p>
 * The {@code ParameterStyle} enum determines how values of parameters are formatted
 * and serialized depending on the parameter location (e.g., query, path, header).
 * </p>
 *
 * <ul>
 *     <li>{@link #FORM} – Default style for parameters in {@code query} and {@code cookie}. Uses ampersand-separated values.</li>
 *     <li>{@link #SIMPLE} – Default style for {@code path} and {@code header} parameters. Uses comma-separated values.</li>
 *     <li>{@link #MATRIX} – Uses semicolon-prefixed key-value pairs. Often used in path parameters.</li>
 *     <li>{@link #LABEL} – Uses dot-prefixed key-value pairs. Often used in path parameters.</li>
 *     <li>{@link #DEEPOBJECT} – Provides a way to serialize complex objects in {@code query} parameters.</li>
 *     <li>{@link #PIPEDELIMITED} – Uses pipe-separated values (e.g., {@code a|b|c}).</li>
 *     <li>{@link #SPACEDELIMITED} – Uses space-separated values (e.g., {@code a b c}).</li>
 *     <li>{@link #DEFAULT} – Represents an unspecified or implementation-defined style.</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#style-values">
 *      Parameter Style (OpenAPI Specification)</a>
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum ParameterStyle implements Comparable<ParameterStyle>, Serializable {
    DEEPOBJECT,
    DEFAULT,
    FORM,
    LABEL,
    MATRIX,
    PIPEDELIMITED,
    SIMPLE,
    SPACEDELIMITED
}