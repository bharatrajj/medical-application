package com.wecp.medicalequipmentandtrackingsystem.config;
<<<<<<< HEAD
=======

>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
<<<<<<< HEAD
import
org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class Configurations {
@Bean
public PasswordEncoder passwordEncoder() {
return new BCryptPasswordEncoder();
}
@Bean
public WebMvcConfigurer corsConfigurer() {
return new WebMvcConfigurerAdapter() {
@Override
public void addCorsMappings(CorsRegistry registry) {
registry.addMapping("/**").allowedMethods("GET", "POST",
"PUT", "DELETE").allowedOrigins("*")
.allowedHeaders("*");
}
};
}
=======
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Configurations {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
                        .allowedHeaders("*");
            }
        };
    }
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
}
