package com.credera.CarDealershipApplication.Customer;

import com.credera.CarDealershipApplication.Sale.Sale;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class, cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Sale> purchases;

    @Column(name = "purchase_number")
    private Integer purchaseNumber;


    public Customer(ReceiverCustomer receiverCustomer) {
        name = receiverCustomer.getName();
        address = receiverCustomer.getAddress();
        purchases = new ArrayList<>();
        purchaseNumber = 0;
    }

}
