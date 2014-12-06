package com.jokeit.web.controller;

import com.jokeit.domain.Feedback;
import com.jokeit.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class FeedbackController {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @RequestMapping(value = "/{jokeId}/feedback", method = RequestMethod.POST)
    public String add(@PathVariable Integer jokeId, Feedback feedback) {
        if (feedback.getComment() != null && !feedback.getComment().isEmpty()) {
            feedbackRepository.save(feedback, jokeId);
        }
        return "redirect:/jokes/" + jokeId;
    }
}
