package pb.kravchuk.hw7;

public class Atelier {
    public static void main(String[] args) {
        Pants pants = new Pants("pants", Size.XXS, "Blue", 29.99);
        Pants shorts = new Pants("shorts", Size.XS, "Yellow", 9.99);
        Tshirt tshirt = new Tshirt("Shirt", Size.S, "White", 12.99);
        Skirt skirt = new Skirt("Skirt", Size.L, "Red", 129.99);
        Tie tie = new Tie("tie", Size.M, "Black", 4.99);

        Clothes[] clothes = new Clothes[]{pants, tshirt, skirt, tie};

        System.out.println(new StringBuilder().append("shorts size ").append(shorts.getESize()));
        System.out.println();
        System.out.println(new StringBuilder().append(tie).append(" is ").append(tie.getSize()));
        System.out.println();
        System.out.println("Men's dress");
        dressMan(clothes);
        System.out.println("----------------------------------");
        System.out.println("Women's dress");
        dressWoman(clothes);
    }

    private static void dressMan(Clothes[] clothes) {
        for (Clothes clothes1 : clothes) {
            if (clothes1 instanceof ManClothes) System.out.println(clothes1);
        }
    }

    private static void dressWoman(Clothes[] clothes) {
        for (Clothes clothes1 : clothes) {
            if (clothes1 instanceof WomenClothes) {
                System.out.println(clothes1);
            }
        }
    }
}
