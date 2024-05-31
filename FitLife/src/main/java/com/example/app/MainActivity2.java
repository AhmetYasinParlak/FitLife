package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// MainActivity2 sınıfı
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    // Devam butonuna tıklandığında çağrılan metot.
    public void Devam(View view) {
        // Yeni bir Intent oluşturulur. Intent, iki aktivite arasında geçiş yapmak için kullanılır.
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
        // Oluşturulan Intent'i kullanarak MainActivity2'den MainActivity3'e geçiş yapılır.
        startActivity(intent);
    }
}
