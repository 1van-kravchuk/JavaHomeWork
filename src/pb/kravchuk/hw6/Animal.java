package pb.kravchuk.hw6;

public abstract class Animal {
    private String voice;
    private String food;
    private String location;

    public Animal(String food, String voice, String location){
        this.food = food;
        this.voice = voice;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public void makeVoice() {
        System.out.println("says" + voice);
    }

    public void eat() {
        System.out.println(" eats" + food);
    }

    public void sleep() {
        System.out.println(" is sleeping");
    }
}
