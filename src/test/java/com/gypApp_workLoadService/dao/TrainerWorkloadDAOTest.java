package com.gypApp_workLoadService.dao;

import com.gypApp_workLoadService.inmemory.InMemoryStorage;
import com.gypApp_workLoadService.model.Trainer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TrainerWorkloadDAOTest {

    @Mock
    private InMemoryStorage storage;

    @InjectMocks
    private TrainerWorkloadDAO dao;

    public TrainerWorkloadDAOTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSave() {
        Trainer trainer = Trainer.builder()
                .username("john_doe")
                .firstName("John")
                .lastName("Doe")
                .isActive(true)
                .trainingSummaryDuration(new HashMap<>())
                .build();

        dao.save(trainer);

        verify(storage).save("john_doe", trainer);
    }

    @Test
    void testGet() {
        Trainer expectedTrainer = Trainer.builder()
                .username("john_doe")
                .firstName("John")
                .lastName("Doe")
                .isActive(true)
                .trainingSummaryDuration(new HashMap<>())
                .build();

        when(storage.getByUserName("john_doe")).thenReturn(expectedTrainer);

        Trainer actualTrainer = dao.get("john_doe");

        assertEquals(expectedTrainer, actualTrainer);
    }
}
