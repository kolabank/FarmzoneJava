package com.kolabank.FarmZone.Service.User;

import com.kolabank.FarmZone.Model.User;
import com.kolabank.FarmZone.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(()-> new UsernameNotFoundException(username + " not found"));

        return user.map(MyUserDetails::new).get();
    }


}
