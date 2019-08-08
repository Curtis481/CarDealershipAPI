package com.credera.CarDealershipApplication.Employee;

import com.credera.CarDealershipApplication.Employee.Employee;
import com.credera.CarDealershipApplication.Employee.ResponseEmployee;
import com.credera.CarDealershipApplication.Service.ResponseConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ResponseEmployeeCreationService {

    private ResponseConverterService responseConverterService;

    @Autowired
    public ResponseEmployeeCreationService(ResponseConverterService responseConverterService) {
        this.responseConverterService = responseConverterService;
    }

    public ResponseEmployee createNewResponseEmployee(Employee employee) {
        return new ResponseEmployee(employee, responseConverterService.convertSaleListToResponseList(employee.getSales()));
    }

    public ResponseEmployee createNewResponseEmployee(Optional<Employee> optionalEmployee) {
        Employee employee = optionalEmployee.orElse(new Employee());
        if(employee.getSales() == null) {
            return new ResponseEmployee(employee, new ArrayList<>());
        }
        return new ResponseEmployee(employee, responseConverterService.convertSaleListToResponseList(employee.getSales()));
    }
}