package io.github.kelari.core.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.kelari.model.v3.OpenAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;

/**
 * Implementation of {@link OpenApiCacheStore} that uses the local file system
 * under {@code ~/.kelari/cache/} to store OpenAPI definitions in JSON format.
 *
 * <p>This implementation adopts a functional programming style for improved
 * readability, composability, and error handling.</p>
 *
 * <p>All cache entries are stored as JSON files identified by a safe version
 * of the cache key. Caching supports both read and write operations with logging.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class FileSystemOpenApiCacheStore implements OpenApiCacheStore {

    private static final Logger log = LoggerFactory.getLogger(FileSystemOpenApiCacheStore.class);
    private final ObjectMapper objectMapper;

    /**
     * Constructs a new {@code FileSystemOpenApiCacheStore} using the provided Jackson {@link ObjectMapper}.
     *
     * @param objectMapper the object mapper used for serializing and deserializing OpenAPI definitions
     */
    public FileSystemOpenApiCacheStore(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Saves the given {@link OpenAPI} object to the file system cache using the specified cache key.
     * If the parent directories do not exist, they will be created.
     *
     * @param cacheKey a unique identifier used to name the cache file
     * @param openAPI  the OpenAPI specification to be cached
     */
    @Override
    public void save(String cacheKey, OpenAPI openAPI) {
        Optional.of(cacheKey)
                .map(this::getCacheFilePath)
                .ifPresent(path -> {
                    try {
                        Files.createDirectories(path.getParent());
                        objectMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), openAPI);
                        log.info("OpenAPI cached to local file: {}", path);
                    } catch (Exception e) {
                        log.warn("Failed to save OpenAPI to local cache: {}", e.getMessage());
                    }
                });
    }

    /**
     * Loads a previously cached {@link OpenAPI} object from the file system based on the provided cache key.
     *
     * @param cacheKey a unique identifier used to locate the cache file
     * @return an {@link Optional} containing the loaded {@link OpenAPI} instance if successful, or empty otherwise
     */
    @Override
    public Optional<OpenAPI> load(String cacheKey) {
        return Optional.of(cacheKey)
                .map(this::getCacheFilePath)
                .filter(Files::exists)
                .flatMap(safeReadFromFile());
    }

    /**
     * Returns a function that safely reads and deserializes an OpenAPI object from a file path.
     * If any exception occurs, it returns an empty Optional.
     *
     * @return a function from {@link Path} to {@link Optional} of {@link OpenAPI}
     */
    private Function<Path, Optional<OpenAPI>> safeReadFromFile() {
        return path -> {
            try {
                OpenAPI openAPI = objectMapper.readValue(path.toFile(), OpenAPI.class);
                log.info("OpenAPI loaded from local cache: {}", path);
                return Optional.of(openAPI);
            } catch (Exception e) {
                log.warn("Failed to load OpenAPI from local cache: {}", e.getMessage());
                return Optional.empty();
            }
        };
    }

    /**
     * Converts a cache key into a safe file system path within the {@code ~/.kelari/cache/} directory.
     * Illegal characters are replaced with underscores and a {@code .json} suffix is added.
     *
     * @param cacheKey the key used to identify the cache entry
     * @return a {@link Path} object pointing to the expected location of the cached file
     */
    private Path getCacheFilePath(String cacheKey) {
        String safeName = cacheKey.replaceAll("[^a-zA-Z0-9-_\\.]", "_") + ".json";
        return Paths.get(System.getProperty("user.home"), ".kelari", "cache", safeName);
    }
}