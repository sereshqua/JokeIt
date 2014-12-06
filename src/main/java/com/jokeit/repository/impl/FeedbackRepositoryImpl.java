package com.jokeit.repository.impl;

import com.jokeit.domain.Feedback;
import com.jokeit.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FeedbackRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Feedback feedback, Integer jokeId) {
        String sql = "INSERT INTO feedback (assessment, comment, joke_id) VALUE (?, ?, ?)";
        jdbcTemplate.update(sql, feedback.getAssessment(), feedback.getComment(), jokeId);
    }
}