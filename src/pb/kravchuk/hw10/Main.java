package pb.kravchuk.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox<Integer> arr = new NumBox<>(4);
        arr.add(0, 2);
        arr.add(1, 3);
        arr.add(2, 5);
        arr.add(3, 9);

        System.out.println(arr.get(0));
        System.out.println(arr.average());
        System.out.println(arr.sum());
        System.out.println(arr.length());
        System.out.println(arr.max());
        System.out.println();

        NumBox<Float> arr1 = new NumBox<>(5);
        arr1.add(0, 15.2f);
        arr1.add(1, 12.2f);
        arr1.add(2, 0.4f);
        arr1.add(3, 2.6f);
        arr1.add(4, 20.1f);

        System.out.println(arr1.get(2));
        System.out.println(arr1.average());
        System.out.println(arr1.sum());
        System.out.println(arr1.length());
        System.out.println(arr1.max());
    }
}
