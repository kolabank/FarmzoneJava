package com.kolabank.FarmZone.Service.User;

import com.kolabank.FarmZone.Model.User;
import com.kolabank.FarmZone.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        System.out.println(hashedPassword);
        return userRepository.save(user);
    }

    public User findByUsername (String username){
       return userRepository.findByUsername(username).get();
    }
}
