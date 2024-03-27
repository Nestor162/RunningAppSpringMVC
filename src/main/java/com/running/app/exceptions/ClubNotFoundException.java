package com.running.app.exceptions;

public class ClubNotFoundException extends RuntimeException {

    public ClubNotFoundException() {
        super();
    }

    public ClubNotFoundException(String message) {
        super(message);
    }

    public ClubNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
