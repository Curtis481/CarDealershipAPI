package com.credera.CarDealershipApplication.Controller;

import com.credera.CarDealershipApplication.Model.*;
import com.credera.CarDealershipApplication.Service.CustomerService;
import com.credera.CarDealershipApplication.Service.EmployeeService;
import com.credera.CarDealershipApplication.Service.ResponseConverterService;
import com.credera.CarDealershipApplication.Service.ResponseCustomerCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealership/customers")
public class CustomerController {

    private CustomerService customerService;
    private ResponseConverterService responseConverterService;
    private ResponseCustomerCreationService responseCustomerCreationService;

    @Autowired
    public CustomerController(CustomerService customerService, ResponseConverterService responseConverterService, ResponseCustomerCreationService responseCustomerCreationService) {
        this.customerService = customerService;
        this.responseConverterService = responseConverterService;
        this.responseCustomerCreationService = responseCustomerCreationService;
    }

    @GetMapping("/")
    public ResponseEntity getAllCustomers() {
        return new ResponseEntity<List<ResponseCustomer>>(responseConverterService.convertCustomerListToResponseList(customerService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable int id) {
        return new ResponseEntity<ResponseCustomer>(responseCustomerCreationService.createNewResponseCustomer(customerService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/purchases/")
    public ResponseEntity getCustomerByPurchaseNumber(@RequestParam int purchaseNumber) {
        return new ResponseEntity<List<ResponseCustomer>>(responseConverterService.convertCustomerListToResponseList(customerService.findByPurchaseNumber(purchaseNumber)), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity addNewCustomer(@RequestBody ReceiverCustomer receiverCustomer) {
        Customer newCustomer = new Customer(receiverCustomer);
        customerService.addNewCustomer(newCustomer);
        return new ResponseEntity<ResponseCustomer>(responseCustomerCreationService.createNewResponseCustomer(newCustomer), HttpStatus.OK);
    }
}
