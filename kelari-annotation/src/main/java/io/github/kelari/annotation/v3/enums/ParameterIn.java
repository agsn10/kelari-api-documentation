package io.github.kelari.annotation.v3.enums;

import java.io.Serializable;

/**
 * Enumerates the possible locations of a parameter as defined by the OpenAPI Specification.
 *
 * <p>
 * These values correspond to the <b>in</b> field of a Parameter Object, which determines
 * where the parameter value is expected to be found in an API request.
 * </p>
 *
 * <ul>
 *     <li>{@link #QUERY} – Parameter is appended to the URL as a query string.</li>
 *     <li>{@link #HEADER} – Parameter is passed in the HTTP header.</li>
 *     <li>{@link #PATH} – Parameter is part of the path segment of the URL and is always required.</li>
 *     <li>{@link #COOKIE} – Parameter is passed in a cookie.</li>
 *     <li>{@link #DEFAULT} – Represents an unspecified or default behavior.</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#parameterObject">
 *      Parameter Object (OpenAPI Specification)</a>
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum ParameterIn implements Serializable, Comparable<ParameterIn> {
    COOKIE,
    DEFAULT,
    HEADER,
    PATH,
    QUERY
}
