package com.credera.CarDealershipApplication.Sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private SaleRepository saleRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> findAll(Example<Sale> saleExample) {
        return saleRepository.findAll(saleExample);
    }

    public Optional<Sale> findById(int id) {
        return saleRepository.findById(id);
    }

    public List<Sale> findByDate(java.sql.Date date) {
        return saleRepository.findByDate(date);
    }

    public void addNewSale(Sale newSale) {
        saleRepository.save(newSale);
    }

}
