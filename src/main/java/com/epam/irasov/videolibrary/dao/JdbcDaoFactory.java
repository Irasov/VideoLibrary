package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.bd.ConnPool;

public  class JdbcDaoFactory extends DaoFactory {

    public JdbcDaoFactory(){
        ConnPool.getInstance();
    }

    @Override
    public MovieDao newMovieDao() {
        return new JdbcMovieDao();
    }
}
