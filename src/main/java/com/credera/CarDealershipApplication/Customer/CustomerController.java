package com.credera.CarDealershipApplication.Customer;

import com.credera.CarDealershipApplication.Service.ResponseConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

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

    @GetMapping()
    public ResponseEntity getAllCustomers(@RequestParam Map<String, String> allParams) {
        Customer customer = new Customer();
        if(allParams.get("purchaseNumber") != null) {
            customer.setPurchaseNumber(Integer.parseInt(allParams.get("purchaseNumber")));
        }
        customer.setName(allParams.get("name"));
        customer.setAddress(allParams.get("address"));
        Example<Customer> customerExample = Example.of(customer, ExampleMatcher.matchingAll().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return new ResponseEntity<List<ResponseCustomer>>(responseConverterService.convertCustomerListToResponseList(customerService.findAll(customerExample)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCustomerById(@PathVariable int id) {
        return new ResponseEntity<ResponseCustomer>(responseCustomerCreationService.createNewResponseCustomer(customerService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/purchases/")
    public ResponseEntity getCustomerByPurchaseNumber(@RequestParam int purchaseNumber) {
        return new ResponseEntity<List<ResponseCustomer>>(responseConverterService.convertCustomerListToResponseList(customerService.findByPurchaseNumber(purchaseNumber)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addNewCustomer(@RequestBody ReceiverCustomer receiverCustomer) {
        Customer newCustomer = new Customer(receiverCustomer);
        customerService.addNewCustomer(newCustomer);
        return new ResponseEntity<ResponseCustomer>(responseCustomerCreationService.createNewResponseCustomer(newCustomer), HttpStatus.OK);
    }
}
