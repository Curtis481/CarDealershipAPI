package com.credera.CarDealershipApplication.Model;

import lombok.Getter;

@Getter
public class ReceiverSale {

    private int car_id;
    private int employee_id;
    private int customer_id;
    private int sellPrice;
    private java.util.Date sellDate;
}
