package com.maruftech.bongoacademyoop;

import android.util.Log;

public class Employee {
    private  String name;
    private String position;
    private  float salary;

    public Employee(String name,String position,float salary){
        this.name=name;
        this.position=position;
        this.salary=salary;
    }


    public Employee(String name,String position,float salary,float absent){
        this.name=name;
        this.position=position;
        this.salary=salary-(absent*100);
    }






    public String getName(){

        return name;

    }

    public float getSalary(){

        return salary;

    }



}
