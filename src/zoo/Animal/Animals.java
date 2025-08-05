package zoo.Animal;

public abstract class Animals {
    private String name;
    private int age;

    protected Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public abstract String getType();
    public abstract void makeSound();
    public abstract void feed();
}
