package zoo.Animal;

public class Dog extends Animals {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " barked.");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ate bones...");
    }
    @Override
    public String getType() {
        return "Dog";
    }

}