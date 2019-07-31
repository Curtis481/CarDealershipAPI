package com.credera.CarDealershipApplication.Model;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseCustomer {

    private int id;
    private String name;
    private String address;
    private List<ResponseSale> purchases;
    private int purchaseNumber;

    public ResponseCustomer (Customer customer, List<ResponseSale> sales) {
        id = customer.getId();
        name = customer.getName();
        address = customer.getAddress();
        purchases = sales;
        purchaseNumber = customer.getPurchaseNumber();
    }
}
