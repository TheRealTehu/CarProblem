package org.example.data.employee;

import java.util.HashSet;
import java.util.Set;

public abstract class Employee {
    protected String name;
    private final Set<Employee> peopleToAvoid;

    public Employee(String name) {
        this.name = name;
        peopleToAvoid = new HashSet<>();
    }

    public void addPersonToAvoid(Employee employee) {
        peopleToAvoid.add(employee);
    }

    public boolean wantToAvoid(Employee employee) {
        return peopleToAvoid.contains(employee);
    }
}
