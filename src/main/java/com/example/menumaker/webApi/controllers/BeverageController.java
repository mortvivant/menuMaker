package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.BeverageService;
import com.example.menumaker.business.requests.CreateBeverageRequest;
import com.example.menumaker.business.requests.UpdateBeverageRequest;
import com.example.menumaker.business.responses.GetAllBeveragesResponse;
import com.example.menumaker.business.responses.GetRandomBeverageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beverages")
@AllArgsConstructor
public class BeverageController {

    private BeverageService beverageService;

    @GetMapping("/getbeverages")
    public List<GetAllBeveragesResponse> getAllBeverages(){
        return beverageService.getAllBeverages();
    }

    @GetMapping("/getbeverage")
    public GetRandomBeverageResponse getBeverage(){
        return beverageService.getBeverage();
    }

    @PostMapping("/addbeverage")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBeverage(@RequestBody CreateBeverageRequest createBeverageRequest){
        this.beverageService.addBeverage(createBeverageRequest);
    }

    @PutMapping("/updatebeverage")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateBeverage(@RequestBody UpdateBeverageRequest updateBeverageRequest){
        this.beverageService.updateBeverage(updateBeverageRequest);
    }
}
