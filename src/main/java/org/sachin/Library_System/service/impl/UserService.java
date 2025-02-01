package org.sachin.Library_System.service.impl;

import org.sachin.Library_System.dto.request.UserCreationRequest;
import org.sachin.Library_System.dto.response.UserCreationResponse;
import org.sachin.Library_System.enums.Operator;
import org.sachin.Library_System.enums.UserFilter;
import org.sachin.Library_System.model.User;
import org.sachin.Library_System.enums.UserType;
import org.sachin.Library_System.repository.UserCacheRepository;
import org.sachin.Library_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${student.authority}")
    private String studentAuthority;

    @Value("${admin.authority}")
    private String adminAuthority;

    @Autowired
    private UserCacheRepository userCacheRepository;


    public UserCreationResponse addStudent(UserCreationRequest request) {
        User user = request.toUser();
        user.setUserType(UserType.STUDENT);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAuthorities(studentAuthority);
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userCacheRepository.getUser(email);
        if(user != null){
            return user;
        }
        user = userRepository.findByEmail(email);
        if(user == null)
            throw  new UsernameNotFoundException("No user found!!");
        userCacheRepository.setUser(email , user);
        return user;
    }

    public UserCreationResponse addAdmin(UserCreationRequest request) {
        User user = request.toUser();
        user.setUserType(UserType.ADMIN);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAuthorities(adminAuthority);
        User userFromDb = userRepository.save(user);
        return UserCreationResponse.builder().
                userName(userFromDb.getName()).
                userAddress(userFromDb.getAddress()).
                userEmail(userFromDb.getEmail()).
                userPhone(userFromDb.getPhoneNo()).
                build();
    }
}
// some methods are actually there, u can directly call from ur service
// some methods not present in your jpa, then u are going to write queries ?

// u have to write the body completely for filter method of userservice ?

// book controller ?
// crud book book creation, book filteration

//@Cacheable :  cache in server : server/application