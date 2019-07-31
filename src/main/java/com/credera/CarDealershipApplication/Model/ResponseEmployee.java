package com.credera.CarDealershipApplication.Model;

import lombok.Getter;

import java.util.List;

@Getter
public class ResponseEmployee {
    private int id;
    private String name;
    private String address;
    private List<ResponseSale> sales;
    private int soldNumber;

    public ResponseEmployee(Employee employee, List<ResponseSale> sales) {
        id = employee.getId();
        name = employee.getName();
        address = employee.getAddress();
        this.sales = sales;
        soldNumber = employee.getSoldNumber();
    }
}
