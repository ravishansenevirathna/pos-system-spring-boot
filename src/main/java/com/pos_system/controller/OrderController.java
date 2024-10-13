package com.pos_system.controller;

import com.pos_system.dto.CustomerDto;
import com.pos_system.dto.ItemDto;
import com.pos_system.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.pos_system.dto.request.RequestOrderSaveDto;
import com.pos_system.response.StandardResponse;
import com.pos_system.service.OrderService;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/get-order-details", params = {"itemName","page","size"})
    public ResponseEntity<StandardResponse> getOrderDetails(@RequestParam(value = "itemName") String itemName, @RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
        PaginatedResponseOrderDetailsDto paginatedResponseOrderDetailsDto = orderService.getOrderDetails(itemName, page, size);
        return new ResponseEntity<>(new StandardResponse(HttpStatus.OK.value(), "Success", "Success",paginatedResponseOrderDetailsDto ), HttpStatus.OK);

    }
}
