package com.example.app;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

// MainActivity7 sınıfı,sonuç sayfasını temsil eder
public class MainActivity7 extends AppCompatActivity {

    TextView hedefKaloriTextView, egzersizKaloriTextView, diyetKaloriTextView;
    MakeShared shrdpre = new MakeShared();
    MediaPlayer mediaPlayer; // MediaPlayer'ı tanımla

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        // XML dosyasındaki bileşenleri Java koduyla ilişkilendirir.
        hedefKaloriTextView = findViewById(R.id.hedefKaloriTxt);
        egzersizKaloriTextView = findViewById(R.id.egzersizKaloriTxt);
        diyetKaloriTextView = findViewById(R.id.diyetKaloriTxt);

        // MediaPlayer'ı oluştur ve raw klasöründeki alkis dosyasını ayarla
        mediaPlayer = MediaPlayer.create(this, R.raw.alkis);
        mediaPlayer.setOnCompletionListener(mp -> {
            mediaPlayer.release();
            mediaPlayer = null;
        });

        // SharedPreferences üzerinden hedef kalori, harcanan kalori ve alınan kaloriyi oku
        String hedefKalori = shrdpre.readfile(this);
        hedefKaloriTextView.setText("Hedef Kalori: " + hedefKalori);

        String egzersizKalori = shrdpre.readCalorie(this);
        egzersizKaloriTextView.setText("Harcanan Kalori: " + egzersizKalori);

        String diyetKalori = shrdpre.readDietCalorie(this);
        diyetKaloriTextView.setText("Alınan Kalori: " + diyetKalori);

        // Kalori durumunu kontrol et ve uygun dialog penceresini göster
        checkAndShowDialog(Integer.parseInt(hedefKalori), Integer.parseInt(egzersizKalori), Integer.parseInt(diyetKalori));
    }

    // Kalori durumunu kontrol et ve uygun dialog penceresini gösteren metot
    private void checkAndShowDialog(int hedefKalori, int egzersizKalori, int diyetKalori) {
        int toplamKalori = diyetKalori - egzersizKalori;
        if (hedefKalori == toplamKalori) {
            showCongratulationsDialog();
        } else if (hedefKalori > toplamKalori) {
            int kaloriFarki = hedefKalori - toplamKalori;
            showLessCaloriesDialog(kaloriFarki);
        } else if (hedefKalori < toplamKalori) {
            int kaloriFarki = toplamKalori - hedefKalori;
            showExcessCaloriesDialog(kaloriFarki);
        }
    }

    // Tebrikler dialog penceresini gösteren metot
    private void showCongratulationsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (mediaPlayer != null) {
            mediaPlayer.start(); // MediaPlayer'ı başlat
        }
        builder.setTitle("Tebrikler!");
        builder.setMessage("Hedeflediğiniz kaloriye ulaştınız.");
        builder.setPositiveButton("Tamam", (dialog, which) -> {
            dialog.dismiss();
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        });
        builder.show();
    }

    // Fazla kalori dialog penceresini gösteren metot
    private void showExcessCaloriesDialog(int kaloriFarki) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Fazla kalori");
        builder.setMessage("Gün sonunda hedef kalorinizden " + kaloriFarki + " kalori fazla aldınız. Öneri: Fazla her 100 kalori için 100 metre yürüyebilirsiniz.");
        builder.setPositiveButton("Evet", (dialog, which) -> {
            showCongratulationsDialog();
            dialog.dismiss();
        });
        builder.setNegativeButton("Hayır", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    // Eksik kalori dialog penceresini gösteren metot
    private void showLessCaloriesDialog(int kaloriFarki) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Daha fazla kaloriye ihtiyacınız var");
        builder.setMessage("Gün sonunda hedef kalorinizden " + kaloriFarki + " kalori eksik aldınız. Eksik her 100 kalori için yarım bardak süt içebilirsiniz.");
        builder.setPositiveButton("Evet", (dialog, which) -> {
            showCongratulationsDialog();
            dialog.dismiss();
        });
        builder.setNegativeButton("Hayır", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    // Activity kapatıldığında MediaPlayer kaynaklarını serbest bırak
    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
