package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.BeverageService;
import com.example.menumaker.business.requests.CreateBeverageRequest;
import com.example.menumaker.business.responses.GetAllBeveragesResponse;
import com.example.menumaker.business.responses.GetRandomBeverageResponse;
import com.example.menumaker.core.utilities.mappers.ModelMapperService;
import com.example.menumaker.dataAccess.abstracts.BeverageRepository;
import com.example.menumaker.entities.concretes.Beverage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class BeverageManager implements BeverageService {

    private BeverageRepository beverageRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void addBeverage(CreateBeverageRequest createBeverage) {
        Beverage newBeverage = this.modelMapperService.forRequest().map(createBeverage,Beverage.class);
        this.beverageRepository.save(newBeverage);
    }

    @Override
    public List<GetAllBeveragesResponse> getAllBeverages() {
        List<Beverage> beverages = this.beverageRepository.findAll();
        List<GetAllBeveragesResponse> beveragesResponses = beverages.stream().map(beverage ->
                this.modelMapperService.forResponse().map(beverage,GetAllBeveragesResponse.class)).toList();

        return beveragesResponses;
    }

    @Override
    public GetRandomBeverageResponse getBeverage(){
        List<Beverage> beverages = beverageRepository.findAll();
        Random random = new Random();
        int number = random.nextInt(beverages.size());
        Beverage beverage = beverages.get(number);
        GetRandomBeverageResponse beverageResponse =  this.modelMapperService.forResponse().map(beverage,GetRandomBeverageResponse.class);
        return beverageResponse;
    }


}
