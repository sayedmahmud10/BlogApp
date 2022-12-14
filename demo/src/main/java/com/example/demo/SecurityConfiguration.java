package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.DelegatingServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.security.web.server.authentication.logout.WebSessionServerLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
   
        @Autowired
        private CustomUserDetailsService customUserDetailsService;
        
        // @Autowired 
        // private PasswordEncoder passwordEncoder;
    @Bean
    public PasswordEncoder passwordEncoder(){
       // return new BCryptPasswordEncoder();
          return NoOpPasswordEncoder.getInstance();
    }

 

    @Bean
    public DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {      
        DelegatingServerLogoutHandler logoutHandler = new DelegatingServerLogoutHandler(
                new WebSessionServerLogoutHandler(), new SecurityContextServerLogoutHandler()
        );
        httpSecurity.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/registration/**").permitAll()
                .antMatchers("/approve/**").permitAll()
                .antMatchers("/post").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .httpBasic().and()
                .logout()  
                .logoutUrl("/logout")  
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);  
                 httpSecurity.csrf().disable();
                 httpSecurity.headers().frameOptions().disable();
                
                 
    }
   
    
}