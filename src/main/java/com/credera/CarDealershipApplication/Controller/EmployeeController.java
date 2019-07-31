package com.credera.CarDealershipApplication.Controller;

import com.credera.CarDealershipApplication.Model.*;
import com.credera.CarDealershipApplication.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealership/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private ResponseConverterService responseConverterService;
    private ResponseEmployeeCreationService responseEmployeeCreationService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ResponseConverterService responseConverterService, ResponseEmployeeCreationService responseEmployeeCreationService) {
        this.employeeService = employeeService;
        this.responseEmployeeCreationService = responseEmployeeCreationService;
        this.responseConverterService = responseConverterService;
    }

    @GetMapping("/")
    public ResponseEntity getAllEmployees() {
        return new ResponseEntity<List<ResponseEmployee>>(responseConverterService.convertEmployeeListToResponseList(employeeService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<ResponseEmployee>(responseEmployeeCreationService.createNewResponseEmployee(employeeService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/sales/")
    public ResponseEntity getCustomerBySoldNumber(@RequestParam int soldNumber) {
        return new ResponseEntity<List<ResponseEmployee>>(responseConverterService.convertEmployeeListToResponseList(employeeService.findBySoldNumber(soldNumber)), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity addNewEmployee(@RequestBody ReceiverEmployee receiverEmployee) {
        Employee newEmployee = new Employee(receiverEmployee);
        employeeService.addNewEmployee(newEmployee);
        return new ResponseEntity<ResponseEmployee>(responseEmployeeCreationService.createNewResponseEmployee(newEmployee), HttpStatus.OK);
    }
}
