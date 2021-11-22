package pb.kravchuk.hw6;


import java.lang.reflect.Field;

public class VetClinic {
    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        try {
            Field field = veterinarian.getClass().getField("name");
            field.setAccessible(true);
            String name = (String) field.get(veterinarian);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, i am veterinarian, "+ veterinarian);
        System.out.println();
        Animal[] animals = new Animal[3];
        animals[0] = new Cat("fish", "Meow meow", "house", "Mojo");
        animals[1] = new Dog("meat", "Bow wow", "Dog house", "Spike");
        animals[2] = new Horse("oats", "Neigh neigh", "stall", "Gosha");



        for (Animal anim:
             animals) {
            veterinarian.treatment(anim);
            System.out.println("------------------------------------");
        }




    }
}
