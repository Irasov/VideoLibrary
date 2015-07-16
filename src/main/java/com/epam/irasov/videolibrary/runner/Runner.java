package com.epam.irasov.videolibrary.runner;

import com.epam.irasov.videolibrary.dao.DaoFactory;
import com.epam.irasov.videolibrary.dao.MovieDao;
import com.epam.irasov.videolibrary.entity.Movie;
import org.apache.log4j.Logger;

public class Runner {
    private static Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        DaoFactory daoFactory = DaoFactory.getInstance();
        daoFactory.beginTx();
        MovieDao movieDao = daoFactory.newMovieDao();

        Movie movie = movieDao.findById(2L);
        LOGGER.info(movie.toString());
        daoFactory.endTx();
        daoFactory.close();
    }
}
