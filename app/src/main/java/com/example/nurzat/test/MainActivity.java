package com.example.nurzat.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements GetJson.GetJsonInterface{
    RecyclerView recyclerView;
    ExampleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        final LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        GetJson getJson = new GetJson(this);
        getJson.getJson();
    }

    @Override
    public void GetJsonInterfaceTest(List<Example> response) {
        //здесь можно сделать загрузку;
        adapter = new ExampleAdapter(this,response);
        recyclerView.setAdapter(adapter);
    }
}
