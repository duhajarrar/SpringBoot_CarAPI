package com.example.springboot_carapi.repository;

import com.example.springboot_carapi.Model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car,Integer> {
    Page<Car> findByCountryOfOrigin(String countryOfOrigin,Pageable p);
}


