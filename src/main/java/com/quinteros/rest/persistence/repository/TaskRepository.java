package com.quinteros.rest.persistence.repository;

import com.quinteros.rest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
