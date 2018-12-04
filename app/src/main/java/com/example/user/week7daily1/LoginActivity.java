package com.example.user.week7daily1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);

    }

    public void onSignIn(View view) {

        String email = etUser.getText().toString();
        String pass = etPass.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences(Constants.Share_Pref, MODE_PRIVATE);

        if (sharedPreferences.contains(email) && Objects.equals(sharedPreferences.getString(email, "default"), pass)) {
            Toast.makeText(this, "Successful Sign In", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SignIn.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSignUp(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
