package pb.kravchuk.hw7;

public abstract class Clothes {

    String size;
    String color;
    double price;


    Clothes(Size size, String color, double price) {
        this.size = size.getDescription();
        this.color = color;
        this.price = price;
    }

    public String getSize() {
        return size;
    }
}
