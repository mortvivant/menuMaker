package com.example.menumaker.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMenuRequest {

    private int id;
    private int soup_Id;
    private int maincourse_Id;
    private int dessert_Id;
    private int beverage_Id;
}
