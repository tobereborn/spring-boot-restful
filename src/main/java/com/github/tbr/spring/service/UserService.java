package com.github.tbr.spring.service;


import com.github.tbr.spring.domain.User;
import com.github.tbr.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements UserDetailsService {

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

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserByName(String name) {
        return userRepository.findOneByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRepository.findOneByName(name).map(u ->
                new org.springframework.security.core.userdetails.User(
                        u.getName(),
                        "1234",
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")))
        ).orElseThrow(() -> new UsernameNotFoundException(name));
    }


    public void changePassword() {

    }
}