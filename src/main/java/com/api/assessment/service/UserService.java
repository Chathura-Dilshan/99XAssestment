package com.api.assessment.service;

import com.api.assessment.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    ResponseEntity createUser(User user);

    User findByUsernameAndStatus(String username, Integer statusSeq);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
