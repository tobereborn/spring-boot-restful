package com.github.tbr.spring.web;


import com.github.tbr.spring.domain.User;
import com.github.tbr.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RestController
@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registry")
    public String showRegistrationFrom() {
        return "registry";
    }

    @PostMapping("/registry")
    public String processRegistration(User user) {
        userService.save(user);
        return "redirect:/api/" + user.getName();
    }

    @GetMapping("/{name}")
    public String get(
            @PathVariable String name, Model model) {
        Optional<User> user = userService.getUserByName(name);
        if (user.isPresent()) {
            model.addAttribute(user.get());
            return "profile";
        }
        return "error";
    }
}
