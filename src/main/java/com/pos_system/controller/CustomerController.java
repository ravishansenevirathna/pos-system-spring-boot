package com.pos_system.controller;

import com.pos_system.dto.CustomerDto;
import com.pos_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/login")
    public String saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);

        return "Customer logged in successfully";
    }

    @GetMapping(path = "/find" , params = "id")
    public CustomerDto getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return customerDto;
    }

    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDto> getAllCustomer() {
        List<CustomerDto> allCustomer = customerService.getAllCustomer();
        return allCustomer;

    }
}
