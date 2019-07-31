package com.credera.CarDealershipApplication.Service;

import com.credera.CarDealershipApplication.Model.Sale;
import com.credera.CarDealershipApplication.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Sale> findAll() {
        return saleRepository.findAll();
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
