package com.credera.CarDealershipApplication.Car;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResponseCar {
    private Integer id;
    private String color;
    private String make;
    private String model;
    private Integer year;
    private Integer price;
    public ResponseCar(Car car) {
        id = car.getId();
        color = car.getColor();
        make = car.getMake();
        model = car.getModel();
        year = car.getYear();
        price = car.getPrice();
    }
}
