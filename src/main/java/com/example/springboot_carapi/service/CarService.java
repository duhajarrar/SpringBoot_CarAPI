package com.example.springboot_carapi.service;

import com.example.springboot_carapi.Model.Car;
import com.example.springboot_carapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @PostConstruct
    public void initCarDB() throws IOException {
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/cars.csv"));
        line = br.readLine();
        while ((line = br.readLine()) != null) {
            String s[]=line.split(",");
            if(s.length == 2){
                Car c = new Car(s[0], s[1]);
                carRepository.save(c);
                System.out.println(c.toString()+"|||| len="+s.length);
            }


        }

    }
    public List<Car> getAllCar()
    {
        List<Car> carList = new ArrayList<Car>();
        carRepository.findAll().forEach(car -> carList.add(car));
        return carList;
    }

    public Car getCarById(int id)
    {
        System.out.println(carRepository.findById(id).get()+" >>>> "+id);
        return carRepository.findById(id).get();
    }

    public Page<Car> getCarByCountryOfOrigin(String countryOfOrigin,Pageable page) {
        return carRepository.findByCountryOfOrigin(countryOfOrigin,page);
    }

//    public ResponseEntity<Map<String, Object>> paging(String countryOfOrigin,int page,int size){
//        try {
//            List<Car> cars = new ArrayList<Car>();
//            Pageable paging = PageRequest.of(page, size);
//            Page<Car> pageTuts;
//            if (countryOfOrigin == null){
//                pageTuts = carRepository.findAll(paging);
//                System.out.println("************ find all ***************");
//            }else {
//                pageTuts = carRepository.findByCountryOfOrigin(countryOfOrigin, paging);
//                System.out.println("************ "+countryOfOrigin+" *************** page="+page+" size="+size);
//            }
//            cars = pageTuts.getContent();
//            System.out.println(cars+"++++++++++++++++++ len="+cars.size());
//            Map<String, Object> response = new HashMap<>();
//            response.put("cars", cars);
//            response.put("currentPage", pageTuts.getNumber());
//            response.put("totalItems", pageTuts.getTotalElements());
//            response.put("totalPages", pageTuts.getTotalPages());
//
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
