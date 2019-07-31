package com.credera.CarDealershipApplication.Controller;

import com.credera.CarDealershipApplication.Model.*;
import com.credera.CarDealershipApplication.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dealership/cars")
public class CarController {

    private CarService carService;
    private ResponseConverterService responseConverterService;
    private ResponseCarCreationService responseCarCreationService;

    @Autowired
    public CarController(CarService carService, ResponseConverterService responseConverterService, ResponseCarCreationService responseCarCreationService) {
        this.carService = carService;
        this.responseCarCreationService = responseCarCreationService;
        this.responseConverterService = responseConverterService;
    }

    @GetMapping("/")
    public ResponseEntity getAllCars() {
        return new ResponseEntity<List<ResponseCar>>(responseConverterService.convertCarListToResponseList(carService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarById(@PathVariable int id) {
        return new ResponseEntity<ResponseCar>(responseCarCreationService.createNewResponseCar(carService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/pricemin/")
    public ResponseEntity getCarByMinPrice(@RequestParam int price) {
        return new ResponseEntity<List<ResponseCar>>(responseConverterService.convertCarListToResponseList(carService.findByMinPrice(price)), HttpStatus.OK);
    }

    @GetMapping("/pricemax/")
    public ResponseEntity getCarByMaxPrice(@RequestParam int price) {
        return new ResponseEntity<List<ResponseCar>>(responseConverterService.convertCarListToResponseList(carService.findByMaxPrice(price)), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity addNewCar(@RequestBody ReceiverCar receiverCar) {
        Car newCar = new Car(receiverCar);
        carService.addNewCar(newCar);
        return new ResponseEntity<ResponseCar>(responseCarCreationService.createNewResponseCar(newCar), HttpStatus.OK);
    }
}
