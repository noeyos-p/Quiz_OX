package com.my.project_ox_quiz.repository;

import com.my.project_ox_quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query(value = "SELECT * FROM quiz ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quiz quizRandom();

}
