package com.credera.CarDealershipApplication.Customer;

import com.credera.CarDealershipApplication.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT customer from Customer customer WHERE purchase_number = :purchaseNumber")
    List<Customer> findByPurchaseNumber(@Param("purchaseNumber") Integer purchaseNumber);

}
