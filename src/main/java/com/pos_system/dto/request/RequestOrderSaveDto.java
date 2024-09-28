package com.pos_system.dto.request;

import com.pos_system.entity.Customer;
import com.pos_system.entity.OrderDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderSaveDto {

    private int customer;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSaveDto> requestOrderDetailsSaveDto;
}
