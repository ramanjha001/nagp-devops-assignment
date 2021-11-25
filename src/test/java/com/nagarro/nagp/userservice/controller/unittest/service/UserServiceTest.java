package com.nagarro.nagp.userservice.controller.unittest.service;

import com.nagarro.nagp.userservice.exception.UserException;
import com.nagarro.nagp.userservice.model.User;
import com.nagarro.nagp.userservice.repository.UserRepository;
import com.nagarro.nagp.userservice.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class UserServiceTest {


    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setup() {
        this.userService = new UserService(userRepository);
    }


    @Test
    public void createUserTest() {

        User user = User.builder()
                .userId(1)
                .name("test")
                .salary(100)
                .teamName("test name")
                .build();

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User response = this.userService.createUser(user);

        Assert.assertEquals(user.getName(), response.getName());
    }

    @Test
    public void fetchUserTest() throws UserException {

        Optional<User> user = Optional.of(User.builder()
                .userId(1)
                .name("test")
                .salary(100)
                .teamName("test name")
                .build());

        Mockito.when(userRepository.findById(Mockito.any(Integer.class))).thenReturn(user);

        User response = this.userService.fetchUser(1);

        Assert.assertEquals(user.get().getName(), response.getName());
    }


}
