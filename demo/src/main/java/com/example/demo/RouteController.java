package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RouteController {
    
    // @Autowired
    // private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private UnapprovedAccountService unapprovedAccountService;
    // @GetMapping("/user")
    // public String getUser() {
    //     return "hello user";
    // }
    // @GetMapping("/admin")
    // public String getAdmin() {
    //     return "hello admin";
    // }
    
    // @GetMapping("/approve")
    // public void approveUser(){
    //     customUserDetailsService.setApproved();    
    // }
    // @PostMapping("/approve/users")
    // @PostMapping("/approve/users")
    // public void approveUsers(){
        
    //     // for(UnapprovedAccount user:users){
            
    //     //     customUserDetailsService.setApproved(user.getUser_id());
    //     // }
    //     // return users;
    //     // System.out.print(approve);
    // } 
    @GetMapping("/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response){
        // Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        // if (auth != null){      
        //    new SecurityContextLogoutHandler().logout(request, response, auth);  
        // }  
         return "redirect:/";  
    }
    //  @PreAuthorize("hasRole('user')")
    @GetMapping("/users")
    public String getAll(Model model){
        List<UnapprovedAccount> accounts = unapprovedAccountService.getAll();
        // List<User> users =  customUserDetailsService.getAll();
        Form form =new Form();
        model.addAttribute("accounts", accounts);
        model.addAttribute("form", form);

        return "userList" ;
    }
}
