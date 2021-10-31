package com.example.springboot_carapi.controller;

import com.example.springboot_carapi.Model.Car;
import com.example.springboot_carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    public List<Car> InitDB() throws IOException {
        return carService.getAllCar();
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body( carService.getCarById(id));
    }
    @GetMapping("/carsOrigin/{countryOfOrigin}/")
    public ResponseEntity<Map<String, Object>> findByCountryOfOrigin(@PathVariable("countryOfOrigin") String countryOfOrigin, @RequestParam("size") int size, @RequestParam(defaultValue = "0") int page) {
        return carService.getCarByCountryOfOrigin(countryOfOrigin,page,size);
    }
}