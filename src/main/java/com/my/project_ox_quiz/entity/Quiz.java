package com.my.project_ox_quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String writer;
    private boolean yes;
    private boolean no;
}
