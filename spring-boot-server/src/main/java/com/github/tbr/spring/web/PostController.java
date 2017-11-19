package com.github.tbr.spring.web;


import com.github.tbr.spring.domain.Post;
import com.github.tbr.spring.monitor.Log;
import com.github.tbr.spring.service.PostService;
import com.github.tbr.spring.service.SpiServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private SpiServiceManager spiServiceManager;

    @Log
    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute(postService.getAllPosts());
        return "posts";
    }


    @GetMapping(value = "/all", produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping(value = "/producers", produces = {"application/json;charset=UTF-8"})
    public
    @ResponseBody
    List<String> getAllProducers() {
        return spiServiceManager.showAllProducers();

    }

    @GetMapping("/pages")
    public String getPostPages(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size, Model model) {
        model.addAttribute("pages", postService.getPageablePosts(page, size));
        return "pages";
    }
}
