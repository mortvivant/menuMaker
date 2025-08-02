package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateBeverageRequest;
import com.example.menumaker.business.requests.CreateDessertRequest;
import com.example.menumaker.business.requests.CreateMainCourseRequest;
import com.example.menumaker.business.requests.CreateSoupRequest;
import com.example.menumaker.business.responses.*;
import com.example.menumaker.entities.concretes.Menu;

import java.util.List;

public interface MenuService {
    Menu getMenu();
    void addSoup(CreateSoupRequest createSoup);
    void addMainCourse(CreateMainCourseRequest createMainCourse);
    void addDessert(CreateDessertRequest createDessert);
    void addBeverage(CreateBeverageRequest createBeverage);
    List<GetAllSoupsResponse> getAllSoups();
    List<GetAllMainCoursesResponse> getAllMainCourse();
    List<GetAllBeveragesResponse> getAllBeverages();
    List<GetAllDessertsResponse> getAllDesserts();
    GetRandomSoupResponse getSoup();
    GetRandomMainCourseResponse getMainCourse();
    GetRandomBeverageResponse getBeverage();
    GetRandomDessertResponse getDessert();
}
