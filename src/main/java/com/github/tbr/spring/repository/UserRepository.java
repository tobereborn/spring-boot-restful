package com.github.tbr.spring.repository;


import com.github.tbr.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(@Param(value = "name") String name);

    Optional<User> findOneByName(String name);

}
