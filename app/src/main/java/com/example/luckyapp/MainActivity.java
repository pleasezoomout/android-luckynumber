package com.example.luckyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText enterName;
    Button signInButton;
    TextView mainActivityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityTitle = findViewById(R.id.title_main_activity);
        enterName = findViewById(R.id.enter_name_input);
        signInButton = findViewById(R.id.sign_in_button);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = enterName.getText().toString();

                if(!isValidName(username)) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Name required",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity2.class);

                intent.putExtra("name", username);
                startActivity(intent);
            }
        });
    }

    private boolean isValidName(String username){
        return username.length() >= 3;
    }
}