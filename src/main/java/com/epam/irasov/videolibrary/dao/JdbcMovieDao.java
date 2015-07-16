package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JdbcMovieDao implements MovieDao {
    private final static String FIND_BY_ID="SELECT ID_MOVIE, NAME, COUNTRY, DATE FROM MOVIE WHERE ID_MOVIE = ?";

    private final Connection connection;

    public JdbcMovieDao(Connection connection) {
        this.connection = connection;
    }


    public Movie findById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            int index= 1;
            preparedStatement.setLong(index,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean found =resultSet.next();
            if(!found) return null;
            Movie movie = new Movie();
            movie.setId(resultSet.getLong("ID_MOVIE"));
            movie.setName(resultSet.getString("NAME"));
            movie.setRelease(resultSet.getDate("DATE"));
            movie.setCountry(resultSet.getString("COUNTRY"));
            return movie;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
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
