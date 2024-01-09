package com.maruftech.expencetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvFinalBalance,totalExpence,tvAddExpence,tvExpenceShowAllData,tvIncomeTotalBalance,addIncome,tvIncomeShowAllData;
    DatabaseHelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvFinalBalance=findViewById(R.id.tvFinalBalance);
        totalExpence=findViewById(R.id.totalExpence);
        tvAddExpence=findViewById(R.id.tvAddExpence);
        tvExpenceShowAllData=findViewById(R.id.tvExpenceShowAllData);
        tvIncomeTotalBalance=findViewById(R.id.tvIncomeTotalBalance);
        addIncome=findViewById(R.id.addIncome);
        tvFinalBalance=findViewById(R.id.tvFinalBalance);
        tvIncomeShowAllData=findViewById(R.id.tvIncomeShowAllData);

        dbhelper=new DatabaseHelper(MainActivity.this);

        tvAddExpence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData.EXPENSE=true;
                startActivity(new Intent(MainActivity.this, AddData.class));
            }
        });

        addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData.EXPENSE=false;
                startActivity(new Intent(MainActivity.this, AddData.class));
            }
        });

        tvExpenceShowAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDeatils.EXPENSE=true;
                startActivity(new Intent(MainActivity.this,ShowDeatils.class));
            }
        });

        tvIncomeShowAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDeatils.EXPENSE=false;
                startActivity(new Intent(MainActivity.this,ShowDeatils.class));
            }
        });




        updateUI();








    }

//=============================================================
    public void updateUI(){
        totalExpence.setText("BDT "+dbhelper.calculateTotalExpense());
        tvIncomeTotalBalance.setText("BDT "+dbhelper.calculateTotalIncome());
        double balance=dbhelper.calculateTotalIncome()-dbhelper.calculateTotalExpense();
        tvFinalBalance.setText("BDT"+balance);
    }
//===================================================================


    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }
}
