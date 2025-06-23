package io.github.kelari.core.generator;

import io.github.kelari.model.v3.Components;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.info.Info;
import io.github.kelari.model.v3.paths.Paths;

/**
 * Responsible for generating an OpenAPI specification programmatically.
 * This can be useful for testing, mocking, or dynamic OpenAPI document creation.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class OpenApiGenerator {

    /**
     * Builds a basic OpenAPI object using provided info, paths and components.
     *
     * @param title       The title of the API
     * @param version     The version of the API
     * @param description The API description
     * @param paths       The set of API paths and operations
     * @param components  The components section (schemas, security, etc.)
     * @return the constructed {@link OpenAPI} instance
     */
    public OpenAPI generate(String title, String version, String description, Paths paths, Components components) {
        OpenAPI openAPI = new OpenAPI();

        Info info = new Info();
        info.setTitle(title);
        info.setVersion(version);
        info.setDescription(description);

        openAPI.setInfo(info);
        openAPI.setPaths(paths);
        openAPI.setComponents(components);

        return openAPI;
    }

    /**
     * Builds a minimal OpenAPI document with just title and version.
     *
     * @param title   The API title
     * @param version The API version
     * @return A basic {@link OpenAPI} instance
     */
    public OpenAPI generateMinimal(String title, String version) {
        return generate(title, version, null, new Paths(), new Components());
    }
}