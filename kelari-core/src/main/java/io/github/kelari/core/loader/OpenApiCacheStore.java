package io.github.kelari.core.loader;

import io.github.kelari.model.v3.OpenAPI;

import java.util.Optional;

/**
 * Interface for storing and retrieving cached OpenAPI definitions.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public interface OpenApiCacheStore {

    /**
     * Stores an OpenAPI definition using a unique cache key.
     *
     * @param cacheKey unique key identifying the entry
     * @param openAPI  the OpenAPI object to cache
     */
    void save(String cacheKey, OpenAPI openAPI);

    /**
     * Loads an OpenAPI definition by its cache key.
     *
     * @param cacheKey unique key identifying the entry
     * @return an Optional containing the cached OpenAPI, or empty if not found
     */
    Optional<OpenAPI> load(String cacheKey);
}

