package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// MainActivity6 sınıfı, kullanıcının diyet listesi belirlediği sayfayı temsil eder
public class MainActivity6 extends AppCompatActivity {

    private TextView textView500Calorie, textView1000Calorie, textView1500Calorie, textView2000Calorie, textView2500Calorie, textView3000Calorie;
    MakeShared shrdpre = new MakeShared(); // MakeShared sınıfı, SharedPreferences işlemlerini gerçekleştirir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        // XML dosyasındaki bileşenleri Java koduyla ilişkilendirir.
        textView500Calorie = findViewById(R.id.textView500Calorie);
        textView1000Calorie = findViewById(R.id.textView1000Calorie);
        textView1500Calorie = findViewById(R.id.textView1500Calorie);
        textView2000Calorie = findViewById(R.id.textView2000Calorie);
        textView2500Calorie = findViewById(R.id.textView2500Calorie);
        textView3000Calorie = findViewById(R.id.textView3000Calorie);

        // Her bir TextView için onClickListener'ları ayarlar
        textView500Calorie.setOnClickListener(v -> {
            selectCalorieAmount(textView500Calorie, "500");
        });

        textView1000Calorie.setOnClickListener(v -> {
            selectCalorieAmount(textView1000Calorie, "1000");
        });

        textView1500Calorie.setOnClickListener(v -> {
            selectCalorieAmount(textView1500Calorie, "1500");
        });

        textView2000Calorie.setOnClickListener(v -> {
            selectCalorieAmount(textView2000Calorie, "2000");
        });

        textView2500Calorie.setOnClickListener(v -> {
            selectCalorieAmount(textView2500Calorie, "2500");
        });

        textView3000Calorie.setOnClickListener(v -> {
            selectCalorieAmount(textView3000Calorie, "3000");
        });
    }

    // Seçilen TextView'i vurgular ve diğerlerini normale döndüren özel metot
    private void selectCalorieAmount(TextView selectedTextView, String calorieAmount) {
        textView500Calorie.setTextColor(getResources().getColor(android.R.color.black));
        textView1000Calorie.setTextColor(getResources().getColor(android.R.color.black));
        textView1500Calorie.setTextColor(getResources().getColor(android.R.color.black));
        textView2000Calorie.setTextColor(getResources().getColor(android.R.color.black));
        textView2500Calorie.setTextColor(getResources().getColor(android.R.color.black));
        textView3000Calorie.setTextColor(getResources().getColor(android.R.color.black));

        selectedTextView.setTextColor(getResources().getColor(android.R.color.holo_orange_light));
        saveDietCalorie(calorieAmount);
    }

    // Seçilen kalori miktarını SharedPreferences'e kaydeden metot
    private void saveDietCalorie(String calorieAmount) {
        shrdpre.writeDietCalorie(this, calorieAmount);
    }

    // "sonsayfa" butonuna tıklandığında çağrılan metot
    public void sonsayfa(View view) {
        // MainActivity7'ye geçiş yapar.
        Intent intent = new Intent(MainActivity6.this, MainActivity7.class);
        startActivity(intent);
    }
}
