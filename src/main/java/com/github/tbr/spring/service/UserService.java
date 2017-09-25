package com.github.tbr.spring.service;


import com.github.tbr.spring.domain.User;
import com.github.tbr.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(String name, int age, boolean isMarried) {
        User user = User
                .builder()
                .name(name)
                .age(age)
                .isMarried(isMarried)
                .build();
        userRepository.save(user);
    }

    public Optional<User> getUserByNanme(String name) {
        return userRepository.findOneByName(name);
    }
}
