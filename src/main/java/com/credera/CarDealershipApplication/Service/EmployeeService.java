package com.credera.CarDealershipApplication.Service;

import com.credera.CarDealershipApplication.Model.Employee;
import com.credera.CarDealershipApplication.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findBySoldNumber(int soldNumber) {
        return employeeRepository.findBySoldNumber(soldNumber);
    }

    public void addNewEmployee(Employee newEmployee) {
        employeeRepository.save(newEmployee);
    }
}
