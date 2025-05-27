package com.mirea.semyenovasa.intentapp;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView textView = findViewById(R.id.textView);

        // Извлекаем сообщение из интента
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("message")) {
            String message = extras.getString("message");
            textView.setText(message);
        }
    }

}
