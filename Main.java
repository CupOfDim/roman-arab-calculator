package Calculator;

import java.io.IOException;
import java.util.*;

public class Main {
    static String operation;
    public static void main(String[] args) throws IOException {
        String[] romanNum = {"O","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        String[] components = str.split(" ");
        String num1 = (String) components[0];
        operation = components[1];
        String num2 = (String) components[2];
        if(components.length > 3){
            throw new IOException();
        }

        if (arabList(num1, num2)) {
            int arabF = Integer.parseInt(num1);
            int arabS = Integer.parseInt(num2);
            System.out.println(calc(arabF, arabS, operation));
        } else if (romanTest(num1, num2)) {
            int romanF = romanToNumber(num1);
            int romanS = romanToNumber(num2);
            if(calc(romanF,romanS,operation) <= 0){
                throw new IOException();
            }else {
                System.out.println(romanNum[calc(romanF,romanS,operation)]);
            }
        } else {
            throw new IOException();
        }
    }
    private static boolean arabList(String num1, String num2){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        List<String> arabNum = new ArrayList<String>();
        String first = num1;
        String second = num2;
        arabNum.add(first);
        arabNum.add(second);
        return list.containsAll(arabNum);
    }

    private static boolean romanTest(String num1, String num2){
        List<String> list = new ArrayList<String>();
        list.add("I");

        list.add("II");
        list.add("III");
        list.add("IV");
        list.add("V");
        list.add("VI");
        list.add("VII");
        list.add("VIII");
        list.add("IX");
        list.add("X");
        List<String> romanNum = new ArrayList<String>();
        String first = num1;
        String second = num2;
        romanNum.add(first);
        romanNum.add(second);
        return list.containsAll(romanNum);
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException();
        }
        return -1;
    }


    private static int calc(int num1, int num2, String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
