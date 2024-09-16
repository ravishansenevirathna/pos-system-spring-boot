package com.pos_system.controller;

import com.pos_system.dto.CustomerDto;
import com.pos_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public String saveCustomer(@RequestBody CustomerDto customerDto) {
        System.out.println(" cccccccccc"+ customerDto.getCustomerName());

        return "Customer logged in successfully";
    }
}
