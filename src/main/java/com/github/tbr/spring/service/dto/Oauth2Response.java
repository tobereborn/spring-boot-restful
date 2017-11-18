package com.github.tbr.spring.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Oauth2Response {
    private String code;
    private String msg;
}
