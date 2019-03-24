package com.example.myapplication.View;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.Controller.Controller;
import com.example.myapplication.Model.Hero;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.util.List;


public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MediaPlayer ring;
    private boolean isMusicOn=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        ring = MediaPlayer.create(MainActivity.this, R.raw.ring);
        onOffMusic();

        Controller controller = new Controller(this);
        controller.startHero();

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
            public void onHeroClick(Hero hero) {
                //System.out.println(hero.getId());
                heroDetail(hero);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }


    public void heroDetail(Hero hero){
        Intent heroIntent = new Intent(this, HeroDetailActivity.class);
        Gson gson = new Gson();
        heroIntent.putExtra("key", gson.toJson(hero));
        startActivity(heroIntent);
    }

    public void onOffMusic(){
        if(isMusicOn){
            ring.stop();
            ring.reset();
        }
        else{
            ring.setLooping(true);
            ring.start();
        }

        isMusicOn = !isMusicOn;
    }
}