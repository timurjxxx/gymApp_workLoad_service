package com.gypApp_workLoadService.inmemory;

import com.gypApp_workLoadService.model.Trainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InMemoryStorageTest {

    private InMemoryStorage inMemoryStorage;



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        inMemoryStorage = new InMemoryStorage();
    }

    @Test
    public void testSaveAndRetrieve() {
        Trainer trainer = Trainer.builder()
                .username("john_doe")
                .firstName("John")
                .lastName("Doe")
                .isActive(true)
                .trainingSummaryDuration(Collections.singletonMap("Running", 60))
                .build();

        inMemoryStorage.save("john_doe", trainer);

        Trainer retrievedTrainer = inMemoryStorage.getByUserName("john_doe");

        assertEquals(trainer, retrievedTrainer);
    }

    @Test
    public void testGetByUserName_NotFound() {
        Trainer retrievedTrainer = inMemoryStorage.getByUserName("non_existing_username");

        assertNull(retrievedTrainer);
    }

    @Test
    public void testGetByUserName_ExistingUser() {
        Trainer expectedTrainer = Trainer.builder()
                .username("john_doe")
                .firstName("John")
                .lastName("Doe")
                .isActive(true)
                .trainingSummaryDuration(Collections.singletonMap("Running", 60))
                .build();

        inMemoryStorage.save("john_doe", expectedTrainer);

        Trainer actualTrainer = inMemoryStorage.getByUserName("john_doe");

        assertEquals(expectedTrainer, actualTrainer);
    }


}
