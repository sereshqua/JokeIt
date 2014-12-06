package com.jokeit.web.controller;

import com.jokeit.domain.Joke;
import com.jokeit.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JokeController {
    @Autowired
    private JokeRepository jokeRepository;

    @RequestMapping(value = {"/", "/jokes"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.put("jokes", jokeRepository.findAll());
        return "joke/index";
    }

    @RequestMapping(value = "jokes/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, ModelMap model) {
        System.out.println(id);
        model.put("joke", jokeRepository.findOne(id));
        return "joke/show";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String add() {
        return "joke/add";
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public String save(Joke joke) {
        if (checkIfValid(joke)) {
            jokeRepository.save(joke);
            return "redirect:/jokes";
        }
        return "redirect:/admin/add";
    }

    private boolean checkIfValid(Joke joke) {
        if (joke.getTitle() == null || joke.getTitle().equals("")) {
            return false;
        }
        if (joke.getText() == null || joke.getText().equals("")) {
            return false;
        }
        return true;
    }
 }
