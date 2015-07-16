package com.epam.irasov.videolibrary.bd;

import org.apache.log4j.Logger;

public class ConnPoolException extends RuntimeException {
    private static Logger LOGGER = Logger.getLogger(ConnPoolException.class);
    public ConnPoolException() {
    }

    public ConnPoolException(String message) {
        super(message);
        LOGGER.info(message);
    }

    public ConnPoolException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.info(message, cause);
    }

    public ConnPoolException(Throwable cause) {
        super(cause);
        LOGGER.info(cause);
    }
}
