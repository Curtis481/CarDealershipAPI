package com.credera.CarDealershipApplication.Employee;

import com.credera.CarDealershipApplication.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT employee from Employee employee WHERE sold_number = :soldNumber")
    List<Employee> findBySoldNumber(@Param("soldNumber") Integer soldNumber);

}
