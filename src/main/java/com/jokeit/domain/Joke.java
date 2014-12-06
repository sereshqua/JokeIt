package com.jokeit.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jokes")
public class Joke {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @OneToMany(targetEntity = Feedback.class, mappedBy = "joke", fetch = FetchType.EAGER)
    private List<Feedback> feedbackList;

    @Transient
    private Double averageAssessment;

    @Transient
    private Integer numberOfComments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Double getAverageAssessment() {
        return averageAssessment;
    }

    public void setAverageAssessment(Double averageAssessment) {
        this.averageAssessment = averageAssessment;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}