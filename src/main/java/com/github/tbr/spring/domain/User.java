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
    @Size(min = 5, max = 16, message = "{userName.size}")
    @Column(name = "user_name")
    private String userName;

    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(min = 2, max = 30, message = "{firstName.size}")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30, message = "{lastName.size}")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "{email.empty}")
    @Email(message = "{email.valid}")
    @Column(name = "email")
    private String email;

    @NotNull(message = "{single.empty}")
    @Column(name = "single")
    Boolean single;
}
