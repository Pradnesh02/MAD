package com.example.studentlistapp;

import java.io.Serializable;

public class Student implements Serializable {

    String name, roll, phone;

    public Student(String name, String roll, String phone) {
        this.name = name;
        this.roll = roll;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getRoll() { return roll; }
    public String getPhone() { return phone; }
}