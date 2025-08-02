package com.example.menumaker.business.abstracts;

import com.example.menumaker.business.requests.CreateUserRequest;

public interface UserService {
    void addUser(CreateUserRequest createUserRequest);
}
