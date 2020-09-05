package com.services;

import com.config.MyUserDetails;
import com.entities_auth.User;
import com.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

public class CustomUserDetailService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user= userRepository.findByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("Not Found: "+email));
        user.orElseThrow(()->new UsernameNotFoundException("Not Found: "+email));

        return  user.map(MyUserDetails::new).get();
    }

}
