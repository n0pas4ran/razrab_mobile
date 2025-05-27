package com.mirea.semyenovasa.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получение текущего времени
        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateString = sdf.format(new Date(dateInMillis));

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            int groupNumber = 12;
            int squareValue = groupNumber * groupNumber;

            // Формируем итоговую строку
            String message = "Квадрат значения моего номера по списку в группе составляет число " + squareValue +
                    ", а текущее время " + dateString;

            // Передача строки во вторую активность
            intent.putExtra("message", message);
            startActivity(intent);
        });
    }
}