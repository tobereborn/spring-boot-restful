package com.github.tbr.spring.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    @Column(name = "user_name")
    private String userName;


    @NotNull
    @Size(min = 5, max = 25)
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "single")
    Boolean single;
}
