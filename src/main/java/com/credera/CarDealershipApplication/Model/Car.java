package com.credera.CarDealershipApplication.Model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "color")
    private String color;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private int price;

    @OneToOne(mappedBy = "car")
    private Sale sale;

    public Car(ReceiverCar receiverCar) {
        color = receiverCar.getColor();
        make = receiverCar.getMake();
        model = receiverCar.getModel();
        year = receiverCar.getYear();
        price = receiverCar.getPrice();
    }

}
