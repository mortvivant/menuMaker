package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.SoupService;
import com.example.menumaker.business.requests.CreateSoupRequest;
import com.example.menumaker.business.responses.GetAllSoupsResponse;
import com.example.menumaker.business.responses.GetRandomSoupResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/soups")
@AllArgsConstructor
public class SoupController {

    private SoupService soupService;

    @GetMapping("/getsoups")
    public List<GetAllSoupsResponse> getAllSoups(){
        return soupService.getAllSoups();
    }

    @GetMapping("/getsoup")
    public GetRandomSoupResponse getSoup(){
        return soupService.getSoup();
    }

    @PostMapping("/addsoup")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addSoup(CreateSoupRequest createSoupRequest){
        this.soupService.addSoup(createSoupRequest);
    }
}
