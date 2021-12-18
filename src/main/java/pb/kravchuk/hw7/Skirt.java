package pb.kravchuk.hw7;

public class Skirt extends Clothes implements WomenClothes {
    private String name;

    Skirt(String name, Size size, String color, double price) {
        super(size, color, price);
        this.name = name;
    }

    @Override
    public String dressWoman() {
        return name + " (" + size + " " + color + " " + price + ")";
    }

    @Override
    public String toString() {
        return "Skirt{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
