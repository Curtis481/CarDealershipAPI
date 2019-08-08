package com.credera.CarDealershipApplication.Car;

import com.credera.CarDealershipApplication.Car.Car;
import com.credera.CarDealershipApplication.Car.ResponseCar;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponseCarCreationService {

    public ResponseCar createNewResponseCar(Car car) {
        return new ResponseCar(car);
    }

    public ResponseCar createNewResponseCar(Optional<Car> optionalCar) {
        Car car = optionalCar.orElse(new Car());
        return new ResponseCar(car);
    }
}
