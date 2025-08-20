package com.my.project_ox_quiz.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    private String id;
    @Column(nullable = false)
    private String password;
    private boolean status;
    private String info;

}
