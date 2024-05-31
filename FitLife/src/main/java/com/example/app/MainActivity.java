package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// MainActivity sınıfı, uygulamanın başlangıç ekranını temsil eder.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Giriş butonuna tıklandığında çağrılan metot.
    public void Giris(View view) {
        // Yeni bir Intent oluşturulur. Intent, iki aktivite arasında geçiş yapmak için kullanılır.
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        // Oluşturulan Intent'i kullanarak MainActivity'den MainActivity2'ye geçiş yapılır.
        startActivity(intent);
    }
}