package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.MenuService;
import com.example.menumaker.business.requests.CreateBeverageRequest;
import com.example.menumaker.business.requests.CreateDessertRequest;
import com.example.menumaker.business.requests.CreateMainCourseRequest;
import com.example.menumaker.business.requests.CreateSoupRequest;
import com.example.menumaker.business.responses.GetAllBeveragesResponse;
import com.example.menumaker.business.responses.GetAllDessertsResponse;
import com.example.menumaker.business.responses.GetAllMainCoursesResponse;
import com.example.menumaker.business.responses.GetAllSoupsResponse;
import com.example.menumaker.entities.concretes.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class MenusController {
    private MenuService service;

    @Autowired
    public MenusController(MenuService service) {
        this.service = service;
    }

    @GetMapping("/getmenu")
    public Menu getMenu(){
        return service.getMenu();
    }

    @GetMapping("/getSoups")
    public List<GetAllSoupsResponse> getAllSoups(){
        return service.getAllSoups();
    }

    @GetMapping("/getDeverages")
    public List<GetAllBeveragesResponse> getAllBeverages(){
        return service.getAllBeverages();
    }

    @GetMapping("/getDesserts")
    public List<GetAllDessertsResponse> getAllDesserts(){
        return service.getAllDesserts();
    }

    @GetMapping("/getMaincourses")
    public List<GetAllMainCoursesResponse> getAllMainCourses(){
        return service.getAllMainCourse();
    }

    @PostMapping("/addSoup")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addSoup(CreateSoupRequest createSoupRequest){
        this.service.addSoup(createSoupRequest);
    }

    @PostMapping("/addMaincourse")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addMainCourse(CreateMainCourseRequest createMainCourseRequest){
        this.service.addMainCourse(createMainCourseRequest);
    }

    @PostMapping("/addDessert")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addDessert(CreateDessertRequest createDessertRequest){
        this.service.addDessert(createDessertRequest);
    }

    @PostMapping("/addBeverage")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBeverage(CreateBeverageRequest createBeverageRequest){
        this.service.addBeverage(createBeverageRequest);
    }

}
