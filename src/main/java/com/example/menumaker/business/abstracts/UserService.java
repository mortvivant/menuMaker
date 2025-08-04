package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateUserRequest;
import com.example.menumaker.business.requests.UserLogRequest;
import com.example.menumaker.business.responses.GetByRequestUserResponse;

public interface UserService {
    void addUser(CreateUserRequest createUserRequest);
    void logIn(UserLogRequest userLogRequest);
    GetByRequestUserResponse getUser(int id);
}
