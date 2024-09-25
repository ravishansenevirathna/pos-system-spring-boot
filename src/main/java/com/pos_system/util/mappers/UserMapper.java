package com.pos_system.util.mappers;

import com.pos_system.dto.UserDto;
import com.pos_system.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User dtoToEntity (UserDto userDto);

}
