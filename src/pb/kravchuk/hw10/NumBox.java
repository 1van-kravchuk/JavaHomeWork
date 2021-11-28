package pb.kravchuk.hw10;



public class NumBox<T extends Number> {
    private T[] array;


    public NumBox(int maxLength) throws ClassCastException {
        array = (T[]) new Number[maxLength];
    }

    public void add(int index, T num) {

        try {

            array[index] = num;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("array is fool: " + e);
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
        for (T t : array) {
            sum = sum + t.doubleValue();
        }
        return sum / array.length;
    }

    public double sum() {
        double sum = 0;
        for (T t : array) {
            sum = sum + t.doubleValue();
        }
        return sum;
    }
public T max(){

     T maxNum = array[0];
    for (T t : array) {
        if (maxNum.doubleValue() <= t.doubleValue()) {
            maxNum = t;
        }
    }
    return maxNum;
}
}
