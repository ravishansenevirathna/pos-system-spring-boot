package com.pos_system.service;

import com.pos_system.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.pos_system.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String saveOrder(RequestOrderSaveDto requestOrderSaveDto);

    PaginatedResponseOrderDetailsDto getOrderDetails(String itemName, int page, int size);
}
