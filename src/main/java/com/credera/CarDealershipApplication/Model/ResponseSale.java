package com.credera.CarDealershipApplication.Model;

import lombok.Getter;

@Getter
public class ResponseSale {

    private int id;
    private ResponseCar car;
    private int sellPrice;
    private java.util.Date sellDate;

    public ResponseSale(Sale sale, ResponseCar car) {
        id = sale.getId();
        this.car = car;
        sellPrice = sale.getSellPrice();
        sellDate = sale.getSellDate();
    }
}
