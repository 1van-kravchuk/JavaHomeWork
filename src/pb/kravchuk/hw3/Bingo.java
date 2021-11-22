package pb.kravchuk.hw3;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        int random = (int) (Math.random() * 101);
        // System.out.println(random);
        System.out.println("Приветствую! Это игра Бинго. Я загадал число от 0 до 100. Тебе предстоит угадать его. У тебя 100 попыток.");
        System.out.println("Если не хочешь продолжать игру, введи - exit");
        String isExit;
        Scanner scan = new Scanner(System.in);
int i =1;
        while(i<10) {
i++;
            System.out.println("Введи число. Попытка: " + i);
            isExit = scan.next();
            if (isExit.equals("exit")) {
                System.out.println("очень жаль, что ты оказался таким слабаком и сдался в самом начале веселья. :(");
                break;
            } else {
                int x = Integer.parseInt(isExit);
                while (x != random) {
                    String answer = x > random ? "Ты ввел число больше загаданного" : "Твоё число меньше. Еще разок?";
                    System.out.println(answer);
                    break;
                }
                if (x == random) {
                    System.out.println("Поздравляю! Ты угадал число с попытки " + i + ". Верное число: " + x);
                    break;
                }
            }
        }
        System.out.println("Game over");
    }
}

