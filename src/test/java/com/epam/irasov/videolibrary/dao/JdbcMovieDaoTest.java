package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.entity.Movie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static java.time.format.DateTimeFormatter.ofPattern;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JdbcMovieDaoTest {

    private static AtomicBoolean stop = new AtomicBoolean(false);
    private static DaoFactory daoFactory;
    private static AtomicInteger countMember;

    @Before
    public void setUp() throws Exception {
        countMember = new AtomicInteger();
        daoFactory = DaoFactory.getInstance();
        System.out.println("Start test!");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("End test!");
    }

    @Test
    public void shouldInsert() throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    daoFactory.beginTx();
                    MovieDao movieDao = daoFactory.newMovieDao();
                    Movie.Member member = new Movie.Member(11L,"A","A","A", LocalDate.parse("1982-02-16", ofPattern("yyyy-MM-dd")),"AC");
                    movieDao.insertMember(member);
                    countMember.incrementAndGet();
                }

            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) threads[i] = new Thread(runnable);
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
        assertThat(countMember.get(),is(10000));
        System.out.println("count: " + countMember);
    }

    @Test
    public void shouldTenThreads() throws Exception {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    daoFactory.beginTx();
                    MovieDao movieDao = daoFactory.newMovieDao();
                    countMember.incrementAndGet();
                }

            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) threads[i] = new Thread(runnable);
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
        assertThat(countMember.get(),is(10000));
        System.out.println("count: " + countMember);
    }

    @Test
    public void atomic() throws Exception {
        class MyRunnble implements Runnable {
            @Override
            public void run() {
                for (; ; ) if (stop.get()) break;
                System.out.println("stop");
            }
        }
        MyRunnble myRunnble = new MyRunnble();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) threads[i] = new Thread(myRunnble);
        for (int i = 0; i < 10; i++) threads[i].start();
        Thread.sleep(500);
        stop.set(true);
        System.out.println("Stopped");
    }

    @Test
    public void goodFindByIdListMember() throws Exception {
        daoFactory.beginTx();
        MovieDao movieDao = daoFactory.newMovieDao();
        Movie movie = movieDao.findById(1L);
        assertThat(movie.getMembers().size(), is(3));
        System.out.println("Test is successful! List members object movie has 3 object member");
    }

    @Test
    public void shouldDaoExceptionForNullArgument() throws Exception {
        daoFactory.beginTx();
        MovieDao movieDao = daoFactory.newMovieDao();
        Throwable throwable = null;
        try {
            Movie movie = movieDao.findById(null);
        } catch (Throwable e) {
            throwable = e;
        }
        daoFactory.endTx();
        daoFactory.close();
        assertThat(throwable, instanceOf(DaoException.class));
        System.out.println("Test is successful! DaoExcepton");
    }
}
