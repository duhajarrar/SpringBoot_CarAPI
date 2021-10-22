package com.example.springboot_carapi.repository;

import com.example.springboot_carapi.Model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car,Integer> {
   // Map<Object, Object> findByCountryOfOrigin(String countryOfOrigin);
    //Page<Car> findAll(Pageable pageable);
    //Page<Car> findByCountryOfOrigin(String countryOfOrigin, Pageable pageable);
}


