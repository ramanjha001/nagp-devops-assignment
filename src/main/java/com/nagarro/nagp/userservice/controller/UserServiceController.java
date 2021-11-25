package com.nagarro.nagp.userservice.controller;

import com.nagarro.nagp.userservice.exception.UserException;
import com.nagarro.nagp.userservice.model.User;
import com.nagarro.nagp.userservice.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserServiceController {


    private UserService userService;

    @Autowired
    public UserServiceController(@NonNull UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createdUser = this.userService.createUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> fetchUser(@PathVariable Integer userId) throws UserException {

        User createdUser = this.userService.fetchUser(userId);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }


}
