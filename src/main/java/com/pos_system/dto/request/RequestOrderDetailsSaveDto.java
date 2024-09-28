package com.pos_system.dto.request;

import com.pos_system.entity.Item;
import com.pos_system.entity.Order;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderDetailsSaveDto {

    private String itemName;
    private Double qty;
    private Double amount;
    private int orders;
    private int items;
}
