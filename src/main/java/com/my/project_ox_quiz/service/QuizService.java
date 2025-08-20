package com.my.project_ox_quiz.service;

import com.my.project_ox_quiz.dto.QuizDto;
import com.my.project_ox_quiz.entity.Quiz;
import com.my.project_ox_quiz.repository.QuizRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<QuizDto> quizAllList() {
        List<Quiz> quizList = quizRepository.findAll();
        System.out.println(quizList);
        return quizList
                .stream()
                .map(x -> QuizDto.fromQuizEntity(x))
                .toList();
    }

public QuizDto quizFindOne(Long id) {
        Quiz quiz = quizRepository.findById(id).orElse(null);
        if (ObjectUtils.isEmpty(quiz)) {
            return null;
        } else {
            return QuizDto.fromQuizEntity(quiz);
        }
    }

    public void quizUpdate(@Valid QuizDto dto) {
        Quiz quiz = QuizDto.toDto(dto);
        quizRepository.save(quiz);
    }

    public QuizDto quizPlay() {
        Quiz quiz = quizRepository.quizRandom();
        if (quiz == null) return null;
        return QuizDto.fromQuizEntity(quiz);
    }
}
