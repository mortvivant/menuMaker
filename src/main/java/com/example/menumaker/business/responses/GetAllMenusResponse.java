package com.example.menumaker.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllMenusResponse {
    private String soupName;
    private String mainCourseName;
    private String dessertName;
    private String beverageName;
    private int user_Id;
}
