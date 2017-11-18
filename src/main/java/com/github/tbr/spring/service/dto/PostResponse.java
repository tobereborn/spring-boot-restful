package com.github.tbr.spring.service.dto;

import com.github.tbr.spring.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostResponse {
    List<Post> posts;
}
