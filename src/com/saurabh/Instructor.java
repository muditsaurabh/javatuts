package com.saurabh;

import java.util.Date;

/**
 * Created by muditsaurabh on 11/10/16.
 */
public class Instructor extends Person {
    public Instructor(String name, Date dateOfBirth, Double salary) {
        super(name, dateOfBirth);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "salary=" + salary +
                '}';
    }

    private Double salary;
}
