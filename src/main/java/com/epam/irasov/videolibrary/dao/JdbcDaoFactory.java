package com.epam.irasov.videolibrary.dao;

import java.sql.Connection;

public  class JdbcDaoFactory extends DaoFactory {

    private final Connection connection;

    public JdbcDaoFactory(Connection connection) {
        this.connection = connection;
    }
    @Override
    public MovieDao newMovieDao() {
        return new JdbcMovieDao(connection);
    }
}
