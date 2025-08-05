package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.DessertService;
import com.example.menumaker.business.requests.CreateDessertRequest;
import com.example.menumaker.business.requests.UpdateDessertRequest;
import com.example.menumaker.business.responses.GetAllDessertsResponse;
import com.example.menumaker.business.responses.GetRandomDessertResponse;
import com.example.menumaker.core.utilities.mappers.ModelMapperService;
import com.example.menumaker.dataAccess.abstracts.DessertRepository;
import com.example.menumaker.entities.concretes.Dessert;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class DessertManager implements DessertService {

    private DessertRepository dessertRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void addDessert(CreateDessertRequest createDessert) {
        Dessert newDessert = this.modelMapperService.forRequest().map(createDessert,Dessert.class);
        this.dessertRepository.save(newDessert);
    }

    @Override
    public List<GetAllDessertsResponse> getAllDesserts() {
        List<Dessert> desserts = this.dessertRepository.findAll();
        List<GetAllDessertsResponse> dessertsResponses = desserts.stream().map(dessert ->
                this.modelMapperService.forResponse().map(dessert,GetAllDessertsResponse.class)).toList();

        return dessertsResponses;
    }

    @Override
    public GetRandomDessertResponse getDessert(){
        List<Dessert> desserts = dessertRepository.findAll();
        Random random = new Random();
        int number = random.nextInt(desserts.size());
        Dessert dessert = desserts.get(number);
        GetRandomDessertResponse dessertResponse = this.modelMapperService.forResponse().map(dessert,GetRandomDessertResponse.class);
        return dessertResponse;
    }

    @Override
    public void updateDessert(UpdateDessertRequest updateDessertRequest) {
        Dessert dessert = this.modelMapperService.forRequest().map(updateDessertRequest,Dessert.class);
        this.dessertRepository.save(dessert);
    }
}
