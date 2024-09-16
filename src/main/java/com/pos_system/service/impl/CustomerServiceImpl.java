package com.pos_system.service.impl;

import com.pos_system.dto.CustomerDto;
import com.pos_system.entity.Customer;
import com.pos_system.repo.CustomerRepo;
import com.pos_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Hi 👋, I'm ravishansenevirathna
 * Project : pos-system
 * Created date : 9/16/2024
 * Created time : 7:50 PM
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public void saveCustomer(CustomerDto customerDto) {
        System.out.println("Saving customer");

        Customer customer = new Customer(customerDto.getId(), customerDto.getCustomerName(), customerDto.getNic(),customerDto.getPhoneNumber(), customerDto.getAddress());
        customerRepo.save(customer);
    }
}
