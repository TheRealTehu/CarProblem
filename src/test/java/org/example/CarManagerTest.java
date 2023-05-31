package org.example;

import org.example.data.Car;
import org.example.data.employee.Driver;
import org.example.data.employee.Employee;
import org.example.data.employee.Passenger;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {

    private CarManager carManager;

    @Test
    void testCountUnhappyCarsWhenHasZeroCarsOrEmployees() {
        carManager = new CarManager(new HashSet<>(), new HashSet<>());

        int expected = 0;

        int actual = carManager.countUnhappyCars();

        assertEquals(expected, actual);
    }
    @Test
    void testCountUnhappyCarsWhenHasOneCarWithTwoEmployeesAndOneEmployeeWantsToAvoidTheOther() {
        Car car = new Car("ASD-123", 5);
        Employee employee1 = new Driver("Driver", car);
        Employee employee2 = new Passenger("Pass1");

        employee2.addPersonToAvoid(employee1);

        car.addPassenger(employee1);
        car.addPassenger(employee2);

        carManager = new CarManager(Set.of(car), Set.of(employee1, employee2));

        int expected = 1;

        int actual = carManager.countUnhappyCars();

        assertEquals(expected, actual);
    }

    @Test
    void testCountUnhappyCarsWhenHasOnlyOneHappyCar() {
        Car car = new Car("ASD-123", 5);
        Employee employee1 = new Driver("Driver", car);
        Employee employee2 = new Passenger("Pass1");

        car.addPassenger(employee1);
        car.addPassenger(employee2);

        carManager = new CarManager(Set.of(car), Set.of(employee1, employee2));

        int expected = 0;

        int actual = carManager.countUnhappyCars();

        assertEquals(expected, actual);
    }

    @Test
    void testCountUnhappyCarsWhenHasOneHappyCarAndOneUnhappyCar() {
        Car car = new Car("ASD-123", 5);
        Employee employee1 = new Driver("Driver", car);
        Employee employee2 = new Passenger("Pass1");

        Car car2 = new Car("LIC-342", 5);
        Employee employee3 = new Driver("Driver2", car2);
        Employee employee4 = new Passenger("Pass2");

        car.addPassenger(employee1);
        car.addPassenger(employee2);

        employee3.addPersonToAvoid(employee4);

        car2.addPassenger(employee3);
        car2.addPassenger(employee4);

        carManager = new CarManager(Set.of(car, car2), Set.of(employee1, employee2, employee3, employee4));

        int expected = 1;

        int actual = carManager.countUnhappyCars();

        assertEquals(expected, actual);
    }

    @Test
    void testCountUnhappyCarsWhenHasTwoCarsWithPeopleWhoWantToAvoidEachOtherAndTheyAreNotInTheSameCar() {
        Car car = new Car("ASD-123", 5);
        Car car2 = new Car("EFG-456", 5);
        Employee employee1 = new Driver("Driver", car);
        Employee employee2 = new Driver("Driver2", car2);

        employee1.addPersonToAvoid(employee2);
        employee2.addPersonToAvoid(employee1);

        car.addPassenger(employee1);
        car2.addPassenger(employee2);

        carManager = new CarManager(Set.of(car, car2), Set.of(employee1, employee2));

        int expected = 0;

        int actual = carManager.countUnhappyCars();

        assertEquals(expected, actual);
    }

    @Test
    void OPTIONAL_testCanStartTheTripWhenHasOneFullCarWhichHasDriver() {
        Car car = new Car("ASD-123", 5);
        Employee employee1 = new Driver("Driver", car);
        Employee employee2 = new Passenger("Pass1");
        Employee employee3 = new Passenger("Pass2");
        Employee employee4 = new Passenger("Pass3");
        car.addPassenger(employee1);
        car.addPassenger(employee2);
        car.addPassenger(employee3);
        car.addPassenger(employee4);
        carManager = new CarManager(Set.of(car), Set.of(employee1, employee2, employee3, employee4));

        assertTrue(carManager.canStartTheTrip());
    }

    @Test
    void OPTIONAL_testCanStartTheTripWhenHasMoreEmployeesThanPeopleInCars() {
        Car car = new Car("ASD-123", 5);
        Employee employee1 = new Driver("Driver", car);
        Employee employee2 = new Passenger("Pass1");
        Employee employee3 = new Passenger("Pass2");
        Employee employee4 = new Passenger("Pass3");

        car.addPassenger(employee1);
        car.addPassenger(employee2);

        carManager = new CarManager(Set.of(car), Set.of(employee1, employee2, employee3, employee4));

        assertFalse(carManager.canStartTheTrip());
    }

    @Test
    void OPTIONAL_testCanStartTheTripWhenCarHasNoDrivers() {
        Car car = new Car("ASD-123", 5);
        Employee employee1 = new Driver("Driver", car);
        Employee employee2 = new Passenger("Pass1");
        Employee employee3 = new Passenger("Pass2");
        Employee employee4 = new Passenger("Pass3");

        car.addPassenger(employee2);
        car.addPassenger(employee3);
        car.addPassenger(employee4);

        carManager = new CarManager(Set.of(car), Set.of(employee1, employee2, employee3, employee4));

        assertFalse(carManager.canStartTheTrip());
    }
}