package com.example.menumaker.entities.concretes;

import com.example.menumaker.business.responses.GetRandomBeverageResponse;
import com.example.menumaker.business.responses.GetRandomDessertResponse;
import com.example.menumaker.business.responses.GetRandomMainCourseResponse;
import com.example.menumaker.business.responses.GetRandomSoupResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private GetRandomSoupResponse getRandomSoupResponse;
    private GetRandomMainCourseResponse getRandomMainCourseResponse;
    private GetRandomDessertResponse getRandomDessertResponse;
    private GetRandomBeverageResponse getRandomBeverageResponse;

}
