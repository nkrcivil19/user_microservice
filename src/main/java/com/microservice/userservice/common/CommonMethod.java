package com.microservice.userservice.common;

import java.util.function.Consumer;

public class CommonMethod {
	
	
	public static <T> void updateIfObjectNotNull(T value, Consumer<T> updater) {
        if (value != null) {
            updater.accept(value);
        }
    }

}
