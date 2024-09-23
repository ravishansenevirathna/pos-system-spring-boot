package com.pos_system.controller;

import com.pos_system.dto.CustomerDto;
import com.pos_system.response.StandardResponse;
import com.pos_system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomer")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);

        return new ResponseEntity<>(new StandardResponse(HttpStatus.OK.value(), "Success", "Success","saved!" ), HttpStatus.OK);
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

    @DeleteMapping(path = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId) {

        return customerService.deleteCustomer(customerId);

    }
}
