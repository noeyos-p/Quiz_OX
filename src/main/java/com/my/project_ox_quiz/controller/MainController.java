package com.my.project_ox_quiz.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"", "/"})
    public String main(HttpSession session, Model model) {
        Object user = session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            // user가 있어야 템플릿에서 user.status 사용 가능
        }
        return "main";
    }
}

