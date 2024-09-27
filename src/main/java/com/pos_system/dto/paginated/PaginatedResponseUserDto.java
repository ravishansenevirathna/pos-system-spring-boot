package com.pos_system.dto.paginated;

import com.pos_system.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseUserDto {

    List<UserDto> list;
    private long dataCount;
}
