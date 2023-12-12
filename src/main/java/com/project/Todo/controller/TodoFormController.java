package com.project.Todo.controller;

import com.project.Todo.model.Todo;
import com.project.Todo.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoFormController {
    @Autowired
    private TodoService service;

    @GetMapping("/createTodo")
    public String showCreateTodo(Todo todo){
        return "create";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid Todo todo,BindingResult result, Model model){
        if (result.hasErrors()) {
            // Log or handle validation errors
            result.getAllErrors().forEach(error -> System.err.println(error.getDefaultMessage()));
            return "create";
        }
        service.save(todo);
        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String editTodoItem(@PathVariable("id") Long id, Model model){
        Todo todo = service.getById(id).orElseThrow();
        model.addAttribute("todo",todo);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id, Model model) {
        try {
            service.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            // Handle the exception, e.g., return an error page or redirect with a message
        }
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String updateTodoItem(@PathVariable Long id, @Valid Todo todo, BindingResult result, Model model) {
        service.save(todo);
        return "redirect:/";
    }


}
