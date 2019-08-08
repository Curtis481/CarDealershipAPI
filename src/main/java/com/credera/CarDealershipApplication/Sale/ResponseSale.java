package com.credera.CarDealershipApplication.Sale;

import com.credera.CarDealershipApplication.Car.ResponseCar;
import lombok.Getter;

@Getter
public class ResponseSale {

    private Integer id;
    private ResponseCar car;
    private Integer sellPrice;
    private java.util.Date sellDate;

    public ResponseSale(Sale sale, ResponseCar car) {
        id = sale.getId();
        this.car = car;
        sellPrice = sale.getSellPrice();
        sellDate = sale.getSellDate();
    }
}
