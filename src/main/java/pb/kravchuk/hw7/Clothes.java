package pb.kravchuk.hw7;

public abstract class Clothes {

    Size size;
    String color;
    double price;
    int eS;


    Clothes(Size size, String color, double price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public String getSize() {

        return size.getDescription();
    }
    public int getESize(){
        return size.getEuroSize();
        }
}
