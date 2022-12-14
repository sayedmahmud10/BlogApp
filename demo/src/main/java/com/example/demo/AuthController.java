package com.example.demo;

import java.security.Principal;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import antlr.collections.List;
import ch.qos.logback.core.Context;


@RequestMapping(value = "registration")
@Controller


public class AuthController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(){
    
        return "index";
    }

    @GetMapping
    public String showRegistrationForm(@ModelAttribute User user, Model model) {
    
    model.addAttribute("user", user);
    return "registration";
    }
    @PostMapping
    public String save( User user) {
            // user.setPassword(passwordEncoder.encode(user.getPassword()));
            customUserDetailsService.save(user);            
            return "redirect:/index";
        }

    // private final UserRepository userRepository;
    // public AuthController(UserRepository userRepository){
    //     this.userRepository = userRepository ;
    // }

    // @GetMapping("/signup")
    // public String showSignUpForm(User user) {
    //     return "add-user";
    // }

    // @PostMapping("/adduser")
    // public String addUser(@Valid User user, BindingResult result, Model model) {
    //     if (result.hasErrors()) {
    //         return "add-user";
    //     }
        
    //     userRepository.save(user);
    // }

    // @GetMapping
    // public String showRegistrationForm() {
    //     return "registration";
    // }
}
