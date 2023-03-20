package com.onlineshop.exception;

import lombok.Data;

@Data
public class ProductNotFoundException extends RuntimeException {

    private final String id;

    public ProductNotFoundException(String id) {
        super(String.format("Product id %s not found", id));
        this.id = id;
    }

    public ProductNotFoundException(String id, Throwable exception) {
        super(exception);
        this.id = id;
    }

}
