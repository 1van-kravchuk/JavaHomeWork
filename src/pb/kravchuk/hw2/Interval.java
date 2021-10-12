package pb.kravchuk.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        System.out.println("Приветствую! Для получения бонуса, пожалуйста, введите число от 0 до 100:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        String msg;
        if (a >= 0 && a <= 15) {
            msg = "[0 - 15]";
        } else if (a < 36) {
            msg = "[16 - 35]";
        } else if (a < 51) {
            msg = "[36 - 50]";
        } else if (a <= 100) {
            msg = "[51 - 100]";
        } else {
            msg = ", который отсутствует на нашем колесе фортуны. Введите другое число";
        }
        System.out.println("Вы ввели число " + a + ". Данное число входит в сектор " + msg + ". Вы проиграли. Повезёт в следующий раз. Хотите попробовать еще раз?");
    }
}
