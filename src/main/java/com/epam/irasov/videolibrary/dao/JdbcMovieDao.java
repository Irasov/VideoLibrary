package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class JdbcMovieDao implements MovieDao {
    private final static String FIND_BY_ID = "SELECT ID, NAME, COUNTRY, DATE FROM MOVIE WHERE ID = ?";
    private final static String FIND_BY_ID_MEMBER = "SELECT ID,SECOND_NAME,LAST_NAME,PATRONYMIC,DATE,ROLE FROM MEMBER WHERE ID=ANY(SELECT ID_MEMBER FROM MOVIE_MEMBER WHERE ID_MOVIE=?)";

    private final Connection connection;

    public JdbcMovieDao(Connection connection) {
        this.connection = connection;
    }


    public Movie findById(Long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            int index = 1;
            preparedStatement.setLong(index, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean found = resultSet.next();
            if (!found) return null;
            Movie movie = new Movie();
            movie.setId(resultSet.getLong("id"));
            movie.setName(resultSet.getString("name"));
            movie.setRelease(resultSet.getDate("date"));
            movie.setCountry(resultSet.getString("country"));

            preparedStatement = connection.prepareStatement(FIND_BY_ID_MEMBER);
            preparedStatement.setLong(index, id);
            resultSet = preparedStatement.executeQuery();
            found = resultSet.next();
            if (!found) return null;
            Movie.Member member;
            while (found) {
                member = new Movie.Member();
                member.setId(resultSet.getLong("id"));
                member.setName(resultSet.getString("last_name"));
                member.setSecondName(resultSet.getString("second_name"));
                member.setPatronymic(resultSet.getString("patronymic"));
                member.setDate(resultSet.getDate("date"));
                member.setMemberRole(resultSet.getString("role"));
                movie.addMember(member);
                found = resultSet.next();
            }
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
