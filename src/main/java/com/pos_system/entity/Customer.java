package com.pos_system.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
