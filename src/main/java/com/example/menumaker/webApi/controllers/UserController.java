package com.example.menumaker.webApi.controllers;

import com.example.menumaker.business.abstracts.UserService;
import com.example.menumaker.business.requests.CreateUserRequest;
import com.example.menumaker.business.requests.UpdateUserRequest;
import com.example.menumaker.business.requests.UserLogRequest;
import com.example.menumaker.business.responses.GetAllUserResponse;
import com.example.menumaker.business.responses.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @PostMapping("/adduser")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> addUser(@RequestBody CreateUserRequest createUserRequest){
        return this.userService.addUser(createUserRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<?> logInUser(@RequestBody UserLogRequest userRequest){
       return this.userService.logIn(userRequest);
    }

    @GetMapping("/{id}")
    public GetUserResponse getUser(@PathVariable int id){
        return this.userService.getUser(id);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return this.userService.updateUser(updateUserRequest);
    }

    @GetMapping("/getallusers")
    public List<GetAllUserResponse> getAllUserResponses(){
        return this.userService.getAllUsers();
    }
}
