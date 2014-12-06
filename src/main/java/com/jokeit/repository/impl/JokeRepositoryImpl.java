package com.jokeit.repository.impl;

import com.jokeit.domain.Joke;
import com.jokeit.repository.JokeRepository;
import com.jokeit.repository.mapper.JokeRowMapper;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Repository
@Transactional
public class JokeRepositoryImpl implements JokeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JokeRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Joke findOne(Integer id) {
        return (Joke) sessionFactory.getCurrentSession().get(Joke.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Joke> findAll() {
        String sql = "SELECT j.*, AVG(feedback.assessment) AS averageAssessment, COUNT(feedback.comment) AS numberOfComments " +
                "FROM jokes j " +
                "  LEFT JOIN feedback ON j.id = feedback.joke_id " +
                "GROUP BY j.id ORDER BY averageAssessment DESC";
        return jdbcTemplate.query(sql, new JokeRowMapper());
    }

    @Override
    public void save(Joke joke) {
        sessionFactory.getCurrentSession().save(joke);
    }
}