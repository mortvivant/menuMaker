package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.MenuService;
import com.example.menumaker.business.requests.CreateMenuRequest;
import com.example.menumaker.business.requests.UpdateMenuRequest;
import com.example.menumaker.business.responses.GetAllMenusResponse;
import com.example.menumaker.business.responses.GetByIdMenuResponse;
import com.example.menumaker.core.utilities.mappers.ModelMapperService;
import com.example.menumaker.dataAccess.abstracts.MenuRepository;
import com.example.menumaker.entities.concretes.Menu;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuManager implements MenuService {

    private MenuRepository menuRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllMenusResponse> getMenus() {
        List<GetAllMenusResponse> menus = this.menuRepository.findAll().stream().map(menu ->
                this.modelMapperService.forResponse().map(menu,GetAllMenusResponse.class)).toList();
        return menus;
    }

    @Override
    public void addMenu(CreateMenuRequest createMenuRequest) {
        Menu menu = this.modelMapperService.forRequest().map(createMenuRequest,Menu.class);
        this.menuRepository.save(menu);
    }

    @Override
    public void updateMenu(UpdateMenuRequest updateMenuRequest) {
        Menu menu = this.modelMapperService.forRequest().map(updateMenuRequest,Menu.class);
        this.menuRepository.save(menu);
    }

    @Override
    public List<GetByIdMenuResponse> getMenuById(int id) {
        List<GetByIdMenuResponse> menus = this.menuRepository.findAll().stream().filter(menu->menu.getId()==id).map(menu->
                this.modelMapperService.forResponse().map(menu,GetByIdMenuResponse.class)).toList();
        return menus;
    }
}
