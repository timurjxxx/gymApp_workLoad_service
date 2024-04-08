package com.gypApp_workLoadService.activemq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gypApp_workLoadService.dto.TrainerWorkloadRequest;
import com.gypApp_workLoadService.service.TrainerWorkloadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TrainerWorkloadConsumer {
    private final TrainerWorkloadService trainerWorkloadService;
    private final ObjectMapper objectMapper;

    @JmsListener(destination = "${activemq.queue}")
    public void receiveMessage(String  jsonRequest) throws JsonProcessingException {
        log.info("Received trainer workload message: {}", jsonRequest);
        TrainerWorkloadRequest request = objectMapper.readValue(jsonRequest, TrainerWorkloadRequest.class);
        trainerWorkloadService.updateWorkload(request);
    }

}
