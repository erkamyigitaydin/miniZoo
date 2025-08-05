package com.minizoo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Handles connection to the MongoDB instance.
 */
public class MongoDBConnector implements AutoCloseable {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "miniZoo";

    private final MongoClient client;
    private final MongoDatabase database;

    /**
     * Establishes a new connection to MongoDB using the default URI.
     */
    public MongoDBConnector() {
        this.client = MongoClients.create(CONNECTION_STRING);
        this.database = client.getDatabase(DATABASE_NAME);
    }

    /**
     * Provides the {@link MongoDatabase} instance for the application.
     *
     * @return the connected database
     */
    public MongoDatabase getDatabase() {
        return database;
    }

    /**
     * Closes the underlying {@link MongoClient} connection.
     */
    @Override
    public void close() {
        client.close();
    }
}
