package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class heroDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);
        String heroGsonString = getIntent().getStringExtra("key");

        TextView textViewName = (TextView) findViewById(R.id.textViewName);
        TextView textViewAge = (TextView) findViewById(R.id.textViewAge);
        TextView textViewRealName = (TextView) findViewById(R.id.textViewRealName);
        TextView textViewDesc = (TextView) findViewById(R.id.textViewDesc);
        TextView textViewHp = (TextView) findViewById(R.id.textViewHp);
        TextView textViewArmor = (TextView) findViewById(R.id.textViewArmor);
        TextView textViewDifficulty= (TextView) findViewById(R.id.textViewDifficulty);

        Gson gson = new Gson();


        Hero hero = gson.fromJson(heroGsonString, Hero.class);

        textViewName.setText(hero.getName());
        textViewAge.setText(Integer.toString(hero.getAge()));
        textViewRealName.setText(hero.getReal_name());
        textViewDesc.setText(hero.getDescription());
        textViewHp.setText(Integer.toString(hero.getHealth()));
        textViewArmor.setText(Integer.toString(hero.getArmour()));
        textViewDifficulty.setText(Integer.toString(hero.getDifficulty()));



    }
}
