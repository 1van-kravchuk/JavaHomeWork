package pb.kravchuk.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        System.out.println("enter num in array");
        int i;
        int[] arr = new int[10];
        Scanner scan = new Scanner(System.in);
        for (i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int sum = 0;
        for (i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println("sum of muns in array = " + sum);
        System.out.println();
        int sumPositive = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sumPositive = sumPositive + arr[i];
            } else {
                continue;
            }
        }
        System.out.println("sum of positive elements is " + sumPositive);
        System.out.println();

        int tmp;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        System.out.println("Sorted array");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
