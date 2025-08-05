package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.BeverageService;
import com.example.menumaker.business.abstracts.DessertService;
import com.example.menumaker.business.abstracts.MainCourseService;
import com.example.menumaker.business.abstracts.SoupService;
import com.example.menumaker.business.responses.GetMenu;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/menu/")
@AllArgsConstructor
public class MenuController {

    private SoupService soupService;
    private MainCourseService mainCourseService;
    private DessertService dessertService;
    private BeverageService beverageService;

    @GetMapping("/getMenu")
    public GetMenu getMenu(){
        GetMenu menu = new GetMenu(soupService.getSoup(),mainCourseService.getMainCourse(),dessertService.getDessert(),beverageService.getBeverage());
        return menu;
    }

    @PostMapping("/savemenu")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addMenu(){

    }
}
