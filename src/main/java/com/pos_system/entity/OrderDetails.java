package com.pos_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @Id
    @Column(name = "order_details_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDetailsId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "qty")
    private Double qty;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orders;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item items;



}
