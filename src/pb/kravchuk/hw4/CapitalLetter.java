package pb.kravchuk.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        Scanner scaan = new Scanner(System.in);
        System.out.println("Enter your message:");
        String str = scaan.nextLine();
        System.out.println(toTitleCase(str));


    }

    public static String toTitleCase(String s) {     // магия. разобраться!
        String result = "";
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            result += words[i].replaceFirst(words[i].charAt(0) + "", Character.toUpperCase(words[i].charAt(0)) + "") + " ";
        }
        return result;
    }
}