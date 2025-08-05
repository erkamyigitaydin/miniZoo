package zoo;

import zoo.Animal.Animals;
import zoo.Logic.AnimalFactory;
import zoo.Logic.ZooManager;

import java.util.Scanner;

enum MenuOption {
    ADD_ANIMAL,
    LIST_ANIMALS,
    FEED_ALL,
    MAKE_ALL_SOUNDS,
    EXIT,
    INVALID;

    public static MenuOption from(String input) {
        return switch (input) {
            case "1" -> ADD_ANIMAL;
            case "2" -> LIST_ANIMALS;
            case "3" -> FEED_ALL;
            case "4" -> MAKE_ALL_SOUNDS;
            case "0" -> EXIT;
            default -> INVALID;
        };
    }
}

public class Application {

    private static void printMenu() {
        System.out.println("\n----- Mini Zoo Menu -----");
        System.out.println("1. Add Animal");
        System.out.println("2. List Animals");
        System.out.println("3. Feed All Animals");
        System.out.println("4. Make All Animals Sound");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooManager zoo = new ZooManager();

        boolean running = true;

        while (running) {
            printMenu();
            String input = scanner.nextLine();
            MenuOption selection = MenuOption.from(input);

            switch (selection) {
                case ADD_ANIMAL -> {
                    System.out.print("Animal type (cat/dog/bird): ");
                    String type = scanner.nextLine().trim().toLowerCase();

                    if (!AnimalFactory.isValidType(type)) {
                        System.out.println("Invalid type!");
                        break;
                    }

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age;
                    try {
                        age = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age!");
                        break;
                    }

                    Animals animal = AnimalFactory.createAnimal(type, name, age);
                    if (animal != null) {
                        zoo.addAnimal(animal);
                    }
                }
                case LIST_ANIMALS -> zoo.listAnimals();
                case FEED_ALL -> zoo.feedAllAnimals();
                case MAKE_ALL_SOUNDS -> zoo.listAllSounds();
                case EXIT -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                case INVALID -> System.out.println("Invalid selection! Please enter a valid menu number.");
            }
        }

        scanner.close();
    }
}
