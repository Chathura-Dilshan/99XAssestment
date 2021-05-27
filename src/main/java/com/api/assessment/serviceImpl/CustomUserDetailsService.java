package com.api.assessment.serviceImpl;

import com.api.assessment.dtos.CustomUserDetails;
import com.api.assessment.entity.User;
import com.api.assessment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser =userRepository.findByUsername(username);
        optionalUser
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
