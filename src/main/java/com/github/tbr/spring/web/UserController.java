package com.github.tbr.spring.web;


import com.github.tbr.spring.domain.User;
import com.github.tbr.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

//@RestController
@Slf4j
@Controller
@RequestMapping("/api")
public class UserController {
    private static final String REG_FORM_VIEW = "registry";

    @Autowired
    private UserService userService;

    @GetMapping("/registry")
    public String showRegistrationFrom(Model model) {
        model.addAttribute(new User());
        return REG_FORM_VIEW;
    }

    @PostMapping("/registry")
    public String processRegistration(@Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            log.info("Registry form validation errors: {}", errors);
            return REG_FORM_VIEW;
        }
        userService.save(user);
        return "redirect:/api/" + user.getUserName();
    }

    @GetMapping("/{userName}")
    public String get(
            @PathVariable String userName, Model model) {
        Optional<User> user = userService.getUser(userName);
        if (user.isPresent()) {
            model.addAttribute(user.get());
            return "profile";
        }
        return "error";
    }
}
