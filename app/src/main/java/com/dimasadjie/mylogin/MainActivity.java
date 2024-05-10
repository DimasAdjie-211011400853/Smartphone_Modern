package com.dimasadjie.mylogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String correctUsername = "admin";
    String correctPassword = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtUser = findViewById(R.id.txtUser);
        final EditText txtPass = findViewById(R.id.txtPass);
        com.google.android.material.button.MaterialButton login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = txtUser.getText().toString().trim();
                String inputPassword = txtPass.getText().toString().trim();
                if (inputUsername.equals(correctUsername) && inputPassword.equals(correctPassword)) {
                    Intent intent = new Intent(MainActivity.this, MainMenus.class);
                    intent.putExtra("USERNAME", inputUsername);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Username/Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
