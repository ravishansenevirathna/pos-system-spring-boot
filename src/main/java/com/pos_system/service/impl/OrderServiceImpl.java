package com.pos_system.service.impl;

import com.pos_system.dto.request.RequestOrderSaveDto;
import com.pos_system.entity.Customer;
import com.pos_system.entity.Order;
import com.pos_system.entity.OrderDetails;
import com.pos_system.repo.CustomerRepo;
import com.pos_system.repo.ItemRepo;
import com.pos_system.repo.OrderDetailsRepo;
import com.pos_system.repo.OrderRepo;
import com.pos_system.service.OrderService;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String saveOrder(RequestOrderSaveDto requestOrderSaveDto) {
        System.out.println("gf"+requestOrderSaveDto);

        // Fetch the Customer entity using the customer ID from RequestOrderSaveDto
        Customer customer = customerRepo.findById(requestOrderSaveDto.getCustomer())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Order order = modelMapper.map(requestOrderSaveDto,Order.class);
        order.setCustomer(customer);

        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrder_id())) {
            List<OrderDetails> orderDetails = modelMapper.map(requestOrderSaveDto.getRequestOrderDetailsSaveDto(),new TypeToken<List<OrderDetails>>(){
            }.getType());
            for(int i = 0; i < orderDetails.size(); i++) {
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDto.getRequestOrderDetailsSaveDto().get(i).getItems()));

            }

            if (orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }

            return "Saved successfully";

        }
        return "Failed to save order";
    }
}
