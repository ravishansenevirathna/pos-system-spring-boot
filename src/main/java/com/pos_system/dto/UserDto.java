package com.pos_system.dto;

import com.pos_system.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String user_name;
    private String email;
    private String password;
    private UserType userType;
    private Boolean activeStatus;
}
