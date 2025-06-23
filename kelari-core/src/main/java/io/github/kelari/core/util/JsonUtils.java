package io.github.kelari.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class for JSON and YAML serialization and deserialization.
 * <p>
 * This class provides convenient methods to convert Java objects to and from
 * JSON or YAML strings and streams, using Jackson under the hood.
 * </p>
 *
 * <p><strong>Usage examples:</strong></p>
 * <pre>
 * // Deserialize JSON string
 * MyObject obj = JsonUtils.fromJson("{\"name\":\"Kelari\"}", MyObject.class);
 *
 * // Serialize to YAML string
 * String yaml = JsonUtils.toYaml(obj);
 * </pre>
 *
 * <p>This is a non-instantiable utility class.</p>
 *
 * @author <a href="mailto:agsn10@hotmail.com">Antonio Neto</a> [<()>] – Initial implementation.
 * @since 1.0
 * @copyright 2025 Kelari. All rights reserved.
 *
 */
public final class JsonUtils {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

    private JsonUtils() {
        // Utility class – do not instantiate
    }

    // ——————————————— JSON ———————————————

    /**
     * Deserializes a JSON string into a Java object.
     *
     * @param json  the JSON string
     * @param clazz the target class type
     * @param <T>   the type of the desired object
     * @return the deserialized object
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return JSON_MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing JSON", e);
        }
    }

    /**
     * Deserializes a JSON InputStream into a Java object.
     *
     * @param inputStream the input stream containing JSON
     * @param clazz       the target class type
     * @param <T>         the type of the desired object
     * @return the deserialized object
     */
    public static <T> T fromJson(InputStream inputStream, Class<T> clazz) {
        try {
            return JSON_MAPPER.readValue(inputStream, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON from InputStream", e);
        }
    }

    /**
     * Deserializes a JSON string into a generic Java type.
     *
     * @param json    the JSON string
     * @param typeRef the type reference for the generic type
     * @param <T>     the type of the desired object
     * @return the deserialized object
     */
    public static <T> T fromJson(String json, TypeReference<T> typeRef) {
        try {
            return JSON_MAPPER.readValue(json, typeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing JSON with generic type", e);
        }
    }

    /**
     * Deserializes a JSON InputStream into a generic Java type.
     *
     * @param inputStream the input stream containing JSON
     * @param typeRef     the type reference for the generic type
     * @param <T>         the type of the desired object
     * @return the deserialized object
     */
    public static <T> T fromJson(InputStream inputStream, TypeReference<T> typeRef) {
        try {
            return JSON_MAPPER.readValue(inputStream, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON from InputStream with generic type", e);
        }
    }

    /**
     * Serializes a Java object to a JSON string with pretty-printing.
     *
     * @param obj the object to serialize
     * @return the JSON string representation
     */
    public static String toJson(Object obj) {
        try {
            return JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing to JSON", e);
        }
    }

    // ——————————————— YAML ———————————————

    /**
     * Deserializes a YAML string into a Java object.
     *
     * @param yaml  the YAML string
     * @param clazz the target class type
     * @param <T>   the type of the desired object
     * @return the deserialized object
     */
    public static <T> T fromYaml(String yaml, Class<T> clazz) {
        try {
            return YAML_MAPPER.readValue(yaml, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing YAML", e);
        }
    }

    /**
     * Deserializes a YAML InputStream into a Java object.
     *
     * @param inputStream the input stream containing YAML
     * @param clazz       the target class type
     * @param <T>         the type of the desired object
     * @return the deserialized object
     */
    public static <T> T fromYaml(InputStream inputStream, Class<T> clazz) {
        try {
            return YAML_MAPPER.readValue(inputStream, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Error reading YAML from InputStream", e);
        }
    }

    /**
     * Deserializes a YAML string into a generic Java type.
     *
     * @param yaml    the YAML string
     * @param typeRef the type reference for the generic type
     * @param <T>     the type of the desired object
     * @return the deserialized object
     */
    public static <T> T fromYaml(String yaml, TypeReference<T> typeRef) {
        try {
            return YAML_MAPPER.readValue(yaml, typeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error deserializing YAML with generic type", e);
        }
    }

    /**
     * Deserializes a YAML InputStream into a generic Java type.
     *
     * @param inputStream the input stream containing YAML
     * @param typeRef     the type reference for the generic type
     * @param <T>         the type of the desired object
     * @return the deserialized object
     */
    public static <T> T fromYaml(InputStream inputStream, TypeReference<T> typeRef) {
        try {
            return YAML_MAPPER.readValue(inputStream, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Error reading YAML from InputStream with generic type", e);
        }
    }

    /**
     * Serializes a Java object to a YAML string with pretty-printing.
     *
     * @param obj the object to serialize
     * @return the YAML string representation
     */
    public static String toYaml(Object obj) {
        try {
            return YAML_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing to YAML", e);
        }
    }
}
