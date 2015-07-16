package com.epam.irasov.videolibrary.dao;

import java.sql.Connection;
import java.sql.SQLException;

public  class JdbcDaoFactory extends DaoFactory {

    private final Connection connection;

    public JdbcDaoFactory(Connection connection) {
        this.connection = connection;
    }
    @Override
    public MovieDao newMovieDao() {
        return new JdbcMovieDao(connection);
    }

    @Override
    void beginTx() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    void endTx() {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    void rollbackTx() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
