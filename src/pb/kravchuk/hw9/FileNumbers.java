package pb.kravchuk.hw9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileNumbers {
    public void createNumbersFile() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (((int) Math.random() * 100) + 1);
            }
        }
        try (Writer writer = new FileWriter("files/numbers.txt")) {
            writer.write(String.valueOf(arr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createOddNumbersFile() {
        Path path = Paths.get("files/numbers.txt");

        try (Scanner scan = new Scanner(path)) {
            while (true) {
                String str = scan.nextLine();
                System.out.println(str);
            }
        } catch (NoSuchElementException e) {
            System.out.println("file has been read");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileNumbers fileNumbers = new FileNumbers();
        fileNumbers.createNumbersFile();
//        fileNumbers.createOddNumbersFile();
    }
}
