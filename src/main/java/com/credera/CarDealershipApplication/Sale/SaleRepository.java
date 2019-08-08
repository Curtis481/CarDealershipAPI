package com.credera.CarDealershipApplication.Sale;

import com.credera.CarDealershipApplication.Sale.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query("SELECT sale from Sale sale WHERE sell_date = :sell_date")
    List<Sale> findByDate(@Param("sell_date") java.sql.Date sell_date);
}
