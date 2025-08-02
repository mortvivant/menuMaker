package com.example.menumaker.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    Soup soup;
    MainCourse mainCourse;
    Dessert dessert;
    Beverage beverage;

}
