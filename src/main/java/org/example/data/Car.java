package org.example.data;

import org.example.data.employee.Driver;
import org.example.data.employee.Employee;

import java.util.HashSet;
import java.util.Set;

public class Car {
    private final String licencePlate;
    private final int numberOfSeats;
    private final Set<Employee> passengers;

    public Car(String licencePlate, int numberOfSeats) {
        this.licencePlate = licencePlate;
        this.numberOfSeats = numberOfSeats;
        passengers = new HashSet<>();
    }

    public void addPassenger(Employee employee) {
        passengers.add(employee);
    }

    public int getNumberOfPassengers() {
        return passengers.size();
    }

    public boolean containsPassenger(Employee employee) {
        return passengers.contains(employee);
    }

    public boolean isDrivable() {
        return passengers.size() <= numberOfSeats && hasDriver();
    }

    private boolean hasDriver() {
        for (Employee passenger : passengers) {
            if (passenger instanceof Driver) {
                return true;
            }
        }
        return false;
    }

    public boolean isHappyCar() {
        for (Employee passenger: passengers) {
            for (Employee other: passengers) {
                if(!passenger.equals(other) && passenger.wantToAvoid(other)) {
                    return false;
                }
            }
        }
        return true;
    }
}
