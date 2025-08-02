package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.MenuService;
import com.example.menumaker.business.requests.CreateBeverageRequest;
import com.example.menumaker.business.requests.CreateDessertRequest;
import com.example.menumaker.business.requests.CreateMainCourseRequest;
import com.example.menumaker.business.requests.CreateSoupRequest;
import com.example.menumaker.business.responses.GetAllBeveragesResponse;
import com.example.menumaker.business.responses.GetAllDessertsResponse;
import com.example.menumaker.business.responses.GetAllMainCoursesResponse;
import com.example.menumaker.business.responses.GetAllSoupsResponse;
import com.example.menumaker.core.utilities.mappers.ModelMapperService;
import com.example.menumaker.dataAccess.abstracts.BeverageRepository;
import com.example.menumaker.dataAccess.abstracts.DessertRepository;
import com.example.menumaker.dataAccess.abstracts.MainCourseRepository;
import com.example.menumaker.dataAccess.abstracts.SoupRepository;
import com.example.menumaker.entities.concretes.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class MenuManager implements MenuService {
    private SoupRepository soupRepository;
    private MainCourseRepository mainCourseRepository;
    private DessertRepository dessertRepository;
    private BeverageRepository beverageRepository;
    private ModelMapperService modelMapperService;
    private Random random = new Random();

    public MenuManager(SoupRepository soupRepository, MainCourseRepository mainCourseRepository, DessertRepository dessertRepository, BeverageRepository beverageRepository, ModelMapperService modelMapperService) {
        this.soupRepository = soupRepository;
        this.mainCourseRepository = mainCourseRepository;
        this.dessertRepository = dessertRepository;
        this.beverageRepository = beverageRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Menu getMenu() {
        return new Menu(getSoup(),getMainCourse(),getDessert(),getBeverage());
    }

    @Override
    public void addSoup(CreateSoupRequest createSoup) {
        Soup newSoup = this.modelMapperService.forRequest().map(createSoup,Soup.class);
        this.soupRepository.save(newSoup);
    }

    @Override
    public void addMainCourse(CreateMainCourseRequest createMainCourse) {
        MainCourse newMaincourse = this.modelMapperService.forRequest().map(createMainCourse,MainCourse.class);
        this.mainCourseRepository.save(newMaincourse);
    }

    @Override
    public void addDessert(CreateDessertRequest createDessert) {
        Dessert newDessert = this.modelMapperService.forRequest().map(createDessert,Dessert.class);
        this.dessertRepository.save(newDessert);
    }

    @Override
    public void addBeverage(CreateBeverageRequest createBeverage) {
        Beverage newBeverage = this.modelMapperService.forRequest().map(createBeverage,Beverage.class);
        this.beverageRepository.save(newBeverage);
    }

    @Override
    public List<GetAllSoupsResponse> getAllSoups() {
        List<Soup> soups = this.soupRepository.findAll();
        List<GetAllSoupsResponse> soupsResponses = soups.stream().map(soup ->
                this.modelMapperService.forResponse().map(soup,GetAllSoupsResponse.class)).toList();

        return soupsResponses;
    }

    @Override
    public List<GetAllMainCoursesResponse> getAllMainCourse() {
        List<MainCourse> mainCourses = this.mainCourseRepository.findAll();
        List<GetAllMainCoursesResponse> mainCoursesResponses = mainCourses.stream().map(mainCourse ->
                this.modelMapperService.forResponse().map(mainCourse,GetAllMainCoursesResponse.class)).toList();

        return mainCoursesResponses;
    }

    @Override
    public List<GetAllBeveragesResponse> getAllBeverages() {
        List<Beverage> beverages = this.beverageRepository.findAll();
        List<GetAllBeveragesResponse> beveragesResponses = beverages.stream().map(beverage ->
                this.modelMapperService.forResponse().map(beverage,GetAllBeveragesResponse.class)).toList();

        return beveragesResponses;
    }

    @Override
    public List<GetAllDessertsResponse> getAllDesserts() {
        List<Dessert> desserts = this.dessertRepository.findAll();
        List<GetAllDessertsResponse> dessertsResponses = desserts.stream().map(dessert ->
                this.modelMapperService.forResponse().map(dessert,GetAllDessertsResponse.class)).toList();

        return dessertsResponses;
    }

    private Soup getSoup(){
        List<Soup> soups = soupRepository.findAll();
        int number = random.nextInt(soups.size());
        return soups.get(number);
    }

    private MainCourse getMainCourse(){
        List<MainCourse> mainCourses = mainCourseRepository.findAll();
        int number = random.nextInt(mainCourses.size());
        return mainCourses.get(number);
    }

    private Dessert getDessert(){
        List<Dessert> desserts = dessertRepository.findAll();
        int number = random.nextInt(desserts.size());
        return desserts.get(number);
    }

    private Beverage getBeverage(){
        List<Beverage> beverages = beverageRepository.findAll();
        int number = random.nextInt(beverages.size());
        return beverages.get(number);
    }


}
