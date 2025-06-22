package io.github.kelari.core.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.info.Info;
import org.junit.jupiter.api.*;

import java.nio.file.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link FileSystemOpenApiCacheStore}.
 */
class FileSystemOpenApiCacheStoreTest {

    private static final String CACHE_KEY = "TEST:file-cache-spec";
    private static final Path CACHE_DIR = Paths.get(System.getProperty("user.home"), ".kelari", "cache");

    private FileSystemOpenApiCacheStore cacheStore;
    private OpenAPI testOpenApi;

    @BeforeEach
    void setUp() {
        cacheStore = new FileSystemOpenApiCacheStore(new ObjectMapper());
        testOpenApi = new OpenAPI();
        Info info = new Info();
        info.setTitle("Test API");
        info.setVersion("1.0.0");
        testOpenApi.setInfo(info);
    }

    @Test
    void shouldSaveAndLoadOpenAPI() {
        cacheStore.save(CACHE_KEY, testOpenApi);

        Optional<OpenAPI> result = cacheStore.load(CACHE_KEY);
        assertTrue(result.isPresent(), "Should find OpenAPI in cache");
        assertEquals("Test API", result.get().getInfo().getTitle());
        assertEquals("1.0.0", result.get().getInfo().getVersion());
    }

    @Test
    void shouldReturnEmptyWhenFileNotFound() {
        Optional<OpenAPI> result = cacheStore.load("TEST:non-existent-cache-key");
        assertTrue(result.isEmpty(), "Should return empty Optional when cache file does not exist");
    }

    @AfterEach
    void cleanUp() throws Exception {
        // Clean only the test file to avoid deleting real cached specs
        Files.list(CACHE_DIR)
                .filter(path -> path.getFileName().toString().startsWith("TEST_file-cache-spec"))
                .forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (Exception ignored) {}
                });
    }
}
