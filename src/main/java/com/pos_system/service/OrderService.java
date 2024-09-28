package com.pos_system.service;

import com.pos_system.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String saveOrder(RequestOrderSaveDto requestOrderSaveDto);
}
