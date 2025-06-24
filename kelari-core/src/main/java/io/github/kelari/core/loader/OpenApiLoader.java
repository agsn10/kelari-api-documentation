package io.github.kelari.core.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.kelari.model.v3.OpenAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static io.github.kelari.core.loader.OpenApiSourceHelper.loadFromSource;

/**
 * {@code OpenApiLoader} is a utility class responsible for loading OpenAPI specification files
 * in JSON or YAML format from various sources (such as URL, file system, or classpath)
 * and converting them into instances of the {@link OpenAPI} model.
 * <p>
 * This loader supports integration with the {@code kelari-model} module.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public class OpenApiLoader {

    private static final Logger log = LoggerFactory.getLogger(OpenApiLoader.class);
    private final Map<String, OpenAPI> memoryCache = new ConcurrentHashMap<>();
    private final OpenApiCacheStore cacheStore;

    /**
     * Creates a new {@code OpenApiLoader} instance with default file-system-based caching.
     *
     * @return a new instance of {@code OpenApiLoader}
     */
    public static OpenApiLoader newInstance() {
        return new OpenApiLoader(new FileSystemOpenApiCacheStore(new ObjectMapper()));
    }

    private OpenApiLoader(OpenApiCacheStore cacheStore) {
        this.cacheStore = cacheStore;
    }

    /**
     * Loads an OpenAPI specification from the given location and source type.
     * It uses in-memory caching and falls back to a persistent cache store on failure.
     *
     * @param location the path, URL, or classpath location of the OpenAPI spec
     * @param type     the type of source (URL, FILE, CLASSPATH)
     * @return the parsed {@link OpenAPI} object
     * @throws RuntimeException if the spec cannot be loaded from source or fallback
     */
    public OpenAPI load(String location, SourceType type) {
        String cacheKey = type.name() + ":" + location;
        return memoryCache.computeIfAbsent(cacheKey, key -> tryLoad(location, type, key));
    }

    private OpenAPI tryLoad(String location, SourceType type, String cacheKey) {
        try {
            OpenAPI openAPI = loadFromSource(location, type);
            cacheStore.save(cacheKey, openAPI);
            return openAPI;
        } catch (Exception ex) {
            log.warn("Could not load from {} [{}]: {}", location, type, ex.getMessage());
            return cacheStore.load(cacheKey)
                    .orElseThrow(() -> new RuntimeException("Failed to load OpenAPI from source or fallback cache."));
        }
    }
}