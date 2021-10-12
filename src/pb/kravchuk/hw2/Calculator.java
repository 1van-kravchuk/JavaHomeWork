package pb.kravchuk.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int result = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("введите число а:");
        int a = scan.nextInt();
        System.out.println("введите число b:");
        int b = scan.nextInt();
        System.out.println("введите знак действия:");
        String sign = scan.next();
        if (b == 0 && sign.equals("/")){
            System.out.println("Делить на 0 нельзя");
        } else {
            switch (sign){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                case "/":
                    result = a/b;
                    break;
            }
            
        }
        System.out.println("Результат действия: " + result);
    }
}
