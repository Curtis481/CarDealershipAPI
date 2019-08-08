package com.credera.CarDealershipApplication.Customer;

import com.credera.CarDealershipApplication.Customer.Customer;
import com.credera.CarDealershipApplication.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(Example<Customer> customerExample) {
        return customerRepository.findAll(customerExample);
    }

    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findByPurchaseNumber(int purchaseNumber) {
        return customerRepository.findByPurchaseNumber(purchaseNumber);
    }

    public void addNewCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }
}
