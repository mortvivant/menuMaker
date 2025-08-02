package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.UserService;
import com.example.menumaker.business.requests.CreateUserRequest;
import com.example.menumaker.core.utilities.mappers.ModelMapperService;
import com.example.menumaker.dataAccess.abstracts.UserRepository;
import com.example.menumaker.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public void addUser(CreateUserRequest createUserRequest) {
        User user = this.modelMapperService.forRequest().map(createUserRequest,User.class);
        this.userRepository.save(user);
    }
}
