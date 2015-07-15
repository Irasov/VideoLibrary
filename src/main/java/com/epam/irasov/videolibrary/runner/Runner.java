package com.epam.irasov.videolibrary.runner;

import com.epam.irasov.videolibrary.dao.DaoFactory;
import com.epam.irasov.videolibrary.dao.MovieDao;
import com.epam.irasov.videolibrary.entity.Movie;

public class Runner {
    public static void main(String[] args) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        MovieDao movieDao = daoFactory.newMovieDao();
        Movie movie = movieDao.findById(1l);
    }
}
