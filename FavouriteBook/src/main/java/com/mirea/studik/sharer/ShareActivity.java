package com.mirea.semyenovasa.sharer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_activity);

        // Извлекаем данные из первой активности
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String developerBookName = extras.getString(MainActivity.BOOK_NAME_KEY);
            String developerQuotes = extras.getString(MainActivity.QUOTES_KEY);

            // Отображаем данные на втором экране
            TextView tvDeveloperBook = findViewById(R.id.textViewDeveloperBook);
            TextView tvDeveloperQuote = findViewById(R.id.textViewDeveloperQuote);
            tvDeveloperBook.setText(developerBookName);
            tvDeveloperQuote.setText(developerQuotes);
        }
    }

    // Метод отправки данных обратно в первую активность
    public void sendDataToFirstScreen(View view) {
        EditText editTextUserBook = findViewById(R.id.editTextUserBook);
        EditText editTextUserQuote = findViewById(R.id.editTextUserQuote);

        // Формируем строку с информацией пользователя
        String userMessage = "Название Вашей любимой книги: " + editTextUserBook.getText().toString()
                + ". Цитата: " + editTextUserQuote.getText().toString();

        // Создаем намерение для возврата данных
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.USER_MESSAGE, userMessage);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}