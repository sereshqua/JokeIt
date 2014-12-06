package com.jokeit.domain;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "assessment")
    private Integer assessment;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "joke_id", referencedColumnName = "id")
    private Joke joke;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssessment() {
        return assessment;
    }

    public void setAssessment(Integer assessment) {
        this.assessment = assessment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Joke getJoke() {
        return joke;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }
}
