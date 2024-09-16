package com.pos_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private int id;

    private String customerName;

    private String nic;

    private String phoneNumber;

    private String address;
}
