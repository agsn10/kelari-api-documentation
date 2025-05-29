package io.github.kelari.annotation.v3.enums;

import java.io.Serializable;

/**
 * Specifies the serialization behavior for parameters of type array or object
 * in OpenAPI. The {@code explode} property determines whether arrays and objects
 * should generate separate parameters for each value or be encoded as a single value.
 *
 * <p>
 * Used primarily in OpenAPI's {@code style} and {@code explode} definitions for query, path, and header parameters.
 * </p>
 *
 * <p><strong>Values:</strong></p>
 * <ul>
 *     <li>{@code DEFAULT} – Use the default behavior as defined by the OpenAPI specification for the given style.</li>
 *     <li>{@code FALSE} – Do not explode the values; encode as a single string.</li>
 *     <li>{@code TRUE} – Explode the values into separate parameters.</li>
 * </ul>
 *
 * <p><strong>Usage Example:</strong></p>
 * <pre>{@code
 * @Parameter(
 *     name = "filter",
 *     explode = Explode.TRUE
 * )
 * }</pre>
 *
 * <p>For more information, refer to the OpenAPI Specification:</p>
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.1.md#parameter-object">OpenAPI Specification - Parameter Object</a>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum Explode implements Serializable, Comparable<Explode> {
    DEFAULT,
    FALSE,
    TRUE
}
