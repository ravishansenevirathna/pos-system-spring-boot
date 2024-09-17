package com.pos_system.service;

import com.pos_system.dto.CustomerDto;

import java.util.List;

/**
 * Hi 👋, I'm ravishansenevirathna
 * Project : pos-system
 * Created date : 9/16/2024
 * Created time : 7:49 PM
 */
public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(int customerId);

    List<CustomerDto> getAllCustomer();
}
