package com.pos_system.service.impl;

import com.pos_system.dto.CustomerDto;
import com.pos_system.entity.Customer;
import com.pos_system.entity.Item;
import com.pos_system.exception.NotFoundException;
import com.pos_system.repo.CustomerRepo;
import com.pos_system.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto,Customer.class);
//        Customer customer = new Customer(customerDto.getCustomerName(), customerDto.getNic(),customerDto.getPhoneNumber(), customerDto.getAddress());
        customerRepo.save(customer);
    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getById(customerId);
            return new CustomerDto(customer.getId(), customer.getCustomerName(), customer.getNic(), customer.getPhoneNumber(), customer.getAddress());
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public List<CustomerDto> getAllCustomer() {


        List<Customer> allCustomer =  customerRepo.findAll();
        if (allCustomer.size() > 0) {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : allCustomer){

           CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getCustomerName(), customer.getNic(), customer.getPhoneNumber(), customer.getAddress());
            customerDtoList.add(customerDto);

        }

        return customerDtoList;
        }else{
            throw new NotFoundException("customer not found");
        }
    }





    @Override
    public String deleteCustomer(int customerId) {

        return "";
    }
}
