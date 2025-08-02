package com.example.menumaker.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private Soup soup;
    private MainCourse mainCourse;
    private Dessert dessert;
    private Beverage beverage;

}
