package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.entity.Movie;

import java.sql.Connection;

public class JdbcMovieDao implements MovieDao{

    private final Connection connection;

    public JdbcMovieDao(Connection connection){
        this.connection = connection;
    }


    public Movie findById(Long id) {
        return null;
    }

    public void update(Movie movie) {

    }

    public Movie save(Movie movie) {
        return null;
    }

    public Movie merge(Movie movie) {
        return null;
    }

    public Movie insert(Movie movie) {
        return null;
    }

    public boolean remove(Movie movie) {
        return false;
    }

    public void removeByID(Long id) {

    }
}
