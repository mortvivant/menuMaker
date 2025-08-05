package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.MenuService;
import com.example.menumaker.business.responses.GetMenu;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MenuManager implements MenuService {

    @Override
    public GetMenu getMenu() {
        return null;
    }

    @Override
    public void addMenu() {

    }
}
