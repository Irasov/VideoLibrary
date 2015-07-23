package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieDao {
    Movie findById(Long id);
    void update (Movie movie);
    Movie save (Movie movie);
    Movie merge (Movie movie);
    List<Movie.Member> selectMember(int countMovie);
    Movie.Member insertMember(Movie.Member member);
    boolean remove(Movie movie);
    void removeByDate(LocalDate date);
}
