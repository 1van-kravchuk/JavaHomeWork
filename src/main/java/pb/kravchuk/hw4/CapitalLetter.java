package pb.kravchuk.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your message:");
        String str = scan.nextLine();
        System.out.println(toTitleCase(str));
    }

    public static String toTitleCase(String s) {     // магия
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            result.append(word.replaceFirst(String.valueOf(word.charAt(0)), String.valueOf(Character.toUpperCase(word.charAt(0))))).append(" ");
        }
        return result.toString();
    }
}