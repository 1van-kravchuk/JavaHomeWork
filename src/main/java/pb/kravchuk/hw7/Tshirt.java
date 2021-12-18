package pb.kravchuk.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    private String name;

    Tshirt(String name, Size size, String color, double price) {
        super(size, color, price);
        this.name = name;
    }

    @Override
    public String dressMan() {
        return name + " (" + size + " " + color + " " + price + ")";
    }

    @Override
    public String dressWoman() {
        return name + " " + size + " " + color + " " + price;
    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
