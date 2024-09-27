package com.pos_system.service.impl;

import com.pos_system.dto.UserDto;
import com.pos_system.dto.paginated.PaginatedResponseUserDto;
import com.pos_system.entity.User;
import com.pos_system.repo.UserRepo;
import com.pos_system.service.UserService;
import com.pos_system.util.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public String saveUser(UserDto userDto) {
        User user = userMapper.dtoToEntity(userDto);
        userRepo.save(user);

        return "User saved";
    }


    @Override
    public List<UserDto> getAllByStatus(Boolean activeStatus) {
        List<User> users = userRepo.findAllByActiveStatus(activeStatus);
        if(!users.isEmpty()){
            List<UserDto> userDtoList = userMapper.entityToDtoList(users);

            return userDtoList;
        }else return null;

    }

//    pagination
    @Override
    public PaginatedResponseUserDto getAllByStatusWithPaginated(Boolean activeStatus, int page, int size) {

        Page<User> users = userRepo.findAllByActiveStatus(activeStatus, PageRequest.of(page, size));
        int count = userRepo.countAllByActiveStatus(activeStatus);
        if(!users.isEmpty()){

            PaginatedResponseUserDto paginatedResponseUserDto = new PaginatedResponseUserDto(userMapper.entityToDtoListForPaginated(users),count);

            return paginatedResponseUserDto;
        }else return null;
    }


}
