package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity{
    EditText Username,Password;
    Button LOGIN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Username =(TextView) findViewById(R.id.username);
        TextView Password =(TextView) findViewById(R.id.password);
        TextView LOGIN =(TextView) findViewById(R.id.loginbtn);
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Username.getText().toString().equals("admin") && Password.getText().toString().equals("admin")) {
                    SharedPreferences remember = LoginActivity.this.getSharedPreferences("toker", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = remember.edit();
                    editor.putString("username", Username.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("username", Username.getText().toString());
                    startActivity(intent);
                }
                else
                    //incorrect
                    Toast.makeText(LoginActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
