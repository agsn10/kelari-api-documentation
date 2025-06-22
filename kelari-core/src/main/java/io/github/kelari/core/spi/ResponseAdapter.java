package io.github.kelari.core.spi;

import io.github.kelari.core.model.Response;

import java.util.Optional;

public interface ResponseAdapter {
    Optional<Response> adapt(Object possibleResponse);
}
