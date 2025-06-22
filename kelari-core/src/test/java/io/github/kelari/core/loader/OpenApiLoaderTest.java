package io.github.kelari.core.loader;

import io.github.kelari.model.v3.OpenAPI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenApiLoaderTest {

    @Test
    void shouldLoadOpenApiFromClasspath() {
        OpenApiLoader loader = OpenApiLoader.newInstance();
        OpenAPI openAPI = loader.load("openapi.yaml", SourceType.CLASSPATH);

        assertNotNull(openAPI);
        assertEquals("Swagger Petstore - OpenAPI 3.0", openAPI.getInfo().getTitle());
    }

    @Test
    void shouldThrowIfFileNotFound() {
        OpenApiLoader loader = OpenApiLoader.newInstance();
        Exception exception = assertThrows(RuntimeException.class, () ->
                loader.load("not-found.yaml", SourceType.CLASSPATH)
        );

        String message = exception.getMessage();
        assertTrue(message.contains("File not found"));
    }

    @Test
    void shouldUseCacheOnSecondCall() {
        OpenApiLoader loader = OpenApiLoader.newInstance();

        OpenAPI first = loader.load("openapi.yaml", SourceType.CLASSPATH);
        OpenAPI second = loader.load("openapi.yaml", SourceType.CLASSPATH);

        assertSame(first, second); // Ensure same object is returned from cache
    }
}
