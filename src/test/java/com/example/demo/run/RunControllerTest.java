package com.example.demo.run;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static java.lang.reflect.Array.get;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(RunController.class)
class RunControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    RunRepository repository;

    private final List<Run> runs = new ArrayList<>();

    @BeforeEach
    void setUp() {
        runs.add(new Run(1,
                "Monday Morning Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOOR));
    }

    @Test
    void shouldFindAllRuns() throws Exception {
        when(repository.findAll()).thenReturn(runs);
        mvc.perform(MockMvcRequestBuilders.get("/api/runs"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(runs.size()));

    }

    @Test
    void shouldFindOneRun() throws Exception {
        Run run = runs.get(0);
        when(repository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(run));
        mvc.perform(MockMvcRequestBuilders.get("/api/runs/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(run.id()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(run.title()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.kilometers").value(run.kilometers()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.location").value(run.location().toString()));
    }

    @Test
    void shouldReturnNotFoundWithInvalidId() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/runs/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateNewRun() throws Exception {
        var run = new Run(null,"test", LocalDateTime.now(),LocalDateTime.now().plusSeconds(3),1, Location.INDOOR);
        mvc.perform(
                post("/api/runs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(run)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldUpdateRun() throws Exception {

        var run = new Run(null,"test", LocalDateTime.now(), LocalDateTime.now().plusSeconds(2),1, Location.INDOOR);
        mvc.perform(put("/api/runs/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(run))
                )
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteRun() throws Exception {
        mvc.perform(delete("/api/runs/1"))
                .andExpect(status().isNoContent());
    }

}