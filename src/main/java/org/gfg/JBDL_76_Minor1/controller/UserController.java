package org.gfg.JBDL_76_Minor1.controller;

import org.gfg.JBDL_76_Minor1.dto.UserCreationRequest;
import org.gfg.JBDL_76_Minor1.dto.UserCreationResponse;
import org.gfg.JBDL_76_Minor1.enums.Operator;
import org.gfg.JBDL_76_Minor1.enums.UserFilter;
import org.gfg.JBDL_76_Minor1.model.User;
import org.gfg.JBDL_76_Minor1.service.impl.UserService;
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