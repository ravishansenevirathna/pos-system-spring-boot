package com.pos_system.dto.paginated;

import com.pos_system.dto.response.ResponseOrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponseOrderDetailsDto {

    private List<ResponseOrderDetailsDto> list;
    private long dataCount;



}
