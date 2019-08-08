package com.credera.CarDealershipApplication.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("FROM Car car WHERE price >= :price")
    List<Car> findByMinPrice(@Param("price") Integer price);

    @Query("SELECT car from Car car WHERE price <= :price")
    List<Car> findByMaxPrice(@Param("price") Integer price);
}
