package org.gfg.JBDL_76_Minor1.service.impl;

import org.gfg.JBDL_76_Minor1.dto.UserCreationRequest;
import org.gfg.JBDL_76_Minor1.dto.UserCreationResponse;
import org.gfg.JBDL_76_Minor1.enums.Operator;
import org.gfg.JBDL_76_Minor1.enums.UserFilter;
import org.gfg.JBDL_76_Minor1.model.User;
import org.gfg.JBDL_76_Minor1.enums.UserType;
import org.gfg.JBDL_76_Minor1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserCreationResponse addStudent(UserCreationRequest request) {
        User user = request.toUser();
        user.setUserType(UserType.STUDENT);
        User userFromDb = userRepository.save(user);
        return UserCreationResponse.builder().
                userName(userFromDb.getName()).
                userAddress(userFromDb.getAddress()).
                userEmail(userFromDb.getEmail()).
                userPhone(userFromDb.getPhoneNo()).
                build();
    }

    public List<User> filter(UserFilter filterBy, Operator operator, String value) {
        switch (filterBy){
            case NAME :
                switch (operator){
                    case EQUALS :
                        return userRepository.findByName(value);

                    case LIKE:
                        return userRepository.findByNameContains(value);
                }
        }
        return new ArrayList<>();
    }

    public User checkIfUserIsValid(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }
}
// some methods are actually there, u can directly call from ur service
// some methods not present in your jpa, then u are going to write queries ?

// u have to write the body completely for filter method of userservice ?

// book controller ?
// crud book book creation, book filteration