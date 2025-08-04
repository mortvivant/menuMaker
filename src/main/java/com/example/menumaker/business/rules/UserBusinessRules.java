package com.example.menumaker.business.rules;

import com.example.menumaker.dataAccess.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private UserRepository userRepository;

    public void checkIfUsernameExists(String name){
        if(userRepository.existsUserByUsername(name)){
            throw new DataIntegrityViolationException("Username already exist.");
        }
    }

    public void checkInvalidLog(boolean invalidLog ){
        if(invalidLog){
            throw new RuntimeException("Log is unsuccessful");
        }
        else {
            return;
        }
    }
}
