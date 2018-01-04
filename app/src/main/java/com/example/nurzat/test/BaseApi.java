package com.example.nurzat.test;



import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * Created by Admin on 15.04.2017.
 */

public class BaseApi {
    public static final String BASE_URL = " http://www.mocky.io/";
    private static Retrofit retrofit = null;
    public static Retrofit getRetrofit() {

        int cacheSize = 10 * 1024 * 1024; // 10 MB
//        Cache = new Cache( new File( AdeptAndroid.getInstance().getCacheDir(), "http-cache" ),
//                10 * 1024 * 1024 ); // 10 MB
//
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .cache(cache)
//                .build();
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, MINUTES)
                .writeTimeout(1, MINUTES)
                .readTimeout(1, MINUTES)
                .build();

        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofit;
    }


}
