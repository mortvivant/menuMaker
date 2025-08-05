package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.DessertService;
import com.example.menumaker.business.requests.CreateDessertRequest;
import com.example.menumaker.business.requests.UpdateDessertRequest;
import com.example.menumaker.business.responses.GetAllDessertsResponse;
import com.example.menumaker.business.responses.GetRandomDessertResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/desserts")
public class DessertController {

    private DessertService dessertService;

    @GetMapping("/getdesserts")
    public List<GetAllDessertsResponse> getAllDesserts(){
        return dessertService.getAllDesserts();
    }

    @GetMapping("/getdessert")
    public GetRandomDessertResponse getDessert(){
        return dessertService.getDessert();
    }

    @PostMapping("/adddessert")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addDessert(CreateDessertRequest createDessertRequest){
        this.dessertService.addDessert(createDessertRequest);
    }

    @PutMapping("/updatedessert")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void updateDessert(UpdateDessertRequest updateDessertRequest){
        this.dessertService.updateDessert(updateDessertRequest);
    }
}
