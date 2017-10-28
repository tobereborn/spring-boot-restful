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

    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(String userName) {
        return userRepository.findOneByUserName(userName);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findOneByUserName(userName).map(u ->
                new org.springframework.security.core.userdetails.User(
                        u.getUserName(),
                        u.getPassword(),
                        Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")))
        ).orElseThrow(() -> new UsernameNotFoundException(userName));
    }


    public void changePassword() {

    }
}