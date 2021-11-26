package com.nagarro.nagp.userservice.service;

import com.nagarro.nagp.userservice.exception.UserException;
import com.nagarro.nagp.userservice.model.User;
import com.nagarro.nagp.userservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UserServiceTest {


    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
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

        assertEquals(user.getName(), response.getName());
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

        assertEquals(user.get().getName(), response.getName());
    }


}
