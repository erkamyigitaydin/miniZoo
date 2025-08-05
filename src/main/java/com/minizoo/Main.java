package com.minizoo;

import java.util.List;

/**
 * Demonstrates basic usage of the MongoDB repository.
 */
public class Main {

    public static void main(String[] args) {
        // Create a connector and repository within a try-with-resources block
        try (MongoDBConnector connector = new MongoDBConnector()) {
            AnimalRepository repository = new AnimalRepository(connector.getDatabase());

            // Sample animal
            Animal lion = new Animal("Leo", "Lion", 5);
            repository.save(lion);

            // Fetch all animals and display them
            List<Animal> animals = repository.findAll();
            animals.forEach(System.out::println);
        }
    }
}
