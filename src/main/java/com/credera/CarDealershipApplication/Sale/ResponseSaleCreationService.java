package com.credera.CarDealershipApplication.Sale;


import com.credera.CarDealershipApplication.Car.ResponseCarCreationService;
import com.credera.CarDealershipApplication.Sale.ResponseSale;
import com.credera.CarDealershipApplication.Sale.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponseSaleCreationService {

    private ResponseCarCreationService responseCarCreationService;

    @Autowired
    public ResponseSaleCreationService(ResponseCarCreationService responseCarCreationService) {
        this.responseCarCreationService = responseCarCreationService;
    }

    public ResponseSale createNewResponseSale(Sale sale) {
        return new ResponseSale(sale, responseCarCreationService.createNewResponseCar(sale.getCar()));
    }

    public ResponseSale createNewResponseSale(Optional<Sale> optionalSale) {
        Sale sale = optionalSale.orElse(new Sale());
        return new ResponseSale(sale, responseCarCreationService.createNewResponseCar(sale.getCar()));
    }
}
