package com.wecp.medicalequipmentandtrackingsystem.config;

import com.wecp.medicalequipmentandtrackingsystem.jwt.JwtRequestFilter;
import com.wecp.medicalequipmentandtrackingsystem.service.UserService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private JwtRequestFilter authFilter;

    @Bean
    // authentication
    public UserDetailsService userDetailsService() {
        return new UserService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()

                .authorizeRequests()
                .antMatchers("/api/user/login").permitAll()
                .antMatchers("/api/user/register").permitAll()
                .antMatchers("/api/hospital/create").permitAll()
                .antMatchers("/api/hospital/equipment").permitAll()
                .antMatchers("/api/hospital/maintenance/schedule").permitAll()
                .antMatchers("/api/hospital/order").permitAll()
                .antMatchers("/api/hospital/equipment").permitAll()
                .antMatchers("/api/hospital/equipment/**").permitAll()
                .antMatchers("/api/hospitals").permitAll()
                .antMatchers("/api/technician/maintenance").permitAll()
                .antMatchers("/api/technician/maintenance/update/**").permitAll()
                .antMatchers("/api/supplier/orders").permitAll()
                .antMatchers("/api/supplier/order/update/**").permitAll()
                    .antMatchers("/api/**").authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoders() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoders());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    private static class CustomRequestMatcher implements RequestMatcher {
        private String[] patterns;

        public CustomRequestMatcher(String... patterns) {
            this.patterns = patterns;
        }

        @Override
        public boolean matches(HttpServletRequest request) {
            // TODO Auto-generated method stub
            String requestURI = request.getRequestURI();
            for (String pattern : patterns) {
                if (requestURI.matches(pattern)) {
                    return true;
                }
            }
            return false;
        }
    }

}
