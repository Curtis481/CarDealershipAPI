package com.credera.CarDealershipApplication.Sale;

import com.credera.CarDealershipApplication.Car.Car;
import com.credera.CarDealershipApplication.Customer.Customer;
import com.credera.CarDealershipApplication.Employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(targetEntity = Employee.class, cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "sell_price")
    private Integer sellPrice;

    @Column(name = "sell_date")
    @Temporal(TemporalType.DATE)
    private java.util.Date sellDate;

    public Sale(ReceiverSale receiverSale, Employee employee, Customer customer, Car car) {
        sellPrice = receiverSale.getSellPrice();
        sellDate = receiverSale.getSellDate();
        this.employee = employee;
        this.car = car;
        this.customer = customer;
    }
}
