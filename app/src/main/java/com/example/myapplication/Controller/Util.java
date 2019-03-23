package com.example.myapplication.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Util {
    private static Gson gson = null;
    private static Retrofit retrofit = null;
    private static GerritAPI gerritAPI = null;

    public static Gson getGson(){
        if( gson == null){
            gson = new GsonBuilder()
                    .setLenient()
                    .create();
        }

        return gson;
    }

    public static Retrofit getRetrofit(String baseURL){
        if( retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }

    public static GerritAPI getGerritAPI(){
        if( gerritAPI == null)
            gerritAPI = retrofit.create(GerritAPI.class);

        return gerritAPI;
    }

}
