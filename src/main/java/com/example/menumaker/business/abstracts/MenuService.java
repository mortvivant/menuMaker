package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.responses.GetMenu;

public interface MenuService {
    GetMenu getMenu();
    void addMenu();
}
