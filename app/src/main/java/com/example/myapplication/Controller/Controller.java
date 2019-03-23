package com.example.myapplication.Controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.List;

import com.example.myapplication.Model.Hero;
import com.example.myapplication.Model.HeroResponse;
import com.example.myapplication.View.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.content.Context.MODE_PRIVATE;

public class Controller {

    static final String BASE_URL =  "https://overwatch-api.net/api/v/";
    private final MainActivity activity;


    private SharedPreferences sharedPreferences;
    private static final String PREFS = "PREFS";




    public Controller(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void start() { //TODO: implementer singleton pour gson et retrofit
        Gson gson = Util.getGson();
        Retrofit retrofit = Util.getRetrofit(BASE_URL);
        GerritAPI gerritAPI = Util.getGerritAPI();




        /**
         * Ability call
         */
/*
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
*/

        /**
         * Hero call
         */

        sharedPreferences = activity.getSharedPreferences(PREFS, MODE_PRIVATE);

        if( sharedPreferencesEmpty() ){
            callAPIHeroList(gerritAPI);
        }
        else{
            String listHeroGson = getSharedPreferences("listHeroes");

            Type typeOfObjectsListNew = new TypeToken< List<Hero>>() {}.getType();
            List<Hero> listHeroes = gson.fromJson(listHeroGson, typeOfObjectsListNew);
            activity.showListHeroes(listHeroes);
        }




    }

    private void callAPIHeroList(GerritAPI gerritAPI) {
        Call<HeroResponse> callHero = gerritAPI.getListHero();
        callHero.enqueue(new Callback<HeroResponse>() {
            @Override
            public void onResponse(Call<HeroResponse> call, Response<HeroResponse> response) {
                if(response.isSuccessful()){
                    HeroResponse response1 = response.body();
                    List<Hero> listHeroes = response1.getData();

                    activity.showListHeroes(listHeroes);

                    Gson gson = new Gson();
                    String stringHeroes= gson.toJson(listHeroes);

                    sharedPreferences
                            .edit()
                            .putString("listHeroes", stringHeroes)
                            .apply();

                }
                else{
                    new AlertDialog.Builder(activity)
                            .setTitle("Error in API call")
                            .setMessage("Press OK to close the app, and try later.")
                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    activity.finish();
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<HeroResponse> call, Throwable t) {

                Toast.makeText(activity,"API Call failure", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean sharedPreferencesEmpty() {
        return !sharedPreferences.contains("listHeroes");
    }

    private String getSharedPreferences(String key){
        return sharedPreferences.getString(key, "");
    }
}