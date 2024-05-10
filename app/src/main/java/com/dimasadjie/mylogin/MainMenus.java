package com.dimasadjie.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menus);
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");

        TextView textViewWelcome = findViewById(R.id.textViewResult);
        textViewWelcome.setText("Login, " + username);

    }

    public void Contacts(View view){
        Intent intent = new Intent(MainMenus.this, Dashboard.class);
        startActivity(intent);
    }

    public void Camera(View view){
        Intent intent = new Intent(MainMenus.this, Camera.class);
        startActivity(intent);
    }

    public void Maps(View view){
        Intent intent = new Intent(MainMenus.this, MapsActivity.class);
        startActivity(intent);
    }

    public void Biodata(View view){
        Intent intent = new Intent(MainMenus.this, Biodata.class);
        startActivity(intent);
    }

}