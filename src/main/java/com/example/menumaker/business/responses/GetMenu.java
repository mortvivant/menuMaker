package com.example.menumaker.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMenu {
    GetRandomSoupResponse getRandomSoupResponse;
    GetRandomMainCourseResponse getRandomMainCourseResponse;
    GetRandomDessertResponse getRandomDessertResponse;
    GetRandomBeverageResponse getRandomBeverageResponse;
}
