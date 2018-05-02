package com.example.skyler.test;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import client.Client;
import client.tools.Net;

import static client.Client.socket;

public class MainActivity extends AppCompatActivity {

    TextView username;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);
        Client client = new Client(8000,"192.168.1.4");

        try {
            client.StartNetClient();
        } catch (Exception e) {
            e.printStackTrace();
        }


        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
    }

    public void onClick(View view) {

        String user = username.getText().toString();
        String pass = password.getText().toString();

        Net.login(user,pass);

    }

}
