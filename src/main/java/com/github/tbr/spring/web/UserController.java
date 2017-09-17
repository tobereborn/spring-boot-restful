package com.github.tbr.spring.web;


import com.github.tbr.spring.domain.User;
import com.github.tbr.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/user")
    public List<User> user() {
        User user = new User();
        user.setName("Jack");
        user.setAge(25);
        userRepository.save(user);
        return userRepository.findByName("Jack");
    }
}
