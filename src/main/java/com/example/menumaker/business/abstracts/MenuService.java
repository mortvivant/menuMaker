package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateMenuRequest;
import com.example.menumaker.business.requests.UpdateMenuRequest;
import com.example.menumaker.business.responses.GetAllMenusResponse;
import com.example.menumaker.business.responses.GetByIdMenuResponse;

import java.util.List;

public interface MenuService {
    List<GetAllMenusResponse> getMenus();
    void addMenu(CreateMenuRequest createMenuRequest);
    void updateMenu(UpdateMenuRequest updateMenuRequest);
    List<GetByIdMenuResponse> getMenuById(int id);
}
