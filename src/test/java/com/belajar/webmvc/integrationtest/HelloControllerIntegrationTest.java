package com.belajar.webmvc.integrationtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIntegrationTest {

    @LocalServerPort
    private Integer port;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void helloGuest() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class);
        String body = forEntity.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals("hello Guest", body.trim());
    }

    @Test
    void hName() {
        String name = "Dedi";
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + port + "/hello?name=" + name, String.class);
        String body = forEntity.getBody();
        Assertions.assertNotNull(body);
        Assertions.assertEquals("hello " + name, body.trim());
    }
}
