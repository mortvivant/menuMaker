package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.SoupService;
import com.example.menumaker.business.requests.CreateSoupRequest;
import com.example.menumaker.business.responses.GetAllSoupsResponse;
import com.example.menumaker.business.responses.GetRandomSoupResponse;
import com.example.menumaker.core.utilities.mappers.ModelMapperService;
import com.example.menumaker.dataAccess.abstracts.SoupRepository;
import com.example.menumaker.entities.concretes.Soup;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@AllArgsConstructor
public class SoupManager implements SoupService {
    private SoupRepository soupRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void addSoup(CreateSoupRequest createSoup) {
        Soup newSoup = this.modelMapperService.forRequest().map(createSoup,Soup.class);
        this.soupRepository.save(newSoup);
    }

    @Override
    public List<GetAllSoupsResponse> getAllSoups() {
        List<Soup> soups = this.soupRepository.findAll();
        List<GetAllSoupsResponse> soupsResponses = soups.stream().map(soup ->
                this.modelMapperService.forResponse().map(soup,GetAllSoupsResponse.class)).toList();

        return soupsResponses;
    }

    @Override
    public GetRandomSoupResponse getSoup(){
        List<Soup> soups = soupRepository.findAll();
        Random random = new Random();
        int number = random.nextInt(soups.size());
        Soup soup = soups.get(number);
        GetRandomSoupResponse soupResponse = this.modelMapperService.forResponse().map(soup,GetRandomSoupResponse.class);
        return soupResponse;
    }







}
