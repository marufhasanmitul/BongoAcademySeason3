package com.maruftech.expencetrackerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowDeatils extends AppCompatActivity {
    TextView tvDisplayData;
    RecyclerView recyclerViewViewId;
    DatabaseHelper databaseHelper;
    ArrayList<HashMap<String,String>>arrayList;
    HashMap<String,String>hashMap;
    public static boolean EXPENSE=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_deatils);
        tvDisplayData=findViewById(R.id.tvDisplayData);
        recyclerViewViewId=findViewById(R.id.recyclerViewViewId);
        databaseHelper=new DatabaseHelper(ShowDeatils.this);


        if(EXPENSE==true) tvDisplayData.setText("Showing All Expense");
        else tvDisplayData.setText("Showing All InCome");

        loadData();




    }

    //=================================================

    public void loadData(){

        Cursor cursor=null;

        if(EXPENSE==true){
             cursor=databaseHelper.showAllData();
        }else {
             cursor=databaseHelper.showAllInCome();
        }


        if(cursor !=null && cursor.getCount()>0){
            arrayList=new ArrayList<>();


            while (cursor.moveToNext()){
                int id=cursor.getInt(0);
                String amount=cursor.getString(1);
                String reasons=cursor.getString(2);
                double time=cursor.getDouble(3);

                hashMap=new HashMap<>();
                hashMap.put("id",""+id);
                hashMap.put("amount",""+amount);
                hashMap.put("reasons",""+reasons);
                hashMap.put("time",""+time);
                arrayList.add(hashMap);


            }

            MyAdapter myAdapter=new MyAdapter();
            recyclerViewViewId.setAdapter(myAdapter);
            recyclerViewViewId.setLayoutManager(new LinearLayoutManager(this));


        }else {
            tvDisplayData.append("\n No Data Found");
        }

    }




    //=================================================

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        private class MyViewHolder extends RecyclerView.ViewHolder{

            TextView purposeDetails,tvExpenseDetails,tvDelete;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                purposeDetails=itemView.findViewById(R.id.purposeDetails);
                tvExpenseDetails=itemView.findViewById(R.id.tvExpenseDetails);
                tvDelete=itemView.findViewById(R.id.tvDelete);
            }
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater=getLayoutInflater();
            View myView=inflater.inflate(R.layout.item,parent,false);
            return new MyViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                HashMap<String,String>hashMap1=arrayList.get(position);
                String id=hashMap1.get("id");
                String amount=hashMap1.get("amount");
                String reasons=hashMap1.get("reasons");
                String time=hashMap1.get("time");

            Log.d("SerRes",id);

            holder.purposeDetails.setText(reasons);
            holder.tvExpenseDetails.setText(amount);
            holder.tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseHelper.deleteById(id);
                    loadData();
                }
            });
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }



}