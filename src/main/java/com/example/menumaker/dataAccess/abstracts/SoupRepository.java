package com.example.menumaker.dataAccess.abstracts;

import com.example.menumaker.entities.concretes.Soup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoupRepository extends JpaRepository<Soup,Integer> {
}
