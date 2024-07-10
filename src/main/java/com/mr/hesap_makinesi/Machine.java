package com.mr.hesap_makinesi;

import java.io.InvalidObjectException;
import java.util.Objects;
import java.util.StringTokenizer;

public class Machine {
    double firstNumber;
    double twoNumber;
    String operator;

    //Kullanicinin girdigi veriyi tanimlar.
    public void definition(String data) throws InvalidObjectException {
        StringTokenizer tokenizer = new StringTokenizer(data, "+-*/");
            int tokens = tokenizer.countTokens();
            if (!(data.contains("+")||data.contains("-")||data.contains("*")||data.contains("/"))) {
                throw new InvalidObjectException("Lutfen gecerli bir islem turu belirtiniz");
            } else if (tokens == 1) {
                throw new InvalidObjectException("Lutfen iki sayi giriniz");
            } else if (tokens > 2) {
                throw new InvalidObjectException("Uygulamamiz gelistirilme asamasindadir. Su an yalniz iki sayi ile tek bir islem gerceklestirebilmektedir. \nİlginiz icin tesekkur ederiz ");
            }
    }

    //Yapilacak islem turunu ve sayilari belirler  --> only me
    public void specificatinOfElement(String data) throws NumberFormatException {
        String[] dataArray = data.split("\\s*(?=[+\\-*/()])|(?<=[+\\-*/()])\\s*");
        if(dataArray[0].equals("+")){ //ilk indexte sayinin isaretinin belirtilmesi durumunu kontrol eder
            this.firstNumber= Double.parseDouble(dataArray[1]);
            this.operator=dataArray[2];
            // ikinci sayinin isaretinin belirlenmesi durumunu kontrol eder
            if(dataArray[3].equals("-")){
                this.twoNumber= -1* Double.parseDouble(dataArray[4]);
            } else if (dataArray[3].equals("+")) {
                this.twoNumber=Double.parseDouble(dataArray[4]);
            }else {
                this.twoNumber=Double.parseDouble(dataArray[3]);
            }
        } else if (dataArray[0].equals("-")) { //ilk indexte sayinin isaretinin belirtilmesi durumunu kontrol eder
            this.firstNumber= -1* Double.parseDouble(dataArray[1]);
            this.operator=dataArray[2];
            // ikinci sayinin isaretinin belirlenmesi durumunu kontrol eder
            if(dataArray[3].equals("-")){
                this.twoNumber= -1* Double.parseDouble(dataArray[4]);
            } else if (dataArray[3].equals("+")) {
                this.twoNumber=Double.parseDouble(dataArray[4]);
            }else {
                this.twoNumber=Double.parseDouble(dataArray[3]);
            }
        }else {
            this.operator = dataArray[1];
            this.firstNumber = Double.parseDouble(dataArray[0]);
            // ikinci sayinin isaretinin belirlenmesi durumunu kontrol eder
            if(dataArray[2].equals("-")){
                this.twoNumber= -1* Double.parseDouble(dataArray[3]);
            } else if (dataArray[2].equals("+")) {
                this.twoNumber=Double.parseDouble(dataArray[3]);
            }else {
                this.twoNumber=Double.parseDouble(dataArray[2]);
            }
        }
    }

    //Yapilacak islem turunu ve sayilari belirler  --> me + chatgpt
    public void specificationOfElement(String data) throws NumberFormatException {
        String[] dataArray = data.split("\\s*(?=[+\\-*/()])|(?<=[+\\-*/()])\\s*");

        // İlk sayının işaretini ve değerini belirleme
        int index = 0;
        if (dataArray[index].equals("+") || dataArray[index].equals("-")) {
            System.out.println(index);
            this.firstNumber = (dataArray[index].equals("+") ? 1 : -1) * Double.parseDouble(dataArray[++index]);
            System.out.println(index);
            this.operator = dataArray[++index];
            ++index;
            System.out.println(index);
        } else {
            this.firstNumber = Double.parseDouble(dataArray[index++]);
            System.out.println(index);
            this.operator = dataArray[index++];
            System.out.println(index);
        }

        // İkinci sayının işaretini ve değerini belirleme
        if (dataArray[index].equals("+") || dataArray[index].equals("-")) {
            System.out.println(index);
            this.twoNumber = (dataArray[index].equals("+") ? 1 : -1) * Double.parseDouble(dataArray[++index]);
        } else {
            System.out.println(index);
            this.twoNumber = Double.parseDouble(dataArray[index]);
        }
    }


    //Islem turune gore ilgili methodu calistirir
    public void result(String data) throws InvalidObjectException {
        if (Objects.equals(operator, "+")) {
            System.out.println(data+" = "+ addition(firstNumber, twoNumber));
        } else if (Objects.equals(operator, "-")) {
            System.out.println(data+" = "+ subtraction(firstNumber, twoNumber));
        } else if (Objects.equals(operator, "*")) {
            System.out.println(data+" = "+ multiplication(firstNumber, twoNumber));
        } else if (Objects.equals(operator, "/")) {
            System.out.println(data+" = "+ division(firstNumber, twoNumber));
        }
    }
    public double addition(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    public double subtraction(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    public double multiplication(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    public double division(double numberOne, double numberTwo) throws InvalidObjectException {
        if (numberTwo == 0) {
            throw new InvalidObjectException("Bölme isleminde ikinci sayi 0 olamaz. Herhangi bir sayinin sıfıra bolumu tanimsizdir");
        }
        return numberOne / numberTwo;
    }
    //Islem sonucu verileri sifirlar
    public void cleanData(){
        this.firstNumber=0;
        this.twoNumber=0;
        this.operator=null;
    }
}
