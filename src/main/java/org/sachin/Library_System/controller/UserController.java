package org.sachin.Library_System.controller;

import org.sachin.Library_System.dto.request.UserCreationRequest;
import org.sachin.Library_System.dto.response.UserCreationResponse;
import org.sachin.Library_System.enums.Operator;
import org.sachin.Library_System.enums.UserFilter;
import org.sachin.Library_System.model.User;
import org.sachin.Library_System.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addStudent")
    public UserCreationResponse addStudent(@RequestBody @Validated UserCreationRequest request){
        return userService.addStudent(request);
    }

    @PostMapping("/addAdmin")
    public UserCreationResponse addAdmin(@RequestBody @Validated UserCreationRequest request){
        return userService.addAdmin(request);
    }

    @GetMapping("/filter")
    public List<User> filteredUser(@RequestParam("filterBy") UserFilter filterBy,
                                                    @RequestParam("operator") Operator operator,
                                                    @RequestParam("value") String value
                                                    ) {
        return userService.filter(filterBy, operator, value);
    }


}
// user created,
// updated
// search
// delete : userstatus: inactive
// crud

// DATA Transfer object

// name =