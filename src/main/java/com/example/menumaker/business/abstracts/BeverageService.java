package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateBeverageRequest;
import com.example.menumaker.business.responses.GetAllBeveragesResponse;
import com.example.menumaker.business.responses.GetRandomBeverageResponse;

import java.util.List;

public interface BeverageService {
    void addBeverage(CreateBeverageRequest createBeverage);
    List<GetAllBeveragesResponse> getAllBeverages();
    GetRandomBeverageResponse getBeverage();
}
