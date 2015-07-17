package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.bd.ConnPool;
import com.epam.irasov.videolibrary.bd.ListConnPool;

import java.sql.Connection;

public abstract  class DaoFactory {

   // private static final ConnPool pool = ConnPool.getInstance();

   // private static final ListConnPool pool; = ListConnPool.initialization();

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
