package pb.kravchuk.hw6;

public class Horse extends Animal {
    private String name;


    public Horse(String food, String voice, String location, String name) {
        super(food, voice, location);
        this.name = name;
    }

    @Override
    public void makeVoice() {
        System.out.println(name + " says " + getVoice());
    }

    @Override
    public void eat() {
        System.out.println(name + " eats " + getFood());
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping");
    }

    @Override
    public String toString() {
        return name + " (eats " + getFood() + ", says " + getVoice() + ", sleeping in the " + getLocation() + ") ";
    }

    @Override
    public int hashCode() {
        int result = getFood() == null ? 0 : getFood().hashCode();
        int result1 = getVoice() == null ? 0 : getVoice().hashCode();
        int result2 = getLocation() == null ? 0 : getLocation().hashCode();
        result = 31 * result + result1;
        result = 31 * result + result2;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Horse that = (Horse) obj;
        if (getFood() != that.getFood()) return false;
        if (getVoice() != that.getVoice()) return false;
        if (getLocation() != that.getLocation()) return false;
        return name.equals(that.name);
    }
}
