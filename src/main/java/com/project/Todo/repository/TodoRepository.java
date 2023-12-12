package com.project.Todo.repository;

import com.project.Todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
