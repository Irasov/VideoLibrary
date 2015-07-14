package com.epam.irasov.videolibrary.dao;

import com.epam.irasov.videolibrary.entity.Movie;

public interface MovieDao {
    Movie findById(Long id);
    void update (Movie movie);
    Movie save (Movie movie);
    Movie merge (Movie movie);
    Movie insert(Movie movie);
    boolean remove(Movie movie);
    void removeByID(Long id);
}
