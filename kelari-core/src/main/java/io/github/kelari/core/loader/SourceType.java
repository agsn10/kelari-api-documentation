package io.github.kelari.core.loader;

/**
 * {@code SourceType} defines the supported types of sources
 * from which an OpenAPI specification can be loaded.
 * <p>
 * This is used by {@link OpenApiLoader} to determine how to resolve the input stream
 * from a given location string.
 *
 * <p><strong>Supported types:</strong></p>
 * <ul>
 *   <li>{@link #URL} – loads from a remote URL (e.g., https://example.com/openapi.yaml)</li>
 *   <li>{@link #FILE} – loads from a local file system path (e.g., /home/user/openapi.yaml)</li>
 *   <li>{@link #CLASSPATH} – loads from the classpath resources (e.g., openapi/petstore.yaml)</li>
 * </ul>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public enum SourceType {

    /**
     * Indicates that the OpenAPI specification should be loaded from a remote URL.
     */
    URL,

    /**
     * Indicates that the OpenAPI specification should be loaded from a file on the local filesystem.
     */
    FILE,

    /**
     * Indicates that the OpenAPI specification should be loaded from a resource on the application classpath.
     */
    CLASSPATH
}
