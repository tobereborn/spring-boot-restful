package com.github.tbr.spring.repository;


import com.github.tbr.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByname(@Param(value = "name") String name);

}
