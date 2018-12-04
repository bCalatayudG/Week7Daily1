package com.example.user.week7daily1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private EditText etUser;
    private EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
    }

    public void onSignUp(View view) {

        String email = etUser.getText().toString();
        String pass = etPass.getText().toString();

        if(!checkEmail(email)){
            Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!checkPassword(pass)){
            Toast.makeText(this,"Invslid password",Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences pref = getSharedPreferences(Constants.Share_Pref, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(email, pass);
        editor.apply();

        finish();
    }

    private boolean checkPassword(String pass) {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{4,20})";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(pass);

        return matcher.matches();
    }

    public boolean checkEmail(String email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
