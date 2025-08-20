package com.my.project_ox_quiz.controller;

import com.my.project_ox_quiz.dto.QuizDto;
import com.my.project_ox_quiz.entity.Quiz;
import com.my.project_ox_quiz.repository.QuizRepository;
import com.my.project_ox_quiz.service.PlayService;
import com.my.project_ox_quiz.service.QuizService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuizController {
    private final PlayService playService;
    private final QuizService quizService;
    private final QuizRepository quizRepository;

    @GetMapping("/quiz")
    public String quizList(Model model) {
        model.addAttribute("title", "퀴즈 목록을 표시합니다.");
        List<QuizDto> quizList = quizService.quizAllList();
        model.addAttribute("list", quizList);
        return "/quiz/question";
    }


    @GetMapping("/quiz/insert")
    public String quizInsertForm(Model model) {
        model.addAttribute("dto", new QuizDto());
        return "/quiz/insert";
    }

    @PostMapping("/quiz/insert")
    public String quizInsert(@Valid @ModelAttribute("dto") QuizDto dto,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/quiz/insert";
        }

        Quiz quiz = new Quiz();
        quiz.setQuestion(dto.getQuestion());
        if (dto.isYes()) {
            quiz.setYes(true);
            quiz.setNo(false);
        } else {
            quiz.setYes(false);
            quiz.setNo(true);
        }
        quiz.setWriter(dto.getWriter());
        quizRepository.save(quiz);
        return "redirect:/quiz";
    }

    @GetMapping("/quiz/{id}")
    public String quizUpdateForm(@PathVariable Long id, Model model) {
        QuizDto dto = quizService.quizFindOne(id);
        if (ObjectUtils.isEmpty(dto)) {
            return "redirect:/quiz";
        } else {
            model.addAttribute("dto", dto);
            return "/quiz/update";
        }
    }

    @PostMapping("/quiz/update")
    public String quizUpdate(@Valid @ModelAttribute("dto") QuizDto dto,
                             BindingResult bindingResult,
                             @RequestParam("answer") String answer) {
        if (bindingResult.hasErrors()) {
            return "/quiz/update";
        }
        if ("yes".equals(answer)) {
            dto.setYes(true);
            dto.setNo(false);
        } else {
            dto.setYes(false);
            dto.setNo(true);
        }
        System.out.println(dto);
        quizService.quizUpdate(dto);
        return "redirect:/quiz";
    }

    @PostMapping("/quiz/delete")
    public String quizDelete(@RequestParam("id") Long id) {
        quizRepository.deleteById(id);
        return "redirect:/quiz";
    }

    @GetMapping("/quiz/play")
    public String quizPlay(Model model) {
        QuizDto dto = quizService.quizPlay();
        if (dto == null) {
            model.addAttribute("error", "등록된 문제가 없습니다.");
        } else {
            model.addAttribute("dto", dto);
        }
        return "/quiz/play";
    }


    @PostMapping("/quiz/check")
    public String quizCheck(@RequestParam("id") Long id,
                            @RequestParam("answer") String answer,
                            Model model,
                            HttpSession session) {
        QuizDto dto = quizService.quizFindOne(id);

        boolean check = true;

        if ("yes".equals(answer)) {
            check = dto.isYes();
        } else if ("no".equals(answer)) {
            check = dto.isNo();
        }

        String loginId = (String) session.getAttribute("loginId");
        if (loginId != null) {
            playService.savePlay(loginId, check);
        }

        if (check) {
            model.addAttribute("result", "정답입니다.");
        } else {
            model.addAttribute("result", "오답입니다.");
        }
        return "/quiz/check";
    }
}
