package com.example.menumaker.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByRequestUserResponse {
    private int id;
    private String name;
    private String password;
}
