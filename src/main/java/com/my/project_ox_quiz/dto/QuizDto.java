package com.my.project_ox_quiz.dto;

import com.my.project_ox_quiz.entity.Quiz;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Long id;
    @NotBlank(message = "공백일 수 없습니다.")
    private String question;
    @NotBlank(message = "작성자를 입력하세요.")
    private String writer;
    private boolean yes;
    private boolean no;

    public static QuizDto fromQuizEntity(Quiz quiz) {
        return new QuizDto(
                quiz.getId(),
                quiz.getQuestion(),
                quiz.getWriter(),
                quiz.isYes(),
                quiz.isNo()
        );
    }

    public static Quiz toDto(QuizDto dto) {
        Quiz quiz = new Quiz();
        quiz.setId(dto.getId());
        quiz.setQuestion(dto.getQuestion());
        quiz.setWriter(dto.getWriter());
        quiz.setYes(dto.isYes());
        quiz.setNo(dto.isNo());
        return quiz;
    }
}
