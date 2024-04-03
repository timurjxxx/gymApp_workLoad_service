package com.gypApp_workLoadService.inmemory;

import com.gypApp_workLoadService.model.Trainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class InMemoryStorage {

    private final Map<String, Trainer> storage = new HashMap<>();


    public void save(String username, Trainer workload) {

        log.info("Added work load for trainer {} : {}",username, workload);
        storage.put(username, workload);
        log.info("Trainer memory storage {}", storage);

    }

    public Trainer getByUserName(String username) {
        log.info("Find trainer by username {}", username);
        return storage.get(username);
    }


}
