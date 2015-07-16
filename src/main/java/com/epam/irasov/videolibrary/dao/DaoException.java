package com.epam.irasov.videolibrary.dao;

import org.apache.log4j.Logger;

import java.sql.SQLException;

public class DaoException extends RuntimeException {
    private static Logger LOGGER = Logger.getLogger(DaoException.class);
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
        LOGGER.info(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.info(message,cause);
    }

    public DaoException(Throwable cause)
    {
        super(cause);
        LOGGER.info(cause);
    }
}
