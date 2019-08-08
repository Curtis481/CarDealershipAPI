package com.credera.CarDealershipApplication.Employee;

import com.credera.CarDealershipApplication.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping()
    public ResponseEntity getAllEmployees(@RequestParam Map<String, String> allParams) {
        Employee employee = new Employee();
        if(allParams.get("soldNumber") != null) {
            employee.setSoldNumber(Integer.parseInt(allParams.get("soldNumber")));
        }
        employee.setName(allParams.get("name"));
        employee.setAddress(allParams.get("address"));
        Example<Employee> employeeExample = Example.of(employee, ExampleMatcher.matchingAll().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        return new ResponseEntity<List<ResponseEmployee>>(responseConverterService.convertEmployeeListToResponseList(employeeService.findAll(employeeExample)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<ResponseEmployee>(responseEmployeeCreationService.createNewResponseEmployee(employeeService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/sales/")
    public ResponseEntity getCustomerBySoldNumber(@RequestParam int soldNumber) {
        return new ResponseEntity<List<ResponseEmployee>>(responseConverterService.convertEmployeeListToResponseList(employeeService.findBySoldNumber(soldNumber)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addNewEmployee(@RequestBody ReceiverEmployee receiverEmployee) {
        Employee newEmployee = new Employee(receiverEmployee);
        employeeService.addNewEmployee(newEmployee);
        return new ResponseEntity<ResponseEmployee>(responseEmployeeCreationService.createNewResponseEmployee(newEmployee), HttpStatus.OK);
    }
}
