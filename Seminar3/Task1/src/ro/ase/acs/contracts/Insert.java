package ro.ase.acs.contracts;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.Connection;
import java.sql.SQLException;

public interface Insert {
    void insertData(Connection connection) throws SQLException;

    void insertData(MongoClient mongoClient, MongoDatabase mongoDb, MongoCollection<Document> collection);
}
