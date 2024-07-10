package com.mr.sicaklik_birim_hesaplama;

import java.util.Scanner;

public class CelciusToFahrenheit {
    public static void main(String[] args) {
        // Kullanıcıdan Celsius sıcaklık değerini al
        Scanner input = new Scanner(System.in);
        System.out.print("Lütfen Celsius cinsinden sıcaklık değerini giriniz: ");
        double celsius = input.nextDouble();
        input.close();

        // Celsius'i Fahrenheit'a çevir
        double fahrenheit = (celsius * 9/5) + 32;

        // Sonucu ekrana yazdır
        System.out.println(celsius + " derece Celsius, " + fahrenheit + " derece Fahrenheit'a eşittir.");
    }
}
