package com.pos_system.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOrderDetailsDto {

    //customer
    private String customerName;
    private String phoneNumber;
    private String address;

    //order
    private Date date;
    private Double total;
}
