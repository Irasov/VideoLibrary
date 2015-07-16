package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.bd.ConnPool;

import java.sql.Connection;

public abstract  class DaoFactory {
    private static final ConnPool pool = ConnPool.getInstance();

    public static DaoFactory getInstance(){
        Connection connection = pool.getConnection();
        return new JdbcDaoFactory(connection);
    }

    public abstract MovieDao newMovieDao();
}
