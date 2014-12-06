package com.jokeit.repository;

import com.jokeit.domain.Feedback;

public interface FeedbackRepository {
    void save(Feedback feedback, Integer jokeId);
}