package com.credera.CarDealershipApplication.Model;

import lombok.Getter;

@Getter
public class ResponseCar {
    private int id;
    private String color;
    private String make;
    private String model;
    private int year;
    private int price;

    public ResponseCar(Car car) {
        id = car.getId();
        color = car.getColor();
        make = car.getMake();
        model = car.getModel();
        year = car.getYear();
        price = car.getPrice();
    }
}
