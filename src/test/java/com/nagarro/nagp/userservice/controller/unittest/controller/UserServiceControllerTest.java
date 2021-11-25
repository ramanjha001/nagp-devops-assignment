package com.nagarro.nagp.userservice.controller.unittest.controller;

import com.nagarro.nagp.userservice.controller.UserServiceController;
import com.nagarro.nagp.userservice.exception.UserException;
import com.nagarro.nagp.userservice.model.User;
import com.nagarro.nagp.userservice.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceControllerTest {

    @MockBean
    private UserServiceController userServiceController;

    @MockBean
    private UserService userService;

    @Before
    public void setup() {
        this.userServiceController = new UserServiceController(userService);
    }


    @Test
    public void createUserTest() {

        User user = User.builder()
                .userId(1)
                .name("test")
                .salary(100)
                .teamName("test name")
                .build();

        Mockito.when(userService.createUser(Mockito.any(User.class))).thenReturn(user);

        ResponseEntity<User> responseEntity = this.userServiceController.createUser(user);

        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void fetchUserTest() throws UserException {

        User user = User.builder()
                .userId(1)
                .name("test")
                .salary(100)
                .teamName("test name")
                .build();

        Mockito.when(userService.fetchUser(Mockito.any(Integer.class))).thenReturn(user);

        ResponseEntity<User> responseEntity = this.userServiceController.fetchUser(1);

        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
