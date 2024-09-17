package com.pos_system.entity;

import com.pos_system.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemId")
    private int itemId;

    @Column(name = "itemName", nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measureType",nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "sellingPrice", nullable = false)
    private Double sellingPrice;






}
