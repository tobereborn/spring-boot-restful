package com.github.tbr.spring.web;


import com.github.tbr.spring.domain.User;
import com.github.tbr.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/save")
    public void save(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") int age,
            @RequestParam(name = "isMarried") boolean isMarried) {
        userService.save(name, age, isMarried);
    }

    @GetMapping("/get")
    public Optional<User> get(
            @RequestParam(name = "name") String name) {
        return userService.getUserByNanme(name);
    }
}
