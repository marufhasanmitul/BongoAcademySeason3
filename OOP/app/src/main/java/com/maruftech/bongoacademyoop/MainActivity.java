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
        employee1.name="Maruf Hasan";
        employee1.position="Developer";
        employee1.salary=1000;

        Employee employee2=new Employee();
        employee2.name="Jubayer Hossain";
        employee2.position="CEO";
        employee2.salary=1000;

        tvDisplay.append("\n Name :"+employee1.name);
        tvDisplay.append("\n Position :"+employee1.position);
        tvDisplay.append("\n Salary :"+employee1.salary+"USD");

        tvDisplay.append("\n \n Name :"+employee2.name);
        tvDisplay.append("\n Position :"+employee2.position);
        tvDisplay.append("\n Salary :"+employee2.salary+" USD");


    }
}