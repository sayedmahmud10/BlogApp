package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnapprovedAccountRepository  extends JpaRepository<UnapprovedAccount,Long>{
    
    Optional<UnapprovedAccount> findByUsername(String text);
     Optional<UnapprovedAccount> findByUserId(Long id);


}
