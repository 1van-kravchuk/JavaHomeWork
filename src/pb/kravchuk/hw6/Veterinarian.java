package pb.kravchuk.hw6;

public class Veterinarian {
    private String name = "Joe";

    //    public String getName() {
//        return name;
//    }
    public void treatment(Animal animal) {
        System.out.println(animal + "is treats");
    }

    @Override
    public String toString() {
        return name;
    }
}
