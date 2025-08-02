package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateDessertRequest;
import com.example.menumaker.business.responses.GetAllDessertsResponse;
import com.example.menumaker.business.responses.GetRandomDessertResponse;

import java.util.List;

public interface DessertService {
    void addDessert(CreateDessertRequest createDessert);
    List<GetAllDessertsResponse> getAllDesserts();
    GetRandomDessertResponse getDessert();
}
