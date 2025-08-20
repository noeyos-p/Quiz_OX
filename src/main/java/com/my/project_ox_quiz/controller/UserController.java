package com.my.project_ox_quiz.controller;

import com.my.project_ox_quiz.dto.UserDto;
import com.my.project_ox_quiz.entity.Play;
import com.my.project_ox_quiz.repository.PlayRepository;
import com.my.project_ox_quiz.service.PlayService;
import com.my.project_ox_quiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PlayRepository playRepository;
    private final UserService userService;

    @GetMapping("/user/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "/user/signup";
    }

    @PostMapping("/user/signup")
    public String signup(@ModelAttribute("user") UserDto dto) {
        userService.userSave(dto);
        userService.userSignup(dto);
        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String loginPage() {
        return "/user/login";
    }

    @PostMapping("/user/login")
    public String login(UserDto dto, HttpSession session) {
        UserDto loginResult = userService.userFindOne(dto.getId());
        if (ObjectUtils.isEmpty(loginResult)) {
            return "/user/login";
        } else if (dto.getPassword().equals(loginResult.getPassword())) {
            session.setAttribute("loginId", dto.getId());
            session.setAttribute("user", loginResult);
            session.setMaxInactiveInterval(60 * 30);
            return "redirect:/";
        } else {
            return "/user/login";
        }
    }


    @GetMapping("/user/list")
    public String findAllList(Model model) {
        model.addAttribute("title", "유저리스트");
        List<UserDto> list = userService.userFindAll()
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        model.addAttribute("list", list);
        return "/user/list";
    }

    @PostMapping("/admin/delete")
    public String userDelete(@RequestParam("id") String id) {
        userService.userDelete(id);
        return "redirect:/user/list";
    }

    @PostMapping("/admin/update")
    public String usetUpdateForm(@RequestParam("id") String id, Model model) {
        UserDto user = userService.userFindOne(id);
        model.addAttribute("user", user);
        return "/admin/update";
    }

    @PostMapping("/user/update")
    public String userUpdate(@ModelAttribute("user") UserDto user) {
        userService.userUpdate(user);
        return "redirect:/user/list";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "main";
    }

    @PostMapping("/admin/approve")
    public String userApprove(@RequestParam("id") String id) {
        userService.userApprove(id);
        return "redirect:/user/list";
    }

    @PostMapping("/admin/unapprove")
    public String userUnapprove(@RequestParam("id") String id) {
        userService.userUnapprove(id);
        return "redirect:/user/list";
    }

    @GetMapping("/user/info")
    public String myPlayHistory(HttpSession session, Model model) {
        String loginId = (String) session.getAttribute("loginId");
        List<Play> playResult = playRepository.findByUser(loginId);
        model.addAttribute("play", playResult);
        return "/user/info";
    }

    @GetMapping("/admin/info")
    public String allPlays(Model model) {
        List<Play> playResult = playRepository.findAllByOrderByDateDesc();
        model.addAttribute("play", playResult);
        return "/user/adminInfo";
    }
}
