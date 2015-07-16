package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcMovieDao implements MovieDao {
    private  final static String RESULT_ID="id";
    private  final static String RESULT_DATE="date";
    private  final static String RESULT_NAME="name";
    private  final static String RESULT_COUNTRY="country";
    private  final static String RESULT_LAST_NAME="last_name";
    private  final static String RESULT_SECOND_NAME="second_name";
    private  final static String RESULT_PATRONYMIC="patronymic";
    private  final static String RESULT_ROLE="role";
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
            movie.setId(resultSet.getLong(RESULT_ID));
            movie.setName(resultSet.getString(RESULT_NAME));
            movie.setRelease(resultSet.getDate(RESULT_DATE));
            movie.setCountry(resultSet.getString(RESULT_COUNTRY));

            preparedStatement = connection.prepareStatement(FIND_BY_ID_MEMBER);
            preparedStatement.setLong(index, id);
            resultSet = preparedStatement.executeQuery();
            found = resultSet.next();
            if (!found) return null;
            Movie.Member member;
            while (found) {
                member = new Movie.Member();
                member.setId(resultSet.getLong(RESULT_ID));
                member.setName(resultSet.getString(RESULT_LAST_NAME));
                member.setSecondName(resultSet.getString(RESULT_SECOND_NAME));
                member.setPatronymic(resultSet.getString(RESULT_PATRONYMIC));
                member.setDate(resultSet.getDate(RESULT_DATE));
                member.setMemberRole(resultSet.getString(RESULT_ROLE));
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
