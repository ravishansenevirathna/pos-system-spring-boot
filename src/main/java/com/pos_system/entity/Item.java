package com.pos_system.entity;

import com.pos_system.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private int itemId;

    @Column(name = "itemName")
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measureType")
    private MeasuringUnitType measuringUnitType;

    @Column(name = "sellingPrice")
    private Double sellingPrice;

    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;






}
