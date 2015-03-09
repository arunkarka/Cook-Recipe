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
        findViewById(R.id.tomotos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.tomotos_image).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.salt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.salt_image).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.lime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.lime_image).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.diced_onion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.diced_onion_image).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.green_chilis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.green_chilis_image).setVisibility(View.VISIBLE);
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
