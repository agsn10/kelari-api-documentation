package io.github.kelari.core.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.kelari.model.v3.OpenAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    /** Logger instance for debug and error reporting. */
    private static final Logger log = LoggerFactory.getLogger(OpenApiLoader.class);
    /** Mapper for parsing YAML-formatted OpenAPI files. */
    private final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
    /** Mapper for parsing JSON-formatted OpenAPI files. */
    private final ObjectMapper jsonMapper = new ObjectMapper();
    /** In-memory cache to avoid repeated loading and parsing. */
    private final Map<String, OpenAPI> memoryCache = new ConcurrentHashMap<>();
    /** Persistent cache store used as fallback when source loading fails. */
    private final OpenApiCacheStore cacheStore;

    /**
     * Creates a new {@code OpenApiLoader} instance with default file-system-based caching.
     *
     * @return a new instance of {@code OpenApiLoader}
     */
    public static OpenApiLoader newInstance() {
        return new OpenApiLoader(new FileSystemOpenApiCacheStore(new ObjectMapper()));
    }

    /**
     * Constructs the loader with a specific {@link OpenApiCacheStore}.
     *
     * @param cacheStore the fallback/persistent cache store
     */
    private OpenApiLoader(OpenApiCacheStore cacheStore) {
        this.cacheStore = cacheStore;
    }

    /**
     * Loads an OpenAPI specification from the given location and source type.
     * It first checks the in-memory cache, then tries to load from the source,
     * and finally falls back to the persistent cache store if needed.
     *
     * @param location the path, URL, or classpath location of the OpenAPI spec
     * @param type     the type of source (URL, FILE, CLASSPATH)
     * @return the parsed {@link OpenAPI} object
     * @throws RuntimeException if the spec cannot be loaded from source or fallback
     */
    public OpenAPI load(String location, SourceType type) {
        String cacheKey = type.name() + ":" + location;
        if (memoryCache.containsKey(cacheKey)) {
            log.debug("Loaded from in-memory cache: {}", cacheKey);
            return memoryCache.get(cacheKey);
        }
        try {
            OpenAPI openAPI = loadFromSource(location, type);
            memoryCache.put(cacheKey, openAPI);
            cacheStore.save(cacheKey, openAPI);
            return openAPI;
        } catch (Exception ex) {
            log.warn("Could not load from {} [{}]: {}", location, type, ex.getMessage());
            return cacheStore.load(cacheKey)
                    .orElseThrow(() -> new RuntimeException("Failed to load OpenAPI from source or fallback cache."));
        }
    }

    /**
     * Loads and parses the OpenAPI specification from the given source.
     *
     * @param location the input location
     * @param type     the source type
     * @return the parsed {@link OpenAPI}
     * @throws Exception if reading or parsing fails
     */
    private OpenAPI loadFromSource(String location, SourceType type) throws Exception {
        try (InputStream is = getInputStream(location, type)) {
            byte[] content = is.readAllBytes();
            String data = new String(content);
            boolean isJson = data.trim().startsWith("{");
            return isJson
                    ? jsonMapper.readValue(data, OpenAPI.class)
                    : yamlMapper.readValue(data, OpenAPI.class);
        }
    }

    /**
     * Resolves an {@link InputStream} from the specified location and type.
     *
     * @param location the location (URL, file path, or classpath resource)
     * @param type     the type of source
     * @return an {@link InputStream} for the resource
     * @throws Exception if the resource cannot be found or opened
     */
    private InputStream getInputStream(String location, SourceType type) throws Exception {
        return switch (type) {
            case URL -> new URL(location).openStream();
            case FILE -> Files.newInputStream(Paths.get(location));
            case CLASSPATH -> {
                InputStream is = getClass().getClassLoader().getResourceAsStream(location);
                if (is == null) throw new IllegalArgumentException("File not found in classpath: " + location);
                yield is;
            }
        };
    }
}