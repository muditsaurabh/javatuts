package com.saurabh;

import java.util.Date;

/**
 * Created by muditsaurabh on 11/10/16.
 */
public class Student extends Person {

    public Student(Major major, String name, Date dateOfBirth) {
        super(name, dateOfBirth);
        this.major = major;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "major=" + major +
                '}';
    }

    private Major major;
}
