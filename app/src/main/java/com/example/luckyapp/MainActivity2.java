package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView welcomeText, resultLuckyNumberText;
    Button shareLuckyNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        welcomeText = findViewById(R.id.your_lucky_numer_title);
        resultLuckyNumberText = findViewById(R.id.lucky_numer_to_display);
        shareLuckyNumber = findViewById(R.id.share_lucky_numer);

        Intent intent = getIntent();
        String username = intent.getStringExtra("name");
        String luckyNumber = Integer.toString(getLuckyNumber()); // need to cast int

        welcomeText.setText(username+ ", your lucky number is:");
        resultLuckyNumberText.setText(luckyNumber);

        shareLuckyNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setShareLuckyNumber(username, luckyNumber);
            }
        });

    }
    private int getLuckyNumber(){
        Random random = new Random();
        return  random.nextInt(100);
    }

    public void setShareLuckyNumber(String username, String luckyNumber){

        //Implicit intent
        Intent  intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_SUBJECT, username);
        intent.putExtra(Intent.EXTRA_TEXT, luckyNumber);

        startActivity(Intent.createChooser(intent, "Choose a platform "));
    }
}