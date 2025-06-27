
package com.example;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFullFlow() {
        User user = new User("Integration Test User");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<User> postResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/users", request, User.class);
        User savedUser = postResponse.getBody();

        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("Integration Test User");

        ResponseEntity<User> getResponse = restTemplate.getForEntity(
                "http://localhost:" + port + "/users/" + savedUser.getId(), User.class);

        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody().getName()).isEqualTo("Integration Test User");
    }
}
