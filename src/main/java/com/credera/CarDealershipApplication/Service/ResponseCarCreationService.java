package com.credera.CarDealershipApplication.Service;

import com.credera.CarDealershipApplication.Model.Car;
import com.credera.CarDealershipApplication.Model.ResponseCar;
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
