package com.mr.hesap_makinesi;

import java.io.InvalidObjectException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("M&R hesap makinesi uygulamamiza hosgeldiniz.");
        boolean control = true;
       do {
           System.out.println("Lutfen islem yapmak istediginiz sayilari ve islem turunu belirtiniz");
           Scanner input= new Scanner(System.in);
           String data = input.nextLine().replaceAll(" ","");
           input.close();
           Machine machine= new Machine();
           try {
               machine.definition(data); //Kullanicinin girdigi veriyi tanimlar.
               machine.specificationOfElement(data);    //Yapilacak islem turunu ve sayilari belirler
               machine.result(data); //Islem turune gore ilgili methodu calistirir
           } catch (InvalidObjectException e) {
               System.out.println(e.getMessage());
           }catch (NumberFormatException e) {
               System.out.println("Lutfen gecerli formatta bir sayi giriniz");
           }
           System.out.println("Cikmak icin 'Q', devam etmek icin herhangi bir tusa basiniz");
           Scanner input2= new Scanner(System.in);
           String select= input2.next();
           input.close();
           if(select.equalsIgnoreCase("Q")){
               System.out.println("Uygulamamizi tercih ettiginiz icin tesekkur ederiz. İyi günler");
               control =false;
           };
           machine.cleanData();
       }while (control);
    }
}
