package com.pos_system.service.impl;

import com.pos_system.dto.UserDto;
import com.pos_system.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void saveUser(UserDto userDto) {
//        dtoToEntity(userDto);
    }
}
