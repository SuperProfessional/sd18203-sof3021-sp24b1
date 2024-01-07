package com.example.demo.controllers;

import com.example.demo.dto.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class LoginController {

    @GetMapping("login")
    public String getLoginForm(Model model) {
        String name = "NguyenHoan";
        model.addAttribute("name", name);
        return "login";
    }

    @PostMapping("login")
    public String login(
            Model model,
            LoginRequest request
    ) {
        if (Objects.nonNull(request.getEmail())) {
            model.addAttribute("name", request.getEmail());
        }
        return "login";
    }
}
