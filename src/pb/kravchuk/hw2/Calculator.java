package pb.kravchuk.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double result = 0;
        int operand1;
        int operand2;
        String sign;

        Scanner scan = new Scanner(System.in);
        System.out.println("введите первое число:");
        operand1 = scan.nextInt();
        System.out.println("введите второе число:");
        operand2 = scan.nextInt();
        System.out.println("введите знак действия:");
        sign = scan.next();
        if (operand2 == 0 && sign.equals("/")) {
            System.out.println("Делить на 0 нельзя");
        } else {
            switch (sign) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    result = ((double) operand1) / operand2;
                    break;
            }
            System.out.println("Результат действия: " + result);
        }

    }
}
