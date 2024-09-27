package com.pos_system.service;

import com.pos_system.dto.UserDto;

import java.util.List;


public interface UserService {
    String saveUser(UserDto userDto);

    List<UserDto> getAllByStatus(Boolean activeStatus);
}
