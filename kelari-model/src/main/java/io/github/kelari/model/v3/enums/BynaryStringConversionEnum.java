package io.github.kelari.model.v3.enums;

public enum BynaryStringConversionEnum {

    BINARY_STRING_CONVERSION_BASE64("base64"),
    BINARY_STRING_CONVERSION_DEFAULT_CHARSET("default"),
    BINARY_STRING_CONVERSION_STRING_SCHEMA("string-schema");

    private String value;

    BynaryStringConversionEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}