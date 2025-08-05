package zoo.Animal;

public class Bird extends Animals {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " cik cik.");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ate...");
    }
    @Override
    public String getType() {
        return "Bird";
    }

}