package com.example.abhij.restapiconnection;

import java.io.Serializable;

/**
 * Created by abhij on 31-03-2018.
 */

public class Student implements Serializable {

     String _id;
     String name;
     int roll;
     float percentage;
     String schoolName;

    public Student(String name, int roll, float percentage, String schoolName) {
        this.name = name;
        this.roll = roll;
        this.percentage = percentage;
        this.schoolName = schoolName;
    }

    public Student(String _id, String name, int roll, float percentage, String schoolName) {

        this._id=_id;
        this.name = name;
        this.roll = roll;
        this.percentage = percentage;
        this.schoolName = schoolName;
    }

    public Student() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
