/**
 * Module descriptor for the MiniZoo application.
 */
module miniZoo {
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;

    exports com.minizoo;
}