package com.example.menumaker.business.concretes;

import com.example.menumaker.business.abstracts.UserService;
import com.example.menumaker.business.requests.CreateUserRequest;
import com.example.menumaker.business.requests.UpdateUserRequest;
import com.example.menumaker.business.requests.UserLogRequest;
import com.example.menumaker.business.responses.GetUserResponse;
import com.example.menumaker.business.rules.UserBusinessRules;
import com.example.menumaker.core.utilities.mappers.ModelMapperService;
import com.example.menumaker.dataAccess.abstracts.UserRepository;
import com.example.menumaker.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private UserBusinessRules userBusinessRules;

    @Override
    public ResponseEntity<?> addUser(CreateUserRequest createUserRequest) {
        userBusinessRules.checkIfUsernameExists(createUserRequest.getUsername());
        User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);
        this.userRepository.save(user);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<?> logIn(UserLogRequest userLogRequest) {
        if(checkLog(userLogRequest.getUsername(),userLogRequest.getPassword())){
            User user = userRepository.getUsersByUsername(userLogRequest.getUsername());
            return ResponseEntity.ok(getUser(user.getId()));
        }
        else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @Override
    public boolean checkLog(String username,String password) {
        return userRepository.existsUserByUsernameAndPassword(username,password);
    }

    @Override
    public GetUserResponse getUser(int id) {
        GetUserResponse getByRequestUserResponse = this.modelMapperService.forResponse().map(this.userRepository.getReferenceById(id), GetUserResponse.class);
        getByRequestUserResponse.setSuccess(true);
        return getByRequestUserResponse;
    }

    @Override
    public ResponseEntity<?> updateUser(UpdateUserRequest updateUserRequest) {
        User user = this.modelMapperService.forRequest().map(updateUserRequest,User.class);
        this.userRepository.save(user);
        return ResponseEntity.ok(true);
    }

}
