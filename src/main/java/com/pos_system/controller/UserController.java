package com.pos_system.controller;

import com.pos_system.dto.UserDto;
import com.pos_system.dto.paginated.PaginatedResponseUserDto;
import com.pos_system.response.StandardResponse;
import com.pos_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<StandardResponse> saveUser(@RequestBody UserDto userDto) {
        String result = userService.saveUser(userDto);

        return new ResponseEntity<>(new StandardResponse(HttpStatus.OK.value(), "Success", "Success", result), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllByStatus", params = {"active_status", "page", "size"})
    public ResponseEntity<StandardResponse> getAllByStatus(@RequestParam(value = "active_status") Boolean active_status,
                                                           @RequestParam(value = "page") int page,
                                                           @RequestParam(value = "size") int size) {
//        List<UserDto> userDto = userService.getAllByStatus(active_status, page, size);
        PaginatedResponseUserDto paginatedResponseUserDto = userService.getAllByStatusWithPaginated(active_status, page, size);

        return new ResponseEntity<>(new StandardResponse(HttpStatus.OK.value(), "Success", "Success", paginatedResponseUserDto), HttpStatus.OK);
    }


}
