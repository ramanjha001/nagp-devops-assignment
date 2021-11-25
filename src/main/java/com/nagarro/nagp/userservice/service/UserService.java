package com.nagarro.nagp.userservice.service;

import com.nagarro.nagp.userservice.exception.UserException;
import com.nagarro.nagp.userservice.model.User;
import com.nagarro.nagp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User fetchUser(Integer userId) throws UserException {

        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new UserException("No user exist for userId: " + userId);
        }

        return user.get();
    }
}
