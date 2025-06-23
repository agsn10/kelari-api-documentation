package io.github.kelari.core.generator;

import io.github.kelari.model.v3.Components;
import io.github.kelari.model.v3.OpenAPI;
import io.github.kelari.model.v3.paths.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for the {@link OpenApiGenerator}.
 */
public class OpenApiGeneratorTest {

    private OpenApiGenerator openApiGenerator;

    @BeforeEach
    void setUp() {
        // Set up before each test
        openApiGenerator = new OpenApiGenerator();
    }

    @Test
    void shouldGenerateOpenApiWithFullData() {
        // Arrange
        String title = "Kelari Test API";
        String version = "1.0.0";
        String description = "This is a generated OpenAPI for testing.";
        Paths paths = new Paths();  // You can add paths here if needed
        Components components = new Components();  // Add components like schemas if necessary

        // Act
        OpenAPI openAPI = openApiGenerator.generate(title, version, description, paths, components);

        // Assert
        assertNotNull(openAPI);
        assertEquals(title, openAPI.getInfo().getTitle());
        assertEquals(version, openAPI.getInfo().getVersion());
        assertEquals(description, openAPI.getInfo().getDescription());
        assertNotNull(openAPI.getPaths());
        assertNotNull(openAPI.getComponents());
    }

    @Test
    void shouldGenerateMinimalOpenApi() {
        // Arrange
        String title = "Minimal Test API";
        String version = "1.0.0";

        // Act
        OpenAPI openAPI = openApiGenerator.generateMinimal(title, version);

        // Assert
        assertNotNull(openAPI);
        assertEquals(title, openAPI.getInfo().getTitle());
        assertEquals(version, openAPI.getInfo().getVersion());
        assertNull(openAPI.getInfo().getDescription());
        assertNotNull(openAPI.getPaths());
        assertNotNull(openAPI.getComponents());
    }

    @Test
    void shouldGenerateOpenApiWithoutDescription() {
        // Arrange
        String title = "Test API Without Description";
        String version = "1.0.0";
        Paths paths = new Paths();  // Optionally, you can add paths
        Components components = new Components();  // Optionally, add components

        // Act
        OpenAPI openAPI = openApiGenerator.generate(title, version, null, paths, components);

        // Assert
        assertNotNull(openAPI);
        assertEquals(title, openAPI.getInfo().getTitle());
        assertEquals(version, openAPI.getInfo().getVersion());
        assertNull(openAPI.getInfo().getDescription());
        assertNotNull(openAPI.getPaths());
        assertNotNull(openAPI.getComponents());
    }
}

