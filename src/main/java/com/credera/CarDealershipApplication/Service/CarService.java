package com.credera.CarDealershipApplication.Service;

import com.credera.CarDealershipApplication.Model.Car;
import com.credera.CarDealershipApplication.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Optional<Car> findById(int id) {
        return carRepository.findById(id);
    }

    public List<Car> findByMinPrice(int price) {
        return carRepository.findByMinPrice(price);
    }

    public List<Car> findByMaxPrice(int price) {
        return carRepository.findByMaxPrice(price);
    }

    public void addNewCar(Car newCar) {
        carRepository.save(newCar);
    }
}
