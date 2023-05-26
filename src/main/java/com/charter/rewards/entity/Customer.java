package com.charter.rewards.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMER")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "CUSTOMER_FIRSTNAME")
    @NotNull(message = "Customer  first name can not be empty")
    private String customerFirstName;

    @Column(name = "CUSTOMER_LASTNAME")
    @NotNull(message = "Customer  last name can not be empty")
    private String customerLastName;
}
