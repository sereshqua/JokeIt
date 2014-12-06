package com.jokeit.repository.mapper;

import com.jokeit.domain.Joke;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeRowMapper implements RowMapper<Joke> {
    @Override
    public Joke mapRow(ResultSet rs, int rowNum) throws SQLException {
        Joke joke = new Joke();
        joke.setId(rs.getInt("id"));
        joke.setTitle(rs.getString("title"));
        joke.setText(rs.getString("text"));
        joke.setAverageAssessment(rs.getDouble("averageAssessment"));
        joke.setNumberOfComments(rs.getInt("numberOfComments"));
        return joke;
    }
}
