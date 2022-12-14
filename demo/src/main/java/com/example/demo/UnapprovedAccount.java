package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unapprovedaccounts")
public class UnapprovedAccount {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private Long userId;
    public UnapprovedAccount() {
    }
    public UnapprovedAccount(String username, Long userId) {
        this.username = username;
        this.userId = userId;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getUser_id() {
        return userId;
    }
    public void setUser_id(Long user_id) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "UnapprovedAccount [id=" + id + ", username=" + username + ", userId=" + userId + "]";
    }

}
