package com.credera.CarDealershipApplication.Car;


import com.credera.CarDealershipApplication.Sale.Sale;
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
    private Integer id;

    @Column(name = "color")
    private String color;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private Integer price;

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
