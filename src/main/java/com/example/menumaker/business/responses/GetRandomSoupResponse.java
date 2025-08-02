package com.example.menumaker.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRandomSoupResponse {
    private int id;
    private String name;
    private int calories;
}
