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

        Employee employee2=new Employee("Maruf Hasan","CEO",1000,5);
        tvDisplay.setText("Salary: "+employee2.getSalary());






    }
}