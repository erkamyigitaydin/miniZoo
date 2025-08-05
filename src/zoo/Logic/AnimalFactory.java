package zoo.Logic;

import zoo.Animal.*;

import java.util.Arrays;
import java.util.List;

public class AnimalFactory {
    private static final List<String> validTypes = Arrays.asList("cat", "dog", "bird");

    public static boolean isValidType(String type) {
        return validTypes.contains(type.toLowerCase());
    }

    public static Animals createAnimal(String type, String name, int age) {
        return switch (type.toLowerCase()) {
            case "cat" -> new Cat(name, age);
            case "dog" -> new Dog(name, age);
            case "bird" -> new Bird(name, age);
            default -> null;
        };
    }
}