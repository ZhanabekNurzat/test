package com.example.nurzat.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by nurzat on 1/4/18.
 */

public class ExampleHolder extends RecyclerView.ViewHolder{
    public TextView name;
    public TextView email;
    public ImageView face;
    Context context;
    LinearLayout linearLayout;
    public ExampleHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        linearLayout = (LinearLayout)itemView.findViewById(R.id.item_id);
        name = (TextView) itemView.findViewById(R.id.name);
        face = (ImageView) itemView.findViewById(R.id.image_face);
        email = (TextView)itemView.findViewById(R.id.email);
    }
    public void setInfo(String n,String e,String im){
        name.setText(n);
        email.setText(e);
        String aUrl = im.replace("http", "https");
        Picasso.with(context).load(aUrl).into(face);
    }

}
