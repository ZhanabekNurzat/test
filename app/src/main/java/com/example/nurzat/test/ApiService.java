package com.example.nurzat.test;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    /**
     * Authentication user
     */
    @GET("v2/5a488f243000004c15c3c57e")
    Call<List<Example>> getAllJson();




}
