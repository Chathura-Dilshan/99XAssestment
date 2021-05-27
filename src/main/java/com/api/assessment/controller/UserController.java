package com.api.assessment.controller;

import com.api.assessment.dtos.MasterDataStatus;
import com.api.assessment.entity.User;
import com.api.assessment.repositories.UserRepository;
import com.api.assessment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository,
                          UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping()
    @PreAuthorize("hasAnyRole('login','createUser')")
    public ResponseEntity createUser(@RequestBody User user) {
        return this.userService.createUser(user);

    }
    @PostMapping("/findByUsername")
    @PreAuthorize("hasAnyRole('login','user')")
    public User findByUsername(@RequestBody User user) {
        return this.userService.findByUsernameAndStatus(user.getUsername(), MasterDataStatus.APPROVED.getStatusSeq());
    }


    @GetMapping(produces = "application/json")
    @RequestMapping({"/login"})
    @PreAuthorize("hasAnyRole('login')")
    public User validateLogin(@RequestBody User user)  {
        User user1;
        Optional<User> optionalUser = this.userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (optionalUser.isPresent()) {
            user1 = optionalUser.get();
        } else {
            user1 = null;
        }

        return user1;
    }


}
