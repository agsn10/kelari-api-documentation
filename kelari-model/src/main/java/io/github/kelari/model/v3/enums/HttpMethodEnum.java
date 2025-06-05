package io.github.kelari.model.v3.enums;

/**
 * Enumeration of HTTP methods supported in OpenAPI PathItem operations.
 * <p>
 * These methods correspond to standard HTTP request methods defined by the
 * <a href="https://datatracker.ietf.org/doc/html/rfc7231">RFC 7231</a> and
 * are used to define the semantics of operations on a given path.
 * </p>
 *
 * <ul>
 *   <li>{@link #GET} - Retrieves data from the server (safe and idempotent).</li>
 *   <li>{@link #POST} - Sends data to the server, often causing a change in state or side effects.</li>
 *   <li>{@link #PUT} - Replaces the current representation of the resource with the request payload.</li>
 *   <li>{@link #PATCH} - Applies partial modifications to a resource.</li>
 *   <li>{@link #DELETE} - Deletes the specified resource.</li>
 *   <li>{@link #HEAD} - Similar to GET but without the response body.</li>
 *   <li>{@link #OPTIONS} - Describes the communication options for the target resource.</li>
 *   <li>{@link #TRACE} - Performs a message loop-back test along the path to the target resource.</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum HttpMethodEnum {
    /** HTTP POST method */
    POST,
    /** HTTP GET method */
    GET,
    /** HTTP PUT method */
    PUT,
    /** HTTP PATCH method */
    PATCH,
    /** HTTP DELETE method */
    DELETE,
    /** HTTP HEAD method */
    HEAD,
    /** HTTP OPTIONS method */
    OPTIONS,
    /** HTTP TRACE method */
    TRACE
}