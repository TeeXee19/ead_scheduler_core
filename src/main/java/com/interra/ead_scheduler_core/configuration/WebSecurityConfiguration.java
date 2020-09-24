package com.interra.ead_scheduler_core.configuration;

import com.interra.ead_scheduler_core.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ESUserDetailsService userDetailsService;

    @Autowired
    private CustomLoginSuccessHandler successHandler; 
    
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    // @Override
    // public void configure(WebSecurity web) throws Exception {
    //      }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.authorizeRequests().antMatchers("/superreg**","/registration**", "/js/**","/css/**", "/img/**","/webjars/**").permitAll().antMatchers("/adindex**", "/speclist**").hasAnyAuthority("ROLE_ADMIN").anyRequest()
         .authenticated().and().formLogin().loginPage("/login").successHandler(successHandler).permitAll().and().logout()
         .invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         .logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/access-denied");
    }
}
