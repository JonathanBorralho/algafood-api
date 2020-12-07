package com.algaworks.algafood.api;

import java.util.function.Consumer;

import org.openapitools.jackson.nullable.JsonNullable;

public abstract class PatchUtils {
	
	public static <T> void changeIfPresent(JsonNullable<T> nullable, Consumer<T> consumer) {
        if (nullable.isPresent()) {
            consumer.accept(nullable.get());
        }
    }
	
}
