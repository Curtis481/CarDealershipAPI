package com.credera.CarDealershipApplication.Employee;

import com.credera.CarDealershipApplication.Sale.ResponseSale;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseEmployee {
    private Integer id;
    private String name;
    private String address;
    private List<ResponseSale> sales;
    private Integer soldNumber;

    public ResponseEmployee(Employee employee, List<ResponseSale> sales) {
        id = employee.getId();
        name = employee.getName();
        address = employee.getAddress();
        this.sales = sales;
        soldNumber = employee.getSoldNumber();
    }
}
