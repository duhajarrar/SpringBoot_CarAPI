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
    List<Car> findByCountryOfOrigin(String countryOfOrigin,Pageable p);
}


