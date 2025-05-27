package com.mirea.semyenovasa.sharer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    public static final String BOOK_NAME_KEY = "book_name";
    public static final String QUOTES_KEY = "quotes_name";
    public static final String USER_MESSAGE = "MESSAGE";

    private TextView textViewUserBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Связываем элемент интерфейса с переменной
        textViewUserBook = findViewById(R.id.textViewBook);
    }

    // Метод запускающий вторую активность
    public void getInfoAboutBook(View view) {
        Intent intent = new Intent(this, ShareActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    // Обработка результатов, полученных от второй активности
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String userBook = data.getStringExtra(USER_MESSAGE);
            textViewUserBook.setText(userBook);
        }
    }
}