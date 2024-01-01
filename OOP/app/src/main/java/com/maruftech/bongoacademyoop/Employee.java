package com.maruftech.bongoacademyoop;

public class Employee {
    private  String name;
    private String position;
    private  float salary;

    void setName(String name){
        this.name=name;
    }

    String getName(){
        return name;
    }

    void setPosition(String position){
        this.position=position;
    }

    String getPosition(){
        return position;
    }

    void setSalary(float salary){
        this.salary=salary;
    }

    float getSalary(){
        return salary;
    }


}
