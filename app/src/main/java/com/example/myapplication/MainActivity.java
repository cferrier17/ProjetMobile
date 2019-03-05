package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        Controller controller = new Controller(this);
        controller.start();



    }

    public void showListAbilities(List<Ability> input) {
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyAbilityAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    public void showListHeroes(List<Hero> input) {
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // define an adapter
        mAdapter = new MyHeroAdapter(input, new OnHeroClickListener() {
            @Override
            public void onHeroClick(Hero hero) {    //TODO: gerer le onclick pour lancer la nouvelle activité qui créera un nouveau type de controleur pour les détails, voir javadoc retrofit
                //System.out.println(hero.getId());
                heroDetail(hero);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }


    public void heroDetail(Hero hero){
        Intent heroIntent = new Intent(this, heroDetailActivity.class);
        Gson gson = new Gson();
        heroIntent.putExtra("key", gson.toJson(hero));
        startActivity(heroIntent);
    }
}