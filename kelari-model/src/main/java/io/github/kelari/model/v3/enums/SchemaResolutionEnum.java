package io.github.kelari.model.v3.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SchemaResolutionEnum {

    @JsonProperty("default")
    DEFAULT("default"),
    @JsonProperty("inline")
    INLINE("inline"),
    @JsonProperty("all-of")
    ALL_OF("all-of"),
    @JsonProperty("all-of-ref")
    ALL_OF_REF("all-of-ref");

    private String value;

    SchemaResolutionEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
