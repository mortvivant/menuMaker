package com.example.menumaker.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDessertsResponse {
    private int id;
    private String name;
    private int calories;
}
