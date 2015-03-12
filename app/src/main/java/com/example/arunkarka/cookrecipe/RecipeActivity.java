package com.example.arunkarka.cookrecipe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class RecipeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        findViewById(R.id.tomatos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.tomato_recipe).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.unknown1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.green_chilli_recipe).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.unknown2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.onion_recipe).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.lima).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.lime_recipe).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.unknown5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.salt_recipe).setVisibility(View.VISIBLE);
            }
        });


        findViewById(R.id.bonus_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBonusActivity();
            }
        });
    }

    private void startBonusActivity(){
        Intent intent = new Intent(this, BonusActivity.class);
        startActivity(intent);
    }
}
