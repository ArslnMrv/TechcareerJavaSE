package com.mr.radar;

import java.util.Scanner;

public class Radar {
    public static void main(String[] args) {
        // Kullanıcıdan hız bilgisini al
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen hızınızı giriniz: ");
        int hiz =input.nextInt();
        input.close();

        // Hız limitlerine göre ceza miktarını belirle
        int ceza = 0;
        if(hiz <90 && hiz>0){
            System.out.println("İyi yolculuklar dileriz");
        }else if (hiz >= 90 && hiz <= 100) {
            ceza = 1000;
        } else if (hiz >= 101 && hiz <= 110) {
            ceza = 2000;
        } else if (hiz >= 111 && hiz <= 130) {
            ceza = 3000;
        } else if (hiz >= 131) {
            ceza = 10000;
            System.out.println("Ehliyetinize el konulacak!");
        } else {
            System.out.println("Hız limitleri dışında bir değer girdiniz.");
            return;
        }
        if(ceza >0){
            System.out.println("Radar uygulaması: Hızınız " + hiz + " km/saat oldugu için ceza tutarı: " + ceza + " TL.");
        }
    }

}
