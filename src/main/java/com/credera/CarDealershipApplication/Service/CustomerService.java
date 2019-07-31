package com.credera.CarDealershipApplication.Service;

import com.credera.CarDealershipApplication.Model.Customer;
import com.credera.CarDealershipApplication.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Customer> findAll() {
        return customerRepository.findAll();
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
