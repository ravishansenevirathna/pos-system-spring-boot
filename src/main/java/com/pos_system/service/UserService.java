package com.pos_system.service;

import com.pos_system.dto.UserDto;
import com.pos_system.dto.paginated.PaginatedResponseUserDto;

import java.util.List;


public interface UserService {
    String saveUser(UserDto userDto);

    List<UserDto> getAllByStatus(Boolean activeStatus);

    PaginatedResponseUserDto getAllByStatusWithPaginated(Boolean activeStatus, int page, int size);
}
