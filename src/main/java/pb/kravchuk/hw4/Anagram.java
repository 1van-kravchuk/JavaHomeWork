package pb.kravchuk.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your first message");
        String str1 = scan.nextLine();
        System.out.println("enter your second message");
        String str2 = scan.nextLine();
        if (!isAnagram(str1, str2)) {
            System.out.println("Your messages are NOT anagrams");
        } else {
            System.out.println("Your messages are anagrams");
        }
    }

    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.replaceAll("[^A-Za-zА-Яа-я]", "");
        s2 = s2.replaceAll("[^A-Za-zА-Яа-я]", "");
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        } else {
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            String sch1 = new String(ch1);
            String sch2 = new String(ch2);
            return sch1.equals(sch2);
        }
    }
}
