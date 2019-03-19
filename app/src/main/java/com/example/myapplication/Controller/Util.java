package com.example.myapplication.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Util {
    private static Gson gson;
    private static Retrofit retrofit;

    public Util(){
        gson = null;
        retrofit = null;
    }

    public Gson getGson(){
        if( gson == null){
            gson = new GsonBuilder()
                    .setLenient()
                    .create();
        }

        return gson;
    }

    public Retrofit getRetrofit(String baseURL){
        if( retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
