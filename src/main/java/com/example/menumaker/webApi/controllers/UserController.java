package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.UserService;
import com.example.menumaker.business.requests.CreateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @PostMapping("/adduser")
    public void addUser(CreateUserRequest createUserRequest){
        this.userService.addUser(createUserRequest);
    }
}
