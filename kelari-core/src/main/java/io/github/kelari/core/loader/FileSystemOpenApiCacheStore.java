package io.github.kelari.core.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.kelari.model.v3.OpenAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Implementation of {@link OpenApiCacheStore} that uses the local file system
 * under {@code ~/.kelari/cache/} to store OpenAPI definitions in JSON format.
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public class FileSystemOpenApiCacheStore implements OpenApiCacheStore {

    private static final Logger log = LoggerFactory.getLogger(FileSystemOpenApiCacheStore.class);
    private final ObjectMapper objectMapper;

    public FileSystemOpenApiCacheStore(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void save(String cacheKey, OpenAPI openAPI) {
        try {
            Path filePath = getCacheFilePath(cacheKey);
            Files.createDirectories(filePath.getParent());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(filePath.toFile(), openAPI);
            log.info("OpenAPI cached to local file: {}", filePath);
        } catch (Exception e) {
            log.warn("Failed to save OpenAPI to local cache: {}", e.getMessage());
        }
    }

    @Override
    public Optional<OpenAPI> load(String cacheKey) {
        try {
            Path filePath = getCacheFilePath(cacheKey);
            if (!Files.exists(filePath)) {
                log.warn("Cache file not found: {}", filePath);
                return Optional.empty();
            }

            OpenAPI openAPI = objectMapper.readValue(filePath.toFile(), OpenAPI.class);
            log.info("OpenAPI loaded from local cache: {}", filePath);
            return Optional.of(openAPI);
        } catch (Exception e) {
            log.warn("Failed to load OpenAPI from local cache: {}", e.getMessage());
            return Optional.empty();
        }
    }

    private Path getCacheFilePath(String cacheKey) {
        String safeName = cacheKey.replaceAll("[^a-zA-Z0-9-_\\.]", "_") + ".json";
        return Paths.get(System.getProperty("user.home"), ".kelari", "cache", safeName);
    }
}

