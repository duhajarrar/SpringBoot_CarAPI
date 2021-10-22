package com.example.springboot_carapi.Model;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    @Column
    private String carBrand;
    @Column
    private String countryOfOrigin;

    public Car(String carBrand, String countryOfOrigin) {
        this.carBrand = carBrand;
        this.countryOfOrigin = countryOfOrigin;
    }

    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        return id+" //////// "+carBrand+" ******* "+countryOfOrigin;
    }
}
