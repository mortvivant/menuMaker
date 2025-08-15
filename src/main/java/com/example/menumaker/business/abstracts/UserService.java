package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateUserRequest;
import com.example.menumaker.business.requests.UpdateUserRequest;
import com.example.menumaker.business.requests.UserLogRequest;
import com.example.menumaker.business.responses.GetAllUserResponse;
import com.example.menumaker.business.responses.GetUserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<?> addUser(CreateUserRequest createUserRequest);
    ResponseEntity<?> logIn(UserLogRequest userLogRequest);
    boolean checkLog(String username,String password);
    GetUserResponse getUser(int id);
    ResponseEntity<?> updateUser(UpdateUserRequest updateUserRequest);
    List<GetAllUserResponse> getAllUsers();
}
