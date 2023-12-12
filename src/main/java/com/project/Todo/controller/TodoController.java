package com.project.Todo.controller;

import com.project.Todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("todo",service.getALl());
        return mv;
    }

}
