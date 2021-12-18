package pb.kravchuk.hw7;

public class Tie extends Clothes implements ManClothes {
    private String name;

    Tie(String name, Size size, String color, double price) {
        super(size, color, price);
        this.name = name;
    }

    @Override
    public String dressMan() {
        return name + " (" + size + " " + color + " " + price + ")";
    }

    @Override
    public String toString() {
        return "Tie{" +
                "size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

