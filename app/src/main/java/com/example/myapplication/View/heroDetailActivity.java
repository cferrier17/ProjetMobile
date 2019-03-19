package com.example.myapplication.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Model.Hero;
import com.example.myapplication.R;
import com.google.gson.Gson;

public class heroDetailActivity extends AppCompatActivity {
    //TODO: autre appel API pour obtenir les sorts du hero
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
        TextView textViewShield = (TextView) findViewById(R.id.textViewShield);
        TextView textViewArmor = (TextView) findViewById(R.id.textViewArmor);
        TextView textViewDifficulty= (TextView) findViewById(R.id.textViewDifficulty);
        ImageView imageViewDifficulty = (ImageView) findViewById(R.id.imageViewDifficulty);

        Gson gson = new Gson();


        Hero hero = gson.fromJson(heroGsonString, Hero.class);

        textViewName.setText("Name : " + hero.getName());
        textViewAge.setText("Age : " + Integer.toString(hero.getAge()));
        textViewRealName.setText("Real name : " + hero.getReal_name());
        textViewDesc.setText(hero.getDescription());
        textViewHp.setText("HP : " + Integer.toString(hero.getHealth()));
        textViewShield.setText("Shield : " + Integer.toString(hero.getShield()));
        textViewArmor.setText("Armour : " + Integer.toString(hero.getArmour()));
        textViewDifficulty.setText("Difficulty : " + Integer.toString(hero.getDifficulty()));

        switch(hero.getDifficulty()){
            case 2:
                imageViewDifficulty.setImageResource(R.drawable.deuxetoiles);
                break;
            case 3:
                imageViewDifficulty.setImageResource(R.drawable.troisetoiles);
                break;

        }



    }
}
