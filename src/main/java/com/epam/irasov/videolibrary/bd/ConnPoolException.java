package com.epam.irasov.videolibrary.bd;

public class ConnPoolException extends RuntimeException {
    public ConnPoolException() {
    }

    public ConnPoolException(String message) {
        super(message);
    }

    public ConnPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnPoolException(Throwable cause) {
        super(cause);
    }
}
