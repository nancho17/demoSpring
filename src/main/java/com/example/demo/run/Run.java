package com.example.demo.run;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer kilometers,
        Location location
        ) {

}
