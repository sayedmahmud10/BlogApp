package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
    @Id @GeneratedValue
    private Long id;
    private String text;
    private int user_id;
    private int approved;

    public Post(){
    }

    public Post(Long id, String text, int user_id, int approved) {
        this.id = id;
        this.text = text;
        this.user_id = user_id;
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getApproved() {
        return approved;
    }

    public void setApproved(int approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", text=" + text + ", user_id=" + user_id + ", approved=" + approved + "]";
    }
    
}
