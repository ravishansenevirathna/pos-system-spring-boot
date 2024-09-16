package com.pos_system.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id()
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "nic")
    private String nic;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "active_state")
    private boolean activeState;

}
