package com.maruftech.bongoacademyoop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,mobile;
    Button InsetDataBtn,showResultBtn;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        mobile=findViewById(R.id.mobile);
        InsetDataBtn=findViewById(R.id.InsetDataBtn);
        showResultBtn=findViewById(R.id.showResultBtn);


        databaseHelper=new DatabaseHelper(MainActivity.this);

        InsetDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.insertData(name.getText().toString(),mobile.getText().toString());
                Toast.makeText(MainActivity.this, "Data Has been Inserted", Toast.LENGTH_SHORT).show();
            }
        });










    }
}