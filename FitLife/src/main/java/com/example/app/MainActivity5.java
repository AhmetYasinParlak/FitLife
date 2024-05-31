package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

// MainActivity5 sınıfı, kullanıcının egzersiz belirlediği sayfayı temsil eder
public class MainActivity5 extends AppCompatActivity {
    Button button;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    TextView txt;
    MakeShared shrdpre = new MakeShared(); // MakeShared sınıfı, SharedPreferences işlemlerini gerçekleştirir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // XML dosyasındaki bileşenleri Java koduyla ilişkilendirir.
        button = findViewById(R.id.button);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        txt = findViewById(R.id.textViewegzersiz);

        // Her bir checkbox için onClickListener'ları ayarlar
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uncheckAllExcept(checkBox1);
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uncheckAllExcept(checkBox2);
            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uncheckAllExcept(checkBox3);
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uncheckAllExcept(checkBox4);
            }
        });

        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uncheckAllExcept(checkBox5);
            }
        });
    }

    // Seçilen CheckBox dışındaki tüm CheckBox'ları işaretini kaldıran özel metot
    private void uncheckAllExcept(CheckBox selectedCheckBox) {
        // Seçilen olan dışındaki tüm CheckBox'ları işaretini kaldırır
        if (checkBox1 != selectedCheckBox) {
            checkBox1.setChecked(false);
        }
        if (checkBox2 != selectedCheckBox) {
            checkBox2.setChecked(false);
        }
        if (checkBox3 != selectedCheckBox) {
            checkBox3.setChecked(false);
        }
        if (checkBox4 != selectedCheckBox) {
            checkBox4.setChecked(false);
        }
        if (checkBox5 != selectedCheckBox) {
            checkBox5.setChecked(false);
        }
    }

    // "Kaydet" butonuna tıklandığında çağrılan metot.
    public void Kaydet(View view) {
        // Her bir CheckBox'in durumunu kontrol eder ve seçili olanlara göre işlem yapar.
        if (checkBox1.isChecked()) {
            String calorieAmount = String.valueOf(3000);
            shrdpre.writeCalorie(this, calorieAmount);
        }
        if (checkBox2.isChecked()) {
            String calorieAmount = String.valueOf(2500);
            shrdpre.writeCalorie(this, calorieAmount);
        }
        if (checkBox3.isChecked()) {
            String calorieAmount = String.valueOf(2000);
            shrdpre.writeCalorie(this, calorieAmount);
        }
        if (checkBox4.isChecked()) {
            String calorieAmount = String.valueOf(1500);
            shrdpre.writeCalorie(this, calorieAmount);
        }
        if (checkBox5.isChecked()) {
            String calorieAmount = String.valueOf(1000);
            shrdpre.writeCalorie(this, calorieAmount);
        }
        // MainActivity3'e geçiş yapar.
        Intent intent2 = new Intent(MainActivity5.this, MainActivity3.class);
        startActivity(intent2);
    }
}
