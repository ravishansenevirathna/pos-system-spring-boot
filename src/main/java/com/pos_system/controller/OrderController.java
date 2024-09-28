package com.pos_system.controller;

import com.pos_system.dto.CustomerDto;
import com.pos_system.dto.request.RequestOrderSaveDto;
import com.pos_system.response.StandardResponse;
import com.pos_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDto requestOrderSaveDto) {

        String message = orderService.saveOrder(requestOrderSaveDto);

        return new ResponseEntity<>(new StandardResponse(HttpStatus.OK.value(), "Success", "Success",message ), HttpStatus.OK);
    }
}
