package com.example.springboot_carapi.controller;

import com.example.springboot_carapi.Model.Car;
import com.example.springboot_carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    public List<Car> InitDB() throws IOException {
        System.out.println("Connnnnnnnnnntroller *************");
        //carService.initCarDB();
        return carService.getAllCar();
        //carService.paging("Germany",1,100);
    }

    @GetMapping("/car/{id}")
    public void findById(@PathVariable("id") int id,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "20") int size) {
        System.out.println("Connnnnnnnnnntroller carrrrr *************"+id);
        carService.getCarById(id);
    }

}