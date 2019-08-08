package com.credera.CarDealershipApplication.Service;

import com.credera.CarDealershipApplication.Car.Car;
import com.credera.CarDealershipApplication.Car.ResponseCar;
import com.credera.CarDealershipApplication.Car.ResponseCarCreationService;
import com.credera.CarDealershipApplication.Customer.Customer;
import com.credera.CarDealershipApplication.Customer.ResponseCustomer;
import com.credera.CarDealershipApplication.Customer.ResponseCustomerCreationService;
import com.credera.CarDealershipApplication.Employee.Employee;
import com.credera.CarDealershipApplication.Employee.ResponseEmployee;
import com.credera.CarDealershipApplication.Employee.ResponseEmployeeCreationService;
import com.credera.CarDealershipApplication.Sale.ResponseSale;
import com.credera.CarDealershipApplication.Sale.ResponseSaleCreationService;
import com.credera.CarDealershipApplication.Sale.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseConverterService {

    @Autowired
    private ResponseCustomerCreationService responseCustomerCreationService;
    @Autowired
    private ResponseCarCreationService responseCarCreationService;
    @Autowired
    private ResponseEmployeeCreationService responseEmployeeCreationService;
    @Autowired
    private ResponseSaleCreationService responseSaleCreationService;

    public List<ResponseCar> convertCarListToResponseList(List<Car> cars) {
        ArrayList<ResponseCar> responseList = new ArrayList<>();
        for (Car car:cars) {
            responseList.add(responseCarCreationService.createNewResponseCar(car));
        }
        return responseList;
    }

    public List<ResponseCustomer> convertCustomerListToResponseList(List<Customer> customers) {
        ArrayList<ResponseCustomer> responseList = new ArrayList<>();
        for (Customer customer:customers) {
            responseList.add(responseCustomerCreationService.createNewResponseCustomer(customer));
        }
        return responseList;
    }

    public List<ResponseEmployee> convertEmployeeListToResponseList(List<Employee> employees) {
        ArrayList<ResponseEmployee> responseList = new ArrayList<>();
        for (Employee employee:employees) {
            responseList.add(responseEmployeeCreationService.createNewResponseEmployee(employee));
        }
        return responseList;
    }

    public List<ResponseSale> convertSaleListToResponseList(List<Sale> sales) {
        ArrayList<ResponseSale> responseList = new ArrayList<>();
        for(Sale sale:sales) {
            responseList.add(responseSaleCreationService.createNewResponseSale(sale));
        }
        return responseList;
    }
}