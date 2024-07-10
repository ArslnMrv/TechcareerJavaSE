package com.mr.simdiki_zaman;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String nameOfDay= now.getDayOfWeek().toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime= now.format(formatter);

        System.out.println("Bugun gunlerden "+nameOfDay+" ve saat su anda "+formattedTime);

        // Türkçe gün ismini almak için Locale.TURKISH kullanabiliriz
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        String turkishDay = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("tr"));
        System.out.println("Bugun gunlerden "+turkishDay.toUpperCase()+" ve saat su anda "+formattedTime);
    }
}
