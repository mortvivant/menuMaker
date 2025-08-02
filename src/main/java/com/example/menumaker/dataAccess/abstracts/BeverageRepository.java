package com.example.menumaker.dataAccess.abstracts;

import com.example.menumaker.entities.concretes.Beverage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageRepository extends JpaRepository<Beverage,Integer> {
}
