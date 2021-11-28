package pb.kravchuk.hw10;

import java.util.Arrays;

public class NumBox<T> extends Number {
    private T[] array;
    private int maxLength;

    public NumBox(int maxLength) {
        this.array = (T[]) new Object[maxLength];
    }

    public void add(T num) {
        T[] newArray = Arrays.copyOf(array, array.length+1);
        try {
            array = newArray;
            array[array.length - 1] = num;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("array is fool" + e);
        }
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }

    public double average() {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + (Double) array[i];
        }
        double average = sum / array.length;
        return average;
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + (Double) array[i];
        }
        return sum;
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
//public T[] max(){
//        double maxNum = 0;
//    for (int i = 0; i< array.length; i++) {
//        if (maxNum <= (Double) array[i]){
//            maxNum = (Double) array[i];
//        }
//    }
//    return doubleValue(maxNum);
//}
}
