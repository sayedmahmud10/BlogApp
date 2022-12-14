package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long>{

 Optional<Post> findByText(String text);
 List<Post> findByApproved(int approved);
}