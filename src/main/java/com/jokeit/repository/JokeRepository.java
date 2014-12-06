package com.jokeit.repository;

import com.jokeit.domain.Joke;

import java.util.List;

public interface JokeRepository {
    Joke findOne(Integer id);
    List<Joke> findAll();
    void save(Joke joke);
}