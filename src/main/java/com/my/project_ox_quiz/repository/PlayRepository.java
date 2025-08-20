package com.my.project_ox_quiz.repository;

import com.my.project_ox_quiz.entity.Play;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayRepository extends JpaRepository<Play, Long> {
    List<Play> findByUser(String user);

    List<Play> findAllByOrderByDateDesc();
}
