package com.example.springsecurityapp.controller;

import com.example.springsecurityapp.model.LoginResponse;
import com.example.springsecurityapp.model.MessageResponse;
import com.example.springsecurityapp.model.User;
import com.example.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public MessageResponse register(@RequestBody User user) {
        userService.add(user);
        MessageResponse messageResponse = new MessageResponse("User created");
        return messageResponse;
    }

    @PostMapping("/login")
    public LoginResponse login(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(authentication.getName());
        LoginResponse loginResponse = new LoginResponse(user.getId(), user.getName(), response.getHeader(HttpHeaders.AUTHORIZATION));
        return loginResponse;
    }
}
