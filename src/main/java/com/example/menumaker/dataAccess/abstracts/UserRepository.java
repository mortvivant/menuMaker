package com.example.menumaker.dataAccess.abstracts;

import com.example.menumaker.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsUserByUsername(String username);
}
