package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.bd.ConnectionPool;

import java.sql.Connection;

public abstract  class DaoFactory {

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    public static DaoFactory getInstance(){
        Connection connection = pool.takeConnection();
        return new JdbcDaoFactory(connection);
    }

    public abstract MovieDao newMovieDao();

    public abstract void beginTx();

    public abstract void endTx();

    public abstract void rollbackTx();

    public abstract void close();
}
