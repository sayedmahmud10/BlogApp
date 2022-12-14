package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService  implements UserDetailsService{

    @Autowired
    private UnapprovedAccountRepository unapprovedAccountRepository;
    
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository ;
    }
   

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userRepository
                    .findByUsername(username)
                    .map(CustomUserDetails::new)
                    .orElseThrow(() -> new UsernameNotFoundException("not Valid"))
                    ;
      
    }
    public void save(User user){       
        User savedUser = userRepository.save(user);
        UnapprovedAccount unapprovedUser = new UnapprovedAccount(savedUser.getUsername(),savedUser.getId());
         unapprovedAccountRepository.save(unapprovedUser);

    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public void setApproved(Long id){
       
        Optional <User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setApproved("approved");
            userRepository.save(user);
            Optional <UnapprovedAccount> approvedAccountOptional = unapprovedAccountRepository.findByUserId(user.getId());
            if(approvedAccountOptional.isPresent()){
                UnapprovedAccount approved = approvedAccountOptional.get();
                unapprovedAccountRepository.delete(approved);

            }
        }
    }
}
