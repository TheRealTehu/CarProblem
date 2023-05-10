package org.example.data.employee;

import org.example.data.Car;

public class Driver extends Employee{
    private Car car;

    public Driver(String name, Car car) {
        super(name);
        this.car = car;
    }
}
