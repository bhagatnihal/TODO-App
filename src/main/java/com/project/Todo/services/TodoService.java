package com.project.Todo.services;

import com.project.Todo.model.Todo;
import com.project.Todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> getALl(){
        return repository.findAll();
    }

    public Optional<Todo> getById(Long id){
        return repository.findById(id);
    }

    public Todo save(Todo todo){
        return repository.save(todo);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
