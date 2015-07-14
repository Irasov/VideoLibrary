package com.epam.irasov.videolibrary.dao;

public abstract  class DaoFactory {

    public static DaoFactory getInstance(){
       return new JdbcDaoFactory();
    }

    public abstract MovieDao newMovieDao();
}
