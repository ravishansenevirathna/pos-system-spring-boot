package com.pos_system.controller;

import com.pos_system.dto.CustomerDto;
import com.pos_system.dto.UserDto;
import com.pos_system.response.StandardResponse;
import com.pos_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<StandardResponse> saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);

        return new ResponseEntity<>(new StandardResponse(HttpStatus.OK.value(), "Success", "Success","saved!" ), HttpStatus.OK);
    }
}
