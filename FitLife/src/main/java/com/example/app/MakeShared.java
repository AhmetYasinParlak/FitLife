package com.example.app;

import android.content.Context;
import android.content.SharedPreferences;

public class MakeShared {
    // SharedPreferences dosyasının adı
    static final String file_name = "file3";
    // Hedef kalori verisinin anahtarı
    String key = "key";

    // Hedef kaloriyi SharedPreferences'e yazan metot
    public void writefile(Context context, String text) {
        SharedPreferences shrpre =
                context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor sheditor = shrpre.edit();
        sheditor.putString(key, text);
        sheditor.apply();
    }

    // Hedef kaloriyi SharedPreferences'den okuyan metot
    public String readfile(Context context) {
        SharedPreferences shrpre =
                context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        return shrpre.getString(key, null);
    }

    // Harcanan kaloriyi SharedPreferences'e yazan metot
    public void writeCalorie(Context context, String calorieAmount) {
        SharedPreferences shrpre =
                context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor sheditor = shrpre.edit();
        sheditor.putString("calorie_amount", calorieAmount);
        sheditor.apply();
    }

    // Harcanan kaloriyi SharedPreferences'den okuyan metot
    public String readCalorie(Context context) {
        SharedPreferences shrpre =
                context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        return shrpre.getString("calorie_amount", null);
    }

    // Alınan kaloriyi SharedPreferences'e yazan metot
    public void writeDietCalorie(Context context, String calorieAmount) {
        SharedPreferences shrpre =
                context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        SharedPreferences.Editor sheditor = shrpre.edit();
        sheditor.putString("diet_calorie_amount", calorieAmount);
        sheditor.apply();
    }

    // Alınan kaloriyi SharedPreferences'den okuyan metot
    public String readDietCalorie(Context context) {
        SharedPreferences shrpre =
                context.getSharedPreferences(file_name, Context.MODE_PRIVATE);
        return shrpre.getString("diet_calorie_amount", null);
    }
}
