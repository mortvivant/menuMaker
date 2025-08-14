package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.*;
import com.example.menumaker.business.requests.CreateMenuRequest;
import com.example.menumaker.business.requests.UpdateMenuRequest;
import com.example.menumaker.business.responses.GetAllMenusResponse;
import com.example.menumaker.business.responses.GetMenu;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/menus/")
@AllArgsConstructor
public class MenuController {

    private SoupService soupService;
    private MainCourseService mainCourseService;
    private DessertService dessertService;
    private BeverageService beverageService;
    private MenuService menuService;

    @GetMapping("/getMenu")
    public GetMenu getMenu(){
        GetMenu menu = new GetMenu(soupService.getSoup(),mainCourseService.getMainCourse(),dessertService.getDessert(),beverageService.getBeverage());
        return menu;
    }

    @GetMapping("/getmenus")
    public List<GetAllMenusResponse> getMenus(){
        return this.menuService.getMenus();
    }

    @PostMapping("/savemenu")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addMenu(CreateMenuRequest createMenuRequest){
        this.menuService.addMenu(createMenuRequest);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateMenu(UpdateMenuRequest updateMenuRequest){
        this.menuService.updateMenu(updateMenuRequest);
    }
}
