package com.maruftech.englishtobangladictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewId;
    EditText searchViewId;

    DatabaseHelper databaseHelper;

    ArrayList<HashMap<String,String>>arrayList;
    HashMap<String,String>hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewId=findViewById(R.id.recyclerViewId);

        searchViewId=findViewById(R.id.searchViewId);

        databaseHelper=new DatabaseHelper(MainActivity.this);

        loadData(databaseHelper.getAllData());



        searchViewId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String key=searchViewId.getText().toString().trim();
                loadData(databaseHelper.searchData(key));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });















        MyAdapter myAdapter=new MyAdapter();
        recyclerViewId.setAdapter(myAdapter);
        recyclerViewId.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }


//=============================================

    private void loadData(Cursor cursor){
        //Cursor cursor=databaseHelper.getAllData();

        if(cursor !=null && cursor.getCount()>0){
            arrayList=new ArrayList<>();
            while (cursor.moveToNext()){
                int id=cursor.getInt(0);
                String word=cursor.getString(1);
                String meaning=cursor.getString(2);
                String partsOfSpeech=cursor.getString(3);
                String example=cursor.getString(4);

                hashMap=new HashMap<>();
                hashMap.put("id",""+id);
                hashMap.put("word",""+word);
                hashMap.put("meaning",""+meaning);
                hashMap.put("partsOfSpeech",""+partsOfSpeech);
                hashMap.put("example",""+example);
                arrayList.add(hashMap);

            }
        }
    }
//=============================================
//=============================================
    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvWord,tvMeaning,tvExample;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWord=itemView.findViewById(R.id.tvWord);
            tvMeaning=itemView.findViewById(R.id.tvMeaning);
            tvExample=itemView.findViewById(R.id.tvExample);
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
        HashMap<String,String> hashMap=arrayList.get(position);
        String id=hashMap.get("id");
        String word=hashMap.get("word");
        String meaning=hashMap.get("meaning");
        String partsOfSpeech=hashMap.get("partsOfSpeech");
        String example=hashMap.get("example");

        holder.tvWord.setText(""+word+" ("+partsOfSpeech+")");
        holder.tvMeaning.setText(""+meaning);
        holder.tvExample.setText(""+example);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    }



//=============================================
}