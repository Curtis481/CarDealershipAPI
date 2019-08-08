package com.credera.CarDealershipApplication.Car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseCarWithDetails {
    private Integer id;
    private String color;
    private String make;
    private String model;
    private Integer year;
    private Integer price;
    private List<CarDetails> carDetails;

    public ResponseCarWithDetails(ResponseCar responseCar, List<CarDetails> carDetails) {
        id = responseCar.getId();
        color = responseCar.getColor();
        make = responseCar.getMake();
        model = responseCar.getModel();
        year = responseCar.getYear();
        price = responseCar.getPrice();
        this.carDetails = carDetails;
    }
}
