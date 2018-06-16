package com.denisgl.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {

    public String message;

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis() + ": " +  message;
    }

    public ProductNotFoundException() {
        this("Product is not available!");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
