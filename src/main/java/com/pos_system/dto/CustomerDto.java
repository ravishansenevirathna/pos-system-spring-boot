package com.pos_system.dto;

import lombok.Data;

@Data
public class CustomerDto {

    private int id;

    private String customerName;

    private String nic;

    private String phoneNumber;

    private String address;

    private boolean activeState;
}
