package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GerritAPI {

    @GET("ability")
    Call<AbilityResponse> getListAbility();

    @GET("hero")
    Call<HeroResponse> getListHero();


}
