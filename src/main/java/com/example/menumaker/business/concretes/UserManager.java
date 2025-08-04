package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.UserService;
import com.example.menumaker.business.requests.CreateUserRequest;
import com.example.menumaker.business.requests.UserLogRequest;
import com.example.menumaker.business.responses.GetByRequestUserResponse;
import com.example.menumaker.business.rules.UserBusinessRules;
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
    private UserBusinessRules userBusinessRules;

    @Override
    public void addUser(CreateUserRequest createUserRequest) {
        userBusinessRules.checkIfUsernameExists(createUserRequest.getUsername());
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void logIn(UserLogRequest userLogRequest) {
        boolean failed = true;
        if(this.userRepository.existsUserByUsernameAndPassword(userLogRequest.getUsername(), userLogRequest.getPassword())){
            User user = this.userRepository.findByUsername(userLogRequest.getUsername());
            getUser(user.getId());
            failed = false;
        }
        else {
            userBusinessRules.checkInvalidLog(failed);
        }
    }

    @Override
    public GetByRequestUserResponse getUser(int id) {
        GetByRequestUserResponse getByRequestUserResponse = this.modelMapperService.forResponse().map(this.userRepository.getReferenceById(id), GetByRequestUserResponse.class);
        return getByRequestUserResponse;
    }

}
