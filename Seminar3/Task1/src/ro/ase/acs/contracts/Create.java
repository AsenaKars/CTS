package ro.ase.acs.contracts;

import java.sql.Connection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.SQLException;

public interface Create {
    void createTable(Connection connection) throws SQLException;

    void createTable(MongoClient mongoClient, MongoDatabase mongoDb, MongoCollection<Document> collection);
}
