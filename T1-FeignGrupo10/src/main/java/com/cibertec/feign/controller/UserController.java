package com.cibertec.feign.controller;

import com.cibertec.feign.dto.UserPlaceHolder;
import com.cibertec.feign.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserPlaceHolder> getUsers() {
        return userService.getUsersIdImpar();
    }

    @GetMapping("/posts")
    public List<UserPlaceHolder> getPosts() {
        return userService.getPostsUserIdParIdImpar();
    }
}
