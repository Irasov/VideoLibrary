package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.entity.Movie;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JdbcMovieDaoTest {
    static DaoFactory daoFactory;
    static MovieDao movieDao;

    @Before
    public void setUp() throws Exception {
        System.out.println("Start test!");
        daoFactory = DaoFactory.getInstance();
        daoFactory.beginTx();
        movieDao = daoFactory.newMovieDao();
    }

    @After
    public void tearDown() throws Exception {
        daoFactory.endTx();
        daoFactory.close();
        System.out.println("End test!");
    }

    @Test
    public void goodFindByIdListMember() throws Exception {
        Movie movie = movieDao.findById(1L);
        assertThat(movie.getMembers().size(), is(3));
    }
}