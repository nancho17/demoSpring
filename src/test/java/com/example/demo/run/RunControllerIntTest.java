package com.example.demo.run;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class RunControllerIntTest {

    @LocalServerPort
    int randomServerPort;

    RestClient restClient;

    @BeforeEach
    void setup(){
        restClient= RestClient.create("http://localhost:"+randomServerPort);
    }

    @Test
    void shouldfindallruns()
    {
        List<Run> runs = restClient.get()
                .uri("/api/runs")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });

        assert runs != null;
        assertEquals(10,runs.size());
    }

}