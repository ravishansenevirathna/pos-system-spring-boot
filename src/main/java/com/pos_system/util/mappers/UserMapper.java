package com.pos_system.util.mappers;

import com.pos_system.dto.UserDto;
import com.pos_system.dto.paginated.PaginatedResponseUserDto;
import com.pos_system.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User dtoToEntity (UserDto userDto);

    List<UserDto> entityToDtoList(List<User> users);


    List<UserDto> entityToDtoListForPaginated(Page<User> users);
}
