package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "post")
@Controller

public class PostController {
    
    @Autowired
    private PostService postService;

    // @PreAuthorize("hasRole('user')")
    @GetMapping
    public String getAll(Model model) {
         List<Post> posts =  postService.getAll(Constants.PostIsApproved);
        model.addAttribute("posts", posts);
        return "postList" ;
    }
    @GetMapping("/add")
    public String showRegistrationForm(@ModelAttribute Post post, Model model) {
    
    model.addAttribute("post", post);
    return "post";
    }
    @PostMapping
    public String save( Post post) {
            postService.save(post);
            return "redirect:/index";
        }
}
