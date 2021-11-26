package com.nagarro.nagp.userservice.controller;

import com.nagarro.nagp.userservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "classpath:application-integration-test.yml")
public class UserServiceControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate testRestTemplate = new TestRestTemplate();


    @Test
    public void createAndFetchUserIntegrationTest() {

        User userRequest = User.builder()
                .name("test")
                .salary(100)
                .teamName("test name")
                .build();

        //create user

        String postUrl = "http://localhost:" + port + "/users/create";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));

        HttpEntity httpEntity = new HttpEntity(userRequest, headers);

        ResponseEntity<User> createResponseEntity = this.testRestTemplate.postForEntity(postUrl, httpEntity, User.class);

        assertNotNull(createResponseEntity);
        assertEquals(createResponseEntity.getStatusCode(), HttpStatus.CREATED);
        assertEquals(createResponseEntity.getBody().getName(), "test");

        User createdUser = createResponseEntity.getBody();

        //fetch user

        String fetchUrl = "http://localhost:" + port + "/users/" + createdUser.getUserId();

        ResponseEntity<User> fetchResponseEntity = this.testRestTemplate.getForEntity(fetchUrl, User.class);

        assertNotNull(fetchResponseEntity);
        assertEquals(fetchResponseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(fetchResponseEntity.getBody().getTeamName(), "test name");
    }


}
