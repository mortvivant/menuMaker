package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.BeverageService;
import com.example.menumaker.business.abstracts.DessertService;
import com.example.menumaker.business.abstracts.MainCourseService;
import com.example.menumaker.business.abstracts.SoupService;
import com.example.menumaker.business.requests.CreateBeverageRequest;
import com.example.menumaker.business.requests.CreateDessertRequest;
import com.example.menumaker.business.requests.CreateMainCourseRequest;
import com.example.menumaker.business.requests.CreateSoupRequest;
import com.example.menumaker.business.responses.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/menu/")
@AllArgsConstructor
public class MenuController {
    private SoupService soupService;
    private MainCourseService mainCourseService;
    private DessertService dessertService;
    private BeverageService beverageService;

//
//    @GetMapping("/getmenu")
//    public Menu getMenu(){
//        return service.getMenu();
//    }

    @GetMapping("/getsoups")
    public List<GetAllSoupsResponse> getAllSoups(){
        return soupService.getAllSoups();
    }

    @GetMapping("/getbeverages")
    public List<GetAllBeveragesResponse> getAllBeverages(){
        return beverageService.getAllBeverages();
    }

    @GetMapping("/getdesserts")
    public List<GetAllDessertsResponse> getAllDesserts(){
        return dessertService.getAllDesserts();
    }

    @GetMapping("/getmaincourses")
    public List<GetAllMainCoursesResponse> getAllMainCourses(){
        return mainCourseService.getAllMainCourse();
    }

    @GetMapping("/getsoup")
    public GetRandomSoupResponse getSoup(){
        return soupService.getSoup();
    }

    @GetMapping("/getmaincourse")
    public GetRandomMainCourseResponse getMainCourse(){
        return mainCourseService.getMainCourse();
    }

    @GetMapping("/getdessert")
    public GetRandomDessertResponse getDessert(){
        return dessertService.getDessert();
    }

    @GetMapping("/getbeverage")
    public GetRandomBeverageResponse getBeverage(){
        return beverageService.getBeverage();
    }

    @PostMapping("/addsoup")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addSoup(CreateSoupRequest createSoupRequest){
        this.soupService.addSoup(createSoupRequest);
    }

    @PostMapping("/addmaincourse")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addMainCourse(CreateMainCourseRequest createMainCourseRequest){
        this.mainCourseService.addMainCourse(createMainCourseRequest);
    }

    @PostMapping("/adddessert")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addDessert(CreateDessertRequest createDessertRequest){
        this.dessertService.addDessert(createDessertRequest);
    }

    @PostMapping("/addbeverage")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBeverage(CreateBeverageRequest createBeverageRequest){
        this.beverageService.addBeverage(createBeverageRequest);
    }

}
