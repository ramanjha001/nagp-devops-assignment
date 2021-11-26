package com.nagarro.nagp.userservice.controller;

import com.nagarro.nagp.userservice.exception.UserException;
import com.nagarro.nagp.userservice.model.User;
import com.nagarro.nagp.userservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UserServiceControllerTest {

    @MockBean
    private UserServiceController userServiceController;

    @MockBean
    private UserService userService;

    @BeforeEach
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

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
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

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

}
