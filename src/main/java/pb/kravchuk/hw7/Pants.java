package pb.kravchuk.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    private String name;

    Pants(String name, Size size, String color, double price) {
        super(size, color, price);
        this.name = name;
    }

    @Override
    public String dressMan() {
        return name + " (" + size + " " + color + " " + price + ")";
    }

    @Override
    public String dressWoman() {
        return name + " (" + size + " " + color + " " + price + ")";
    }

    @Override
    public String toString() {
        return "Pants {" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
