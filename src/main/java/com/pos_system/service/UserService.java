package com.pos_system.service;

import com.pos_system.dto.UserDto;


public interface UserService {
    String saveUser(UserDto userDto);

//    List<UserDto> getAllByStatus(String activeStatus);
}
