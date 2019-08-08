package com.credera.CarDealershipApplication.Sale;

import com.credera.CarDealershipApplication.Car.Car;
import com.credera.CarDealershipApplication.Car.CarService;
import com.credera.CarDealershipApplication.Customer.Customer;
import com.credera.CarDealershipApplication.Customer.CustomerService;
import com.credera.CarDealershipApplication.Employee.Employee;
import com.credera.CarDealershipApplication.Employee.EmployeeService;
import com.credera.CarDealershipApplication.Service.*;
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
@RequestMapping("dealership/sales")
public class SaleController {

    private SaleService saleService;
    private ResponseConverterService responseConverterService;
    private ResponseSaleCreationService responseSaleCreationService;
    private EmployeeService employeeService;
    private CustomerService customerService;
    private CarService carService;

    @Autowired
    public SaleController(SaleService saleService, ResponseConverterService responseConverterService, ResponseSaleCreationService responseSaleCreationService, EmployeeService employeeService,
    CustomerService customerService, CarService carService) {
        this.employeeService = employeeService;
        this.responseConverterService = responseConverterService;
        this.responseSaleCreationService = responseSaleCreationService;
        this.saleService = saleService;
        this.customerService = customerService;
        this.carService = carService;
    }


    @GetMapping()
    public ResponseEntity getAllSales(@RequestParam Map<String, String> allParams) {
        Sale sale = new Sale();
        if(allParams.get("sellPrice") != null) {
            sale.setSellPrice(Integer.parseInt(allParams.get("sellPrice")));
        }
        if(allParams.get("sellDate") != null) {
            try {
                sale.setSellDate(new SimpleDateFormat("yyyy-MM-dd").parse(allParams.get("sellDate")));
            } catch (java.text.ParseException e) {
                System.out.println("Parse Exception error logged");
            }
        }
        Example<Sale> saleExample = Example.of(sale, ExampleMatcher.matchingAll().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));

        return new ResponseEntity<List<ResponseSale>>(responseConverterService.convertSaleListToResponseList(saleService.findAll(saleExample)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDateById(@PathVariable int id) {
        return new ResponseEntity<ResponseSale>(responseSaleCreationService.createNewResponseSale(saleService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/date/")
    public ResponseEntity getSaleByDate(@RequestParam java.sql.Date date) {
        return new ResponseEntity<List<ResponseSale>>(responseConverterService.convertSaleListToResponseList(saleService.findByDate(date)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addNewSale(@RequestBody ReceiverSale receiverSale) {
        Employee employee = employeeService.findById(receiverSale.getEmployee_id()).orElse(new Employee());
        Customer customer = customerService.findById(receiverSale.getCustomer_id()).orElse(new Customer());
        Car car = carService.findById(receiverSale.getCar_id()).orElse(new Car());
        Sale newSale = new Sale(receiverSale, employee, customer, car);
        employee.getSales().add(newSale);
        employee.setSoldNumber(employee.getSoldNumber() + 1);
        customer.getPurchases().add(newSale);
        customer.setPurchaseNumber(customer.getPurchaseNumber() + 1);
        car.setSale(newSale);
        saleService.addNewSale(newSale);
        return new ResponseEntity<ResponseSale>(responseSaleCreationService.createNewResponseSale(newSale), HttpStatus.OK);
    }
}
