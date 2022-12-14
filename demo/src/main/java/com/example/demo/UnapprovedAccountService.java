package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnapprovedAccountService {

    @Autowired
    UnapprovedAccountRepository unapprovedUserRepository;

    public java.util.List<UnapprovedAccount> getAll(){
        return unapprovedUserRepository.findAll() ;
    }
    public void save(UnapprovedAccount unapprovedUser){
       unapprovedUserRepository.save(unapprovedUser) ;
    }

}
