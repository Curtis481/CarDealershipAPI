package com.credera.CarDealershipApplication.Car;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class CarDetailsClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<CarDetails> getRequestCarDetails(String make, String model, int year) {

        String url = "https://apis.solarialabs.com/shine/v1/vehicle-stats/specs?make={make}&model={model}&year={year}&apikey=KDC3G9AuBTFKiqvov4Nh3y518blSkzUt";

        return restTemplate.getForObject(
                url,
                List.class,
                make,
                model,
                year
        );

    }
}
