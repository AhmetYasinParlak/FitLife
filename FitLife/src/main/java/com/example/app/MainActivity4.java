package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

// MainActivity4 sınıfı, kullanıcının hedef kalorisini belirlediği sayfayı temsil eder.
public class MainActivity4 extends AppCompatActivity {

    EditText kalorigiris; // Kullanıcının hedef kalorisini gireceği EditText
    MakeShared shrdpre = new MakeShared(); // MakeShared sınıfı, SharedPreferences işlemlerini gerçekleştirir

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // XML dosyasındaki EditText'i Java koduyla ilişkilendirir.
        kalorigiris = findViewById(R.id.kalorigiris);
    }

    // "Kaydet" butonuna tıklandığında çağrılan metot.
    public void Kaydetislemi(View view) {
        // Kullanıcının girdiği hedef kaloriyi EditText'ten alır.
        String hedefKalori = kalorigiris.getText().toString();

        // Hedef kaloriyi MakeShared sınıfı kullanarak SharedPreferences'e kaydedilir.
        shrdpre.writefile(this, hedefKalori);

        // MainActivity3'e geri dönmek için bir Intent oluşturulur.
        Intent intent3 = new Intent(MainActivity4.this, MainActivity3.class);
        // MainActivity3'e geçiş yapılır.
        startActivity(intent3);
    }
}
