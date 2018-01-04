package com.example.nurzat.test;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nurzat on 1/4/18.
 */

public class GetJson {
    GetJson.GetJsonInterface getJsonInterface;

    public GetJson(GetJsonInterface s){
        getJsonInterface =s;
    }

    public interface GetJsonInterface {
        void GetJsonInterfaceTest(List<Example> response);
    }

    public void getJson() {
        ApiService service = BaseApi.getRetrofit().create(ApiService.class);
        Call<List<Example> > call = service.getAllJson();
        call.enqueue(new Callback<List<Example> >() {
            @Override
            public void onResponse(Call<List<Example> > call, Response<List<Example> > response) {
                getJsonInterface.GetJsonInterfaceTest(response.body());
            }
            @Override
            public void onFailure(Call<List<Example> > call, Throwable t) {
                Log.d("FUN"," throwable"+t.getLocalizedMessage());
                getJsonInterface.GetJsonInterfaceTest(null);

            }
        });
    }
}
