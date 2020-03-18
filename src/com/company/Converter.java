package com.company;

import java.math.BigInteger;
import java.util.ArrayList;

public class Converter {
    private BigInteger number;
    private UseJSON reader;
    // Library of strings
    private static final String path = "C:\\Users\\Админ\\IdeaProjects\\JazzTeam\\src\\com\\company\\library.json";

    public Converter(){
        // Creates an object that reads json
        this.reader = new UseJSON(this.path);
    }

    public String convertToString(BigInteger number){
        
        BigInteger part;
        BigInteger zero = new BigInteger("0");
        // String representation of a number.
        String returnNumber = "";
        boolean flag = true;
        // Identifier of thousands.
        short thousands_ident = 0;
        String index = "";
        int element;
        // Creates an array of hundreds, thousands, millions, billions ...
        ArrayList segments = new ArrayList();

        if(number.compareTo(zero) == 0)
            return this.reader.readJSON(0);
        // For negative numbers.
        if(number.compareTo(zero) < 0){
            flag = false;
            number = zero.subtract(number);
        }

        BigInteger thousand = new BigInteger("1000");
        // Dividing the number by 1000
        while(number.compareTo(zero) > 0){
            part = number.mod(thousand);
            number = number.divide(thousand);
            segments.add(part);
        }

        for(Object p : segments){
            int n = ((BigInteger) p).intValue();

            // Endings and names of thousands, millions, billions ...
            if(thousands_ident == 1){
                if(n / 1000 == 1)
                    returnNumber = this.reader.readJSON("forms1000", 0) + returnNumber;
                else if(n == 0)
                    returnNumber = "" + returnNumber;
                else if(n % 100 > 20 || n % 100 < 10) {
                    if(n % 10 == 1)
                        returnNumber = this.reader.readJSON("forms1000", 0) + returnNumber;
                    else
                        returnNumber = this.reader.readJSON("forms1000", 2) + returnNumber;
                }
                else if(n % 100 > 20 || n % 100 < 10) {
                    if (n % 10 >= 2 && n % 10 <= 4)
                        returnNumber = this.reader.readJSON("forms1000", 1) + returnNumber;
                    else
                        returnNumber = this.reader.readJSON("forms1000", 2) + returnNumber;
                }
                else
                    returnNumber = this.reader.readJSON("forms1000", 2) + returnNumber;
            }
            else if(thousands_ident == 2){
                if(n / 1000 == 1)
                    returnNumber = this.reader.readJSON("forms1000000", 0) + returnNumber;
                else if(n == 0)
                    returnNumber = "" + returnNumber;
                else if(n % 100 > 20 || n % 100 < 10) {
                    if(n % 10 == 1)
                        returnNumber = this.reader.readJSON("forms1000000", 0) + returnNumber;
                    else
                        returnNumber = this.reader.readJSON("forms1000000", 2) + returnNumber;
                }
                else if(n % 100 > 20 || n % 100 < 10){
                    if(n % 10 >= 2 & n % 10 <= 4)
                        returnNumber = this.reader.readJSON("forms1000000", 1) + returnNumber;
                    else
                        returnNumber = this.reader.readJSON("forms1000000", 2) + returnNumber;
                }
                else
                    returnNumber = this.reader.readJSON("forms1000000", 2) + returnNumber;
            }
            else if(thousands_ident == 3){
                if(n / 1000 == 1)
                    returnNumber = this.reader.readJSON("forms1000000000", 0) + returnNumber;
                else if(n == 0)
                    returnNumber = "" + returnNumber;
                else if(n % 100 > 20 || n % 100 < 10) {
                    if(n % 10 == 1)
                        returnNumber = this.reader.readJSON("forms1000000000", 0) + returnNumber;
                    else
                        returnNumber = this.reader.readJSON("forms1000000000", 2) + returnNumber;
                }
                else if(n % 100 > 20 || n % 100 < 10){
                    if(n % 10 >= 2 & n % 10 <= 4)
                        returnNumber = this.reader.readJSON("forms1000000000", 1) + returnNumber;
                    else
                        returnNumber = this.reader.readJSON("forms1000000000", 2) + returnNumber;
                }
                else
                    returnNumber = this.reader.readJSON("forms1000000000", 2) + returnNumber;
            }
            else if(thousands_ident == 4){
                if(n / 1000 == 1)
                    returnNumber = this.reader.readJSON("forms1000000000000", 0) + returnNumber;
                else if(n == 0)
                    returnNumber = "" + returnNumber;
                else if(n % 100 > 20 || n % 100 < 10) {
                    if(n % 10 == 1)
                        returnNumber = this.reader.readJSON("forms1000000000000", 0) + returnNumber;
                    else
                        returnNumber = this.reader.readJSON("forms1000000000000", 2) + returnNumber;
                }
                else if(n % 100 > 20 || n % 100 < 10){
                    if(n % 10 >= 2 & n % 10 <= 4)
                        returnNumber = this.reader.readJSON("forms1000000000000", 1) + returnNumber;
                    else
                        returnNumber = this.reader.readJSON("forms1000000000000", 2) + returnNumber;
                }
                else
                    returnNumber = this.reader.readJSON("forms1000000000000", 2) + returnNumber;
            }
            // As a result of the fact that I used JSON, the program has problems updating and adding new data.(
            else if(thousands_ident > 4){
                System.out.println("Дополните библиотеку");
                return "";
            }


            // Iterating over the elements of a part of a number.
            for(int i = 0; i < 3; i++){
                // Print numbers [11 ... 19]
                if(n % 100 > 10 & n % 100 < 20 & i == 0){
                    element = n % 10;
                    n = n / 100;
                    returnNumber = this.reader.readJSON("str11", element) + returnNumber;
                    i++;
                }
                // Print other numbers
                else{
                    element = n % 10;
                    n = n / 10;
                    if (thousands_ident == 1) {
                        index = "str2";
                    } else {
                        index = "str1";
                    }

                    if (i == 0) {
                        returnNumber = this.reader.readJSON(index, element) + returnNumber;
                    }
                    else if (i == 1) {
                        returnNumber = this.reader.readJSON("str10", element) + returnNumber;
                    }
                    else if (i == 2) {
                        returnNumber = this.reader.readJSON("str100", element) + returnNumber;
                    }
                }
            }
            thousands_ident++;
        }
        if(flag == false)
            returnNumber = "минус" + returnNumber;
        return returnNumber;
    }
}
