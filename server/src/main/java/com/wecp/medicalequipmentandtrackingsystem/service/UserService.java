package com.wecp.medicalequipmentandtrackingsystem.service;
// import com.wecp.medicalequipmentandtrackingsystem.config.UserInfoUserDetails;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.User;
import com.wecp.medicalequipmentandtrackingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository repository;

    private PasswordEncoder passwordEncoder;


    public User registerUser(User user) {
        // Encode the password
        // then save the user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
        return user;
        
    }

    public User getUserByUsername(String username) {
        return repository.findByName(username).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }
    
    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     Optional<User> userInfo = repository.findByName(username);
    //     return userInfo.map(UserInfoUserDetails::new)
    //             .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    // }

}