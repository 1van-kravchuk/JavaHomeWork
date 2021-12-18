package pb.kravchuk.hw3;

import java.util.Scanner;

public class BingoStr {
    public static void main(String[] args) {
        String color = "yellow";
        System.out.println("Hello! This is a Bingo game. Try to guess the color. \nIf you want to exit the game - type \"exit\"");
        try (Scanner scan = new Scanner(System.in)) {
            while (true) {
                String ton = scan.nextLine();
                if (ton.equals("exit")) {   // equals ---> "==", но для строк . Нельзя сравнить две строки путем двух знаков равно.  i==2   ton == exit => false
                    System.out.println("Exit the game. Goodbye!");
                    break;
                } else if (ton.equals(color)) {
                    System.out.println("You are won! Right color is " + color + "\nGame over");
                } else {
                    System.out.println("Wrong color. try again");
                }
            }
        }
        System.out.println("что-то после цикла");
    }
}
