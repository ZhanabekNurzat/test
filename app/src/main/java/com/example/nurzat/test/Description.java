package com.example.nurzat.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;

public class Description extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView female;
    TextView ip;
    ImageView back;
    TextView emp;
    TextView pos;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        name = (TextView)findViewById(R.id.des_name);
        email = (TextView)findViewById(R.id.des_email);
        female = (TextView)findViewById(R.id.famale);
        ip = (TextView)findViewById(R.id.ip_address);
        emp = (TextView)findViewById(R.id.emp);
        pos = (TextView)findViewById(R.id.position);
        im = (ImageView)findViewById(R.id.des_face);
        back = (ImageView)findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Description.this.onBackPressed();
            }
        });
        final Type baseType = new TypeToken<Example>() {}.getType();
        Example example = new Gson().fromJson(getIntent().getStringExtra("des"), baseType);
        name.setText(example.getLastName() + " " + example.getFirstName());
        email.setText(example.getEmail());
        female.setText(female.getText() + example.getGender());
        ip.setText(ip.getText() + example.getIpAddress());
        emp.setText(emp.getText() + example.getEmployment().getName());
        pos.setText(pos.getText() + example.getEmployment().getPosition());
        Picasso.with(this).load(example.getPhoto().replace("http","https")).into(im);

    }

}
