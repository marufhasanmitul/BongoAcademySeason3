package com.maruftech.bongoacademyoop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay=findViewById(R.id.tvDisplay);

        tvDisplay.setText("");


        //==Class and Object Concept===

        Employee employee1=new Employee();
        employee1.setName("Maruf Hasan");
        employee1.setPosition("Developer");
        employee1.setSalary(1000);



        tvDisplay.append("\n Name :"+employee1.getName());
        tvDisplay.append("\n Position :"+employee1.getPosition());
        tvDisplay.append("\n Salary :"+employee1.getSalary()+"USD");




    }
}