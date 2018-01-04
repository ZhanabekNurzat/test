package com.example.nurzat.test;

/**
 * Created by nurzat on 1/4/18.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleHolder>{
    List<Example> item;
    Context context;
    public ExampleAdapter(Context context, List<Example> item){
        this.item=item;
        this.context = context;
    }

    @Override
    public ExampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ExampleHolder pvh = new ExampleHolder(context,v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ExampleHolder holder,final int position) {
        holder.setInfo(item.get(position).getLastName() + " " + item.get(position).getFirstName(),
                item.get(position).getEmail(),
                item.get(position).getPhoto());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Description.class);
                i.putExtra("des", new Gson().toJson(item.get(position)));
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}

