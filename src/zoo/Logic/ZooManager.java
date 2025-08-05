package zoo.Logic;

import zoo.Animal.Animals;

import java.util.ArrayList;
import java.util.List;

public class ZooManager {
    private final List<Animals> animals = new ArrayList<>();

    public void addAnimal(Animals animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " has been added to the zoo.");
    }

    public void listAllSounds() {
        if (animals.isEmpty()) {
            System.out.println("There are no animals in the zoo.");
            return;
        }

        System.out.println("All animals are making sounds:");
        for (Animals animal : animals) {
            animal.makeSound();
        }
    }

    public void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("The zoo is currently empty.");
            return;
        }

        System.out.println("Animals in the zoo:");
        for (Animals animal : animals) {
        	System.out.println("- " + animal.getName() + " (" + animal.getAge() + " years old, Type: " + animal.getType() + ")");
        }
    }

    public void feedAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("There are no animals to feed.");
            return;
        }

        System.out.println("Feeding all animals:");
        for (Animals animal : animals) {
            animal.feed();
        }
    }
}
