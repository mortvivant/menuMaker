package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.UserService;
import com.example.menumaker.business.requests.CreateUserRequest;
import com.example.menumaker.business.requests.UserLogRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @PostMapping("/adduser")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addUser(CreateUserRequest createUserRequest){
        this.userService.addUser(createUserRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void logInUser(@RequestBody UserLogRequest userRequest){
        this.userService.logIn(userRequest);
    }

    @GetMapping("/{id}")
    public void getUser(@PathVariable int id){
        this.userService.getUser(id);
    }

}
