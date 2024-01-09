package com.maruftech.expencetrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddData extends AppCompatActivity {
    TextView tvTitle;
    EditText edAmount,edPurpase;
    Button btnInsert;
    DatabaseHelper dbhelper;

    public static boolean EXPENSE=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        tvTitle=findViewById(R.id.tvTitle);
        edAmount=findViewById(R.id.edAmount);
        edPurpase=findViewById(R.id.edPurpase);
        btnInsert=findViewById(R.id.btnInsert);

        dbhelper=new DatabaseHelper(AddData.this);

        if(EXPENSE==true){
            tvTitle.setText("ADD Expnse");
        }else {
            tvTitle.setText("ADD Income");
        }


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sAmount=edAmount.getText().toString();
                String edPurpose=edPurpase.getText().toString();
                double amount=Double.parseDouble(sAmount);

                if(EXPENSE==true){
                    dbhelper.addExpence(amount,edPurpose);
                    tvTitle.setText("Expense Added");
                }else {
                    dbhelper.addIncome(amount,edPurpose);
                    tvTitle.setText("Income Added");
                }




            }
        });






    }
}