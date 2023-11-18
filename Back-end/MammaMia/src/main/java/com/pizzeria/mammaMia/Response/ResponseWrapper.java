package com.pizzeria.mammaMia.Response;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private T data;
    private String message;

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.message = message;
    }
}
