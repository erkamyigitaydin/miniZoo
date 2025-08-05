package com.minizoo;

import org.bson.Document;

/**
 * Represents an animal that can be stored in MongoDB.
 */
public class Animal {
    private final String name;
    private final String species;
    private final int age;

    /**
     * Creates a new {@code Animal} instance.
     *
     * @param name    the animal's name
     * @param species the type of animal
     * @param age     the animal's age
     */
    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    /**
     * Converts this {@code Animal} to a MongoDB {@link Document}.
     *
     * @return document representing the animal
     */
    public Document toDocument() {
        return new Document("name", name)
                .append("species", species)
                .append("age", age);
    }

    /**
     * Creates an {@code Animal} from a MongoDB {@link Document}.
     *
     * @param doc document to convert
     * @return new {@code Animal}
     */
    public static Animal fromDocument(Document doc) {
        String name = doc.getString("name");
        String species = doc.getString("species");
        int age = doc.getInteger("age", 0);
        return new Animal(name, species, age);
    }

    @Override
    public String toString() {
        return "%s (%s, %d)".formatted(name, species, age);
    }
}
