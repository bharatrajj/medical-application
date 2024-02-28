package com.wecp.medicalequipmentandtrackingsystem.service;

import com.wecp.medicalequipmentandtrackingsystem.config.UserInfoUserDetails;
import com.wecp.medicalequipmentandtrackingsystem.entitiy.User;
import com.wecp.medicalequipmentandtrackingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
=======

>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
import java.util.Optional;
@Service
public class UserService implements UserDetailsService {
<<<<<<< HEAD
@Autowired
private UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;
public User registerUser(User user) {
user.setPassword(passwordEncoder.encode(user.getPassword()));
return userRepository.save(user);
}
public User getUserByUsername(String username) {
return userRepository.findByUsername(username).get();
}
@Override
public UserDetails loadUserByUsername(String username) throws
UsernameNotFoundException {
Optional<User>userInfo = userRepository.findByUsername(username);
return userInfo.map(UserInfoUserDetails::new)
.orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
}
}
=======

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
<<<<<<< HEAD
        return repository.findByUsername(username).get();
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = repository.findByUsername(username);
=======
        return userRepository.findByUsername(username).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>userInfo = userRepository.findByUsername(username);
>>>>>>> Pratik
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
>>>>>>> 353971eb3ca117f2e834180caa08f55a069e4998
