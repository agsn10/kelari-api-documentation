package io.github.kelari.core.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class YamlUtilsTest {

    static final String YAML_SAMPLE = """
        name: Antonio
        age: 42
        active: true
        """;

    static class Person {
        public String name;
        public int age;
        public boolean active;

        // Required for deserialization
        public Person() {}

        public Person(String name, int age, boolean active) {
            this.name = name;
            this.age = age;
            this.active = active;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Person other)) return false;
            return name.equals(other.name) && age == other.age && active == other.active;
        }
    }

    @Test
    void shouldDeserializeFromYamlString() {
        Person person = YamlUtils.fromYaml(YAML_SAMPLE, Person.class);
        assertEquals("Antonio", person.name);
        assertEquals(42, person.age);
        assertTrue(person.active);
    }

    @Test
    void shouldDeserializeFromYamlInputStream() {
        ByteArrayInputStream input = new ByteArrayInputStream(YAML_SAMPLE.getBytes(StandardCharsets.UTF_8));
        Person person = YamlUtils.fromYaml(input, Person.class);
        assertEquals("Antonio", person.name);
    }

    @Test
    void shouldDeserializeGenericMap() {
        Map<String, Object> map = YamlUtils.fromYaml(YAML_SAMPLE, new TypeReference<>() {});
        assertEquals("Antonio", map.get("name"));
        assertEquals(42, map.get("age"));
        assertEquals(true, map.get("active"));
    }

    @Test
    void shouldSerializeToYaml() {
        Person person = new Person("Antonio", 42, true);
        String yaml = YamlUtils.toYaml(person);
        assertTrue(yaml.contains("Antonio"));
        assertTrue(yaml.contains("42"));
        assertTrue(yaml.contains("true"));
    }
}