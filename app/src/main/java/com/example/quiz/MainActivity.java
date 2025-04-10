package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private Button startQuizBtn, calculatorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        userName = findViewById(R.id.userName);
        startQuizBtn = findViewById(R.id.startQuizBtn);

        // Set OnClickListener for the "Start Quiz" button
        startQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered username
                String username = userName.getText().toString().trim();

                if (!TextUtils.isEmpty(username)) {
                    // Save the username in SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("USERNAME", username);
                    editor.apply();

                    // Start the QuizQuestions activity
                    Intent intent = new Intent(MainActivity.this, QuizQuestions.class);
                    startActivity(intent);
                } else {
                    // Display a toast message if username is empty
                    Toast.makeText(MainActivity.this, "Enter your username please", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}