package com.gypApp_workLoadService.dao;


import com.gypApp_workLoadService.inmemory.InMemoryStorage;
import com.gypApp_workLoadService.model.Trainer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TrainerWorkloadDAO {

    private final InMemoryStorage storage;

    public void save(Trainer trainerWorkload) {
        log.info("save trainer work load");
        log.info("trainer details {}", trainerWorkload.getUsername());
        log.debug("Work load details {}", trainerWorkload);
        storage.save(trainerWorkload.getUsername(), trainerWorkload);
    }

    public Trainer get(String username) {
        log.info("Get trainer work load by trainer user name {}", username);
        return storage.getByUserName(username);
    }
}
