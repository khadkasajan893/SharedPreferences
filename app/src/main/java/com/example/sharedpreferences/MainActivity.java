package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, email, password;
    Button save, retrieve, clear;
    public static final String MyPreference = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Password = "passwordKey";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.edit1);
        email = (EditText) findViewById(R.id.edit2);
        password = (EditText) findViewById(R.id.edit3);
        save = (Button) findViewById(R.id.save);
        retrieve = (Button) findViewById(R.id.retrieve);
        clear = (Button) findViewById(R.id.clear);

        sharedPreferences = getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(Name)) {
            name.setText(sharedPreferences.getString(Name, null));
        }
        if (sharedPreferences.contains(Email)) {
            email.setText(sharedPreferences.getString(Email, null));
        }
        if (sharedPreferences.contains(Password)) {
            password.setText(sharedPreferences.getString(Password, null));
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String n = name.getText().toString();
                    String e = email.getText().toString();
                    String p = password.getText().toString();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(Name, n);
                    editor.putString(Email, e);
                    editor.putString(Password, p);
                    editor.commit();
                }
            });

            retrieve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedPreferences = getSharedPreferences(MyPreference, Context.MODE_PRIVATE);
                    if (sharedPreferences.contains(Name)) {
                        name.setText(sharedPreferences.getString(Name, null));
                    }
                    if (sharedPreferences.contains(Email)) {
                        email.setText(sharedPreferences.getString(Email, null));
                    }
                    if (sharedPreferences.contains(Password)) {
                        password.setText(sharedPreferences.getString(Password, null));
                    }

                }
            });

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name.setText("");
                    email.setText("");
                    password.setText("");
                }
            });

        }
    }
}
