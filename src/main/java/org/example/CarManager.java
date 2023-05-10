package org.example;

import org.example.data.Car;
import org.example.data.employee.Employee;

import java.util.Set;

public class CarManager {
    private final Set<Car> cars;
    private final Set<Employee> employees;

    public CarManager(Set<Car> cars, Set<Employee> employees) {
        this.cars = cars;
        this.employees = employees;
    }

    public boolean canStartTheTrip() {
        return allCarsAreDrivable() && everyEmployeeIsInACar();
    }

    public int countUnhappyCars() {
        return (int) cars.stream().filter(car -> !car.isHappyCar()).count();
    }

    private boolean everyEmployeeIsInACar() {
        for (Employee employee : employees) {
            if (!employeeIsInCar(employee)) {
                return false;
            }
        }
        return true;
    }

    private boolean employeeIsInCar(Employee employee) {
        for (Car car : cars) {
            if (car.containsPassenger(employee)) {
                return true;
            }
        }
        return false;
    }

    private boolean allCarsAreDrivable() {
        for (Car car : cars) {
            if (!car.isDrivable()) {
                return false;
            }
        }
        return true;
    }


}
