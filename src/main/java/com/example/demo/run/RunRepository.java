package com.example.demo.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private List<Run> runsList = new ArrayList<>();

    List<Run> findAll(){
        return runsList;
    }

    Optional<Run> findById(Integer id){
        return runsList.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void create(Run run){
        runsList.add(run);
    }

    void update(Run run,Integer id){
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()){
            runsList.set(runsList.indexOf(existingRun.get()),run);
        }
    }

    void delete(Integer id){
        runsList.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init(){
        runsList.add(new Run(
                1,
                "Monday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                3,
                Location.INDOOR
        ));
        runsList.add(new Run(
                2,
                "Tuesday Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(60, ChronoUnit.MINUTES),
                2,
                Location.INDOOR
        ));

    }

}
