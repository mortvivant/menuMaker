package com.example.menumaker.dataAccess.abstracts;

import com.example.menumaker.entities.concretes.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Integer> {
}
