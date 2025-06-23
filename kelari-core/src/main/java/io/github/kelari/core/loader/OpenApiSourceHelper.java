package io.github.kelari.core.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.github.kelari.model.v3.OpenAPI;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * {@code OpenApiSourceHelper} is a utility class responsible for loading and
 * deserializing OpenAPI specification files in JSON or YAML format from
 * various sources, including URLs, the local file system, and the classpath.
 *
 * <p>It uses Jackson's {@link ObjectMapper} to parse the contents and automatically
 * detects whether the data is in JSON or YAML format based on the first character.</p>
 *
 * <p>This class is stateless and not intended to be instantiated.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 */
public class OpenApiSourceHelper {

    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private OpenApiSourceHelper() {
        // Utility class; should not be instantiated.
    }

    /**
     * Loads and parses an OpenAPI specification from a given source (URL, file, or classpath).
     *
     * @param location the source path (e.g., a URL string, absolute file path, or classpath resource name)
     * @param type     the source type: {@link SourceType#URL}, {@link SourceType#FILE}, or {@link SourceType#CLASSPATH}
     * @return an instance of {@link OpenAPI} representing the loaded specification
     * @throws Exception if reading or parsing the source fails
     */
    public static OpenAPI loadFromSource(String location, SourceType type) throws Exception {
        try (InputStream is = getInputStream(location, type)) {
            String data = new String(is.readAllBytes()).trim();
            return data.startsWith("{")
                    ? JSON_MAPPER.readValue(data, OpenAPI.class)
                    : YAML_MAPPER.readValue(data, OpenAPI.class);
        }
    }

    /**
     * Resolves an {@link InputStream} from the given source location and type.
     *
     * @param location the source (e.g., URL, file system path, or classpath resource)
     * @param type     the source type: {@link SourceType#URL}, {@link SourceType#FILE}, or {@link SourceType#CLASSPATH}
     * @return an {@link InputStream} pointing to the resolved resource
     * @throws Exception if the resource cannot be found or opened
     */
    public static InputStream getInputStream(String location, SourceType type) throws Exception {
        return switch (type) {
            case URL -> new URL(location).openStream();
            case FILE -> Files.newInputStream(Paths.get(location));
            case CLASSPATH -> {
                InputStream is = OpenApiSourceHelper.class.getClassLoader().getResourceAsStream(location);
                if (is == null)
                    throw new IllegalArgumentException("File not found in classpath: " + location);
                yield is;
            }
        };
    }
}
