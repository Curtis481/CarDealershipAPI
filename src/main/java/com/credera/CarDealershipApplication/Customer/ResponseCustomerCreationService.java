package com.credera.CarDealershipApplication.Customer;

import com.credera.CarDealershipApplication.Customer.Customer;
import com.credera.CarDealershipApplication.Customer.ResponseCustomer;
import com.credera.CarDealershipApplication.Service.ResponseConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ResponseCustomerCreationService {

    private ResponseConverterService responseConverterService;

    @Autowired
    public ResponseCustomerCreationService(ResponseConverterService responseConverterService) {
        this.responseConverterService = responseConverterService;
    }

    public ResponseCustomer createNewResponseCustomer(Customer customer) {
        return new ResponseCustomer(customer, responseConverterService.convertSaleListToResponseList(customer.getPurchases()));
    }

    public ResponseCustomer createNewResponseCustomer(Optional<Customer> optionalCustomer) {
        Customer customer = optionalCustomer.orElse(new Customer());
        if(customer.getPurchases() == null) {
            return new ResponseCustomer(customer, new ArrayList<>());
        }
        return new ResponseCustomer(customer, responseConverterService.convertSaleListToResponseList(customer.getPurchases()));
    }
}
