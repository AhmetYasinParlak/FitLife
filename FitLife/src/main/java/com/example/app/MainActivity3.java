package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// MainActivity3 sınıfı, ana menüden diğer sayfalara geçiş yapmak için kullanılır.
public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    // "Kalori Hesapla" resmine tıklandığında çağrılan metot.
    public void kalori(View view) {
        // Yeni bir Intent oluşturulur. Intent, iki aktivite arasında geçiş yapmak için kullanılır.
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        // Oluşturulan Intent'i kullanarak MainActivity3'ten MainActivity4'e geçiş yapılır.
        startActivity(intent);
    }

    // "Egzersiz Seç" resmine tıklandığında çağrılan metot.
    public void egzersiz(View view) {
        // Yeni bir Intent oluşturulur. Intent, iki aktivite arasında geçiş yapmak için kullanılır.
        Intent intent = new Intent(MainActivity3.this, MainActivity5.class);
        // Oluşturulan Intent'i kullanarak MainActivity3'ten MainActivity5'e geçiş yapılır.
        startActivity(intent);
    }

    // "Diyet Belirle" resmine tıklandığında çağrılan metot.
    public void diyet(View view) {
        // Yeni bir Intent oluşturulur. Intent, iki aktivite arasında geçiş yapmak için kullanılır.
        Intent intent = new Intent(MainActivity3.this, MainActivity6.class);
        // Oluşturulan Intent'i kullanarak MainActivity3'ten MainActivity6'ya geçiş yapılır.
        startActivity(intent);
    }

    // "Sonuçları Görüntüle" butonuna tıklandığında çağrılan metot.
    public void sonsayfa(View view) {
        // Yeni bir Intent oluşturulur. Intent, iki aktivite arasında geçiş yapmak için kullanılır.
        Intent intent = new Intent(MainActivity3.this, MainActivity7.class);
        // Oluşturulan Intent'i kullanarak MainActivity3'ten MainActivity7'ye geçiş yapılır.
        startActivity(intent);
    }
}
