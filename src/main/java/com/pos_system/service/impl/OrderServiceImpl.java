package com.pos_system.service.impl;

import com.pos_system.dto.request.RequestOrderSaveDto;
import com.pos_system.entity.Order;
import com.pos_system.entity.OrderDetails;
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
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String saveOrder(RequestOrderSaveDto requestOrderSaveDto) {

        Order order = new Order(
                requestOrderSaveDto.getCustomer(),
                requestOrderSaveDto.getDate(),
                requestOrderSaveDto.getTotal()
        );

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
