package org.example.data.employee;

public class Passenger extends Employee{
    public Passenger(String name) {
        super(name);
    }

    public void changeRadio() {
        System.out.println("Radio changed by: " + this.name);
    }
}
