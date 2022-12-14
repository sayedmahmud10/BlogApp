package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value ="approve")
@Controller
public class AccountConfirmationController {
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @RequestMapping(
    value = "/users", 
    produces = "application/json", 
    method = {RequestMethod.POST, RequestMethod.PUT})
    public String approveAccounts(@RequestParam("accounts") List<String> list,Model model){
        for(String user:list ){
             customUserDetailsService.setApproved(Long.parseLong(user));
        }
        model.addAttribute("users", list);

        return "index";
    } 
}
