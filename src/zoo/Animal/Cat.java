package zoo.Animal;

public class Cat extends Animals {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " meaw");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ate...");
    }
    @Override
    public String getType() {
        return "Cat";
    }

}
