package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateSoupRequest;
import com.example.menumaker.business.responses.GetAllSoupsResponse;
import com.example.menumaker.business.responses.GetRandomSoupResponse;

import java.util.List;

public interface SoupService {
    void addSoup(CreateSoupRequest createSoup);
    GetRandomSoupResponse getSoup();
    List<GetAllSoupsResponse> getAllSoups();
}
