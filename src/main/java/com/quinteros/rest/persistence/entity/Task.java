package com.quinteros.rest.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "estimated_d_a")
    private LocalDateTime eta;

    @Column(name = "finished")
    private Boolean finished;

    @Column(name = "task_status")
    private TaskStatus taskStatus;

}
