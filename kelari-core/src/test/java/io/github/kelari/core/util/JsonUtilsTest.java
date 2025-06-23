package io.github.kelari.core.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilsTest {

    static final String SIMPLE_JSON = "{\"name\":\"Antonio\",\"age\":42}";
    static final String SIMPLE_YAML = "name: Antonio\nage: 42";

    static final String LIST_JSON = "[\"apple\", \"banana\"]";
    static final String MAP_YAML = "key1: value1\nkey2: value2";

    static class Person {
        public String name;
        public int age;

        // equals e hashCode são importantes para os asserts funcionarem corretamente
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return age == person.age && name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode() + age;
        }
    }

    @Test
    void shouldDeserializeJsonToObject() {
        Person p = JsonUtils.fromJson(SIMPLE_JSON, Person.class);
        assertEquals("Antonio", p.name);
        assertEquals(42, p.age);
    }

    @Test
    void shouldDeserializeJsonToObjectFromStream() {
        ByteArrayInputStream stream = new ByteArrayInputStream(SIMPLE_JSON.getBytes(StandardCharsets.UTF_8));
        Person p = JsonUtils.fromJson(stream, Person.class);
        assertEquals("Antonio", p.name);
        assertEquals(42, p.age);
    }

    @Test
    void shouldDeserializeJsonToMap() {
        Map<String, Object> map = JsonUtils.fromJson(SIMPLE_JSON, new TypeReference<>() {});
        assertEquals("Antonio", map.get("name"));
        assertEquals(42, ((Number) map.get("age")).intValue());
    }

    @Test
    void shouldDeserializeJsonToList() {
        List<String> fruits = JsonUtils.fromJson(LIST_JSON, new TypeReference<>() {});
        assertEquals(List.of("apple", "banana"), fruits);
    }

    @Test
    void shouldSerializeToJson() {
        Person p = new Person();
        p.name = "Antonio";
        p.age = 42;

        String json = JsonUtils.toJson(p);
        assertTrue(json.contains("\"name\""));
        assertTrue(json.contains("\"Antonio\""));
    }

    @Test
    void shouldDeserializeYamlToObject() {
        Person p = JsonUtils.fromYaml(SIMPLE_YAML, Person.class);
        assertEquals("Antonio", p.name);
        assertEquals(42, p.age);
    }

    @Test
    void shouldDeserializeYamlToMap() {
        Map<String, String> map = JsonUtils.fromYaml(MAP_YAML, new TypeReference<>() {});
        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
    }

    @Test
    void shouldSerializeToYaml() {
        Person p = new Person();
        p.name = "Antonio";
        p.age = 42;

        String yaml = JsonUtils.toYaml(p);
        assertTrue(yaml.contains("Antonio"));
        assertTrue(yaml.contains("age: 42"));
    }

    @Test
    void shouldThrowOnInvalidJson() {
        assertThrows(RuntimeException.class, () -> JsonUtils.fromJson("invalid-json", Person.class));
    }

    @Test
    void shouldThrowOnInvalidYaml() {
        assertThrows(RuntimeException.class, () -> JsonUtils.fromYaml("::::", Person.class));
    }
}
