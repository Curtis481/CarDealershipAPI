package com.credera.CarDealershipApplication.Customer;

import com.credera.CarDealershipApplication.Sale.ResponseSale;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseCustomer {

    private Integer id;
    private String name;
    private String address;
    private List<ResponseSale> purchases;
    private Integer purchaseNumber;

    public ResponseCustomer (Customer customer, List<ResponseSale> sales) {
        id = customer.getId();
        name = customer.getName();
        address = customer.getAddress();
        purchases = sales;
        purchaseNumber = customer.getPurchaseNumber();
    }
}
