package pb.kravchuk.hw10;

public class Main {
    public static void main(String[] args) {
        NumBox arr = new NumBox(3);
        arr.add(2);
        arr.add(5);
        arr.add(7);
 //       arr.add(9);

        System.out.println(arr.get(2));
        System.out.println(arr.average());
        System.out.println(arr.sum());
        System.out.println(arr.length());

    }
}
