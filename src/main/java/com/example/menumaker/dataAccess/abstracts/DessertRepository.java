package com.example.menumaker.dataAccess.abstracts;

import com.example.menumaker.entities.concretes.Dessert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertRepository extends JpaRepository<Dessert,Integer> {
}
