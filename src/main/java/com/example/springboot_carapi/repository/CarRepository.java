package com.example.springboot_carapi.repository;

import com.example.springboot_carapi.Model.Car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car,Integer> {
    @Query("select c.carBrand from Car c where c.countryOfOrigin = ?1")
    List<Car> findByCountryOfOrigin(String countryOfOrigin);
    // Map<Object, Object> findByCountryOfOrigin(String countryOfOrigin);
    //Page<Car> findAll(Pageable pageable);
    //Page<Car> findByCountryOfOrigin(String countryOfOrigin, Pageable pageable);
}


