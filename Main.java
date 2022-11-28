package com.company;
import java.util.Scanner;


public class Main {
    //Преобразование римских чисел от 1 до 10(по условию)
    private static int rimToNum(String rim)throws Exception {
        if (rim.equals("I")) {
            return 1;
        }
        else if (rim.equals("II")) {
            return 2;
        }
        else if (rim.equals("III")) {
            return 3;
        }
        else if (rim.equals("IV")) {
            return 4;
        }
        else if (rim.equals("V")) {
            return 5;
        }
        else if (rim.equals("VI")) {
            return 6;
        }
        else if (rim.equals("VII")) {
            return 7;
        }
        else if (rim.equals("VIII")) {
            return 8;
        }
        else if (rim.equals("IX")) {
            return 9;
        }
        else if (rim.equals("X")) {
            return 10;
        }
        else throw new Exception("Числа должны быть в диапазоне от 1 до 10");
    }
    //вычисление заданно операции
    public static int operation(int n1,int n2,String op){
        int res=0;
        switch (op) {
            case "\\+" -> res = n1 + n2;
            case "-" -> res = n1 - n2;
            case "\\*" -> res = n1 * n2;
            case "/" -> res = n1 / n2;
        }
        return res;
    }
    //перевод в Римскую СС
    private static String numToRim (int num) {
        String[] rim = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX",
                "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX",
                "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
                "XCVIII", "XCIX", "C"
        };
        final String s = rim[num];
        return s;
    }
    public static String calc(String input)throws Exception{
        String n1,n2;
        boolean r1=false,r2=false;
        String sgn="";
        int cnt_sgn=0;
        //поиск знака операции
        for(int i=0;i<input.length();i++){
            if (input.charAt(i)=='+') {
                sgn = "\\+";
                cnt_sgn++;
            }
            else if (input.charAt(i)=='-') {
                sgn = "-";
                cnt_sgn++;
            }
            else if (input.charAt(i)=='*') {
                sgn = "\\*";
                cnt_sgn++;
            }
            else if (input.charAt(i)=='/') {
                sgn = "/";
                cnt_sgn++;
            }
        }
        if(cnt_sgn!=1)throw new Exception("Производится не более 1 операции");
        //выделение в троке 2 чисел
        String[] numbers = input.split(sgn);
        n1 = numbers[0].trim();
        n2 = numbers[1].trim();
        int n_1,n_2;
        //перевод(если необходимо) из римской СС
        try{
            n_1=Integer.parseInt(n1);
        }
        catch (NumberFormatException e){
            r1=true;
            n_1 = rimToNum(n1);
        }
        try{
            n_2=Integer.parseInt(n2);
        }
        catch (NumberFormatException e){
            r2=true;
            n_2 = rimToNum(n2);
        }
        if(r1!=r2 || n_1>10 ||n_2>10 ||n_1<1 ||n_2<1)
            throw new Exception("Оба числа должны быть в одной СС и находиться в диапазоне от 1 до 10");
        //итоговый результат в арабской СС
        int res=operation(n_1,n_2,sgn);
        if(res<=0)
            throw new Exception("Результат должен быть строго положительный");
        if(r1){
            input=numToRim(res);
        }
        else
            input=Integer.toString(res);
        return input;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if (s.length()<3) {
            throw new Exception("Не хватает данных");
        }
        System.out.print(calc(s));
    }
}