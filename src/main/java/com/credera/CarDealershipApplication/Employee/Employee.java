package com.credera.CarDealershipApplication.Employee;

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
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "employee", targetEntity = Sale.class, cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Sale> sales;

    @Column(name = "sold_number")
    private Integer soldNumber;

    public Employee(ReceiverEmployee receiverEmployee) {
        name = receiverEmployee.getName();
        address = receiverEmployee.getAddress();
        sales = new ArrayList<>();
        soldNumber = 0;
    }
}
