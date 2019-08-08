package com.credera.CarDealershipApplication.Car;

import com.credera.CarDealershipApplication.Service.*;
import org.springframework.data.domain.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dealership/cars")
public class CarController {

    private CarService carService;
    private ResponseConverterService responseConverterService;
    private ResponseCarCreationService responseCarCreationService;
    private CarDetailsClient carDetailsClient;

    @Autowired
    public CarController(CarService carService, ResponseConverterService responseConverterService, ResponseCarCreationService responseCarCreationService, CarDetailsClient carDetailsClient) {
        this.carService = carService;
        this.responseCarCreationService = responseCarCreationService;
        this.responseConverterService = responseConverterService;
        this.carDetailsClient = carDetailsClient;
    }

    @GetMapping()
    public ResponseEntity getAllCars(@RequestParam Map<String, String> allParams) {
        Car car = new Car();
        if(allParams.get("price") != null) {
            car.setPrice(Integer.parseInt(allParams.get("price")));
        }
        if(allParams.get("year") != null) {
            car.setYear(Integer.parseInt(allParams.get("year")));
        }
        car.setColor(allParams.get("color"));
        car.setMake(allParams.get("make"));
        car.setModel(allParams.get("model"));
        Example<Car> exampleCar = Example.of(car, ExampleMatcher.matchingAll().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return new ResponseEntity<List<ResponseCar>>(responseConverterService.convertCarListToResponseList(carService.findAll(exampleCar)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarById(@PathVariable int id) {
        ResponseCar responseCar = responseCarCreationService.createNewResponseCar(carService.findById(id));
        ResponseCarWithDetails responseCarWithDetails = new ResponseCarWithDetails();
        if(responseCar.getMake() != null) {
            responseCarWithDetails = new ResponseCarWithDetails(responseCar, carDetailsClient.getRequestCarDetails(responseCar.getMake(), responseCar.getModel(), responseCar.getYear()));
        }
        return new ResponseEntity<ResponseCarWithDetails>(responseCarWithDetails, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addNewCar(@RequestBody ReceiverCar receiverCar) {
        Car newCar = new Car(receiverCar);
        carService.addNewCar(newCar);
        return new ResponseEntity<ResponseCar>(responseCarCreationService.createNewResponseCar(newCar), HttpStatus.OK);
    }
}
