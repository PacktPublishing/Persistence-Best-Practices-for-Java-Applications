package dev.a4j.mastering.data;

import java.util.function.Supplier;

public enum EdgeLabels implements Supplier<String> {
    IS("is");

    private final String value;

    EdgeLabels(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }
}
