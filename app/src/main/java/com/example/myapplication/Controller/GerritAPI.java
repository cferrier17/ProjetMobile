package com.example.myapplication.Controller;

import com.example.myapplication.Model.HeroResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GerritAPI {


    @GET("hero")
    Call<HeroResponse> getListHero();


}
