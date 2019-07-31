package com.credera.CarDealershipApplication.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("employee").password(encoder.encode("employeePassword")).roles("USER")
                .and()
                .withUser("manager").password(encoder.encode("managerPassword")).roles("USER", "ADMIN");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/dealership/cars/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/dealership/cars/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/dealership/customers/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/dealership/customers/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/dealership/sales/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/dealership/sales/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/dealership/employees/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/dealership/employees/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
