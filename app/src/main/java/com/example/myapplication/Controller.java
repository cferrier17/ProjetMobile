package com.example.myapplication;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    static final String BASE_URL =  "https://overwatch-api.net/api/v1/";
    private final MainActivity activity;

    public Controller(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void start() { //TODO: implementer singleton pour gson et retrofit
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GerritAPI gerritAPI = retrofit.create(GerritAPI.class);

        Call<AbilityResponse> callAbility = gerritAPI.getListAbility();

        callAbility.enqueue(new Callback<AbilityResponse>() {
            @Override
            public void onResponse(Call<AbilityResponse> call, Response<AbilityResponse> response) {
                if(response.isSuccessful()) {
                    AbilityResponse response1 = response.body();
                    List<Ability> listAbilities = response1.getData();

                    //activity.showListAbilities(listAbilities);
                } else {
                    System.out.println("Nay " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<AbilityResponse> call, Throwable t) {
                System.out.println("Nay ");
            }
        });


        Call<HeroResponse> callHero = gerritAPI.getListHero();
        callHero.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(Call<HeroResponse> call, Response<HeroResponse> response) {
                if(response.isSuccessful()){
                    HeroResponse response1 = response.body();
                    List<Hero> listHeroes = response1.getData();

                    activity.showListHeroes(listHeroes);
                }
                else{
                    System.out.println("Nay" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<HeroResponse> call, Throwable t) {

            }
        });



    }
}