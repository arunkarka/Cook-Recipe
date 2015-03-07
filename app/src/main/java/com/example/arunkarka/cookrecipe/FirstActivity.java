package com.example.arunkarka.cookrecipe;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        findViewById(R.id.begin_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecipeActivity();
            }
        });

    }

    private void startRecipeActivity(){
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }

}
