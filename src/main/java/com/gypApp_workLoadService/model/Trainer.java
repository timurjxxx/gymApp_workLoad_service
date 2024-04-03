package com.gypApp_workLoadService.model;

import lombok.*;

import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trainer {

    private String username;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private Map<String, Integer> trainingSummaryDuration;

    @Override
    public String toString() {
        return firstName +" "+lastName+" "+ trainingSummaryDuration;
    }
}



