package com.minizoo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 * Repository layer for performing operations on the {@code animals} collection.
 */
public class AnimalRepository {

    private final MongoCollection<Document> animals;

    /**
     * Creates a repository bound to the {@code animals} collection.
     *
     * @param database database reference obtained from {@link MongoDBConnector}
     */
    public AnimalRepository(MongoDatabase database) {
        this.animals = database.getCollection("animals");
    }

    /**
     * Inserts a new animal document into the collection.
     *
     * @param animal entity to persist
     */
    public void save(Animal animal) {
        animals.insertOne(animal.toDocument());
    }

    /**
     * Retrieves all animals stored in the collection.
     *
     * @return list of animals
     */
    public List<Animal> findAll() {
        List<Animal> result = new ArrayList<>();
        try (MongoCursor<Document> cursor = animals.find().iterator()) {
            while (cursor.hasNext()) {
                result.add(Animal.fromDocument(cursor.next()));
            }
        }
        return result;
    }
}
