package com.company;

import com.company.Interfaces.Converter;
import java.math.BigInteger;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Converter converter = new ConverterToString();
        while(true){
            try {

                Scanner in = new Scanner(System.in);

                System.out.print("Введите число: ");
                BigInteger num = in.nextBigInteger();
                String number =  converter.convertToString(num);
                System.out.println("Число в текстовом виде: " + number);

            } catch (Exception e) {
                System.out.println("Введите правильное число");

            }
        }

    }
}
