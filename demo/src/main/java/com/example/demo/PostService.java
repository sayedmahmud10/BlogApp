package com.example.demo;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antlr.collections.List;

@Service
public class PostService  {
    @Autowired
    private PostRepository postRepository;

    public java.util.List<Post> getAll(int approved){
        return postRepository.findByApproved(approved);
    }
    public void save(Post post){
        postRepository.save(post);
    }

}
