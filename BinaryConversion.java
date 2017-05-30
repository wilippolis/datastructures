
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilip
 */
public class BinaryConversion {

    public static int getDecimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter decimal: ");
        int decimal = scanner.nextInt();

        return decimal;

    }

    public static int getSize(int decimal) {
        String strDecimal = Integer.toString(decimal);
        int size = strDecimal.length();

        return size;
    }

    public static ArrayList<Character> toArray(int decimal) {
        String temp = Integer.toString(decimal);
        ArrayList<Character> intArray = new ArrayList<>();

        for (int i = 0; i < temp.length(); i++) {
            intArray.add(temp.charAt(i));
        }

        return intArray;
    }

    public static ArrayList<Character> convert(int dec) {
        String decimal = Integer.toString(dec);
        ArrayList<Character> binarySeq = new ArrayList<>();
        ArrayList<Character> zeroCase = new ArrayList<>(asList('0','0','0','0','0'));
        ArrayList<Character> onesCase = new ArrayList<>(asList('0','0','0','0','1'));

        //DO SEVEN DIFFERENT CASES 
        //if(dec <= 128)
        //if(dec <= 64)
        //if(dec <= 32)
        //if(dec <= 16)
        //if(dec <= 8)
        //if(dec <= 4)
        //if(dec <= 2)
        //if(dec <=1)
        if (decimal == "0") {
            return zeroCase;
        }

        if (decimal == "1") {
            return onesCase;
        }

        if (getSize(dec) == 1) {

            if (dec >= 1) {
//                if(Math.pow(2, 7) <= dec)
//                binarySeq[0] = 1;
//                if (Math.pow(2, 6) + Math.pow(2, 7) <= dec) {
//                    binarySeq[1] = 1;
//                } else if (Math.pow(2, 5) + Math.pow(2, 7) <= dec) {
//                    binarySeq[2] = 1;
//                } else if (Math.pow(2, 4) + Math.pow(2, 7) <= dec) {
//                    binarySeq[3] = 1;
//                } else if (Math.pow(2, 3) + Math.pow(2, 7) <= dec) {
//                    binarySeq[4] = 1;
//                } else if (Math.pow(2, 2) + Math.pow(2, 7) <= dec) {
//                    binarySeq[5] = 1;
//                } else if (Math.pow(2, 1) + Math.pow(2, 7) <= dec) {
//                    binarySeq[6] = 1;
//                } else {
//                    binarySeq[7] = 1;
//                }
//            } else if (Math.pow(2, 6) <= dec) {
//                binarySeq[1] = 1;
//            } else if (Math.pow(2, 5) <= dec) {
//                binarySeq[2] = 1;
//            } else if (Math.pow(2, 4) <= dec) {
//                binarySeq[3] = 1;
//            } else if (Math.pow(2, 3) <= dec) {
//                binarySeq[4] = 1;
//            } else if (Math.pow(2, 2) <= dec) {
//                binarySeq[5] = 1;
//            } else if (Math.pow(2, 1) <= dec) {
//                binarySeq[6] = 1;
//            } else {
//                binarySeq[7] = 1;
           }

            return binarySeq;

//            for(int i = 0; i < toArray(decimal).length;i++)
//                
//            System.out.println(toArray(decimal)[i]);
        }

        return binarySeq;

    }

    public static void main(String[] args) {
        System.out.println(convert(getDecimal()));

        //System.out.println(convert(0));
    }

}
