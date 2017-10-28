package com.github.tbr.spring.repository;


import com.github.tbr.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUserName(String userName);

    List<User> findAll();
}
