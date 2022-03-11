package ro.ase.acs.contracts;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.Connection;
import java.sql.SQLException;

public interface Close {
    void closeTable(Connection connection) throws SQLException;

    void closeTable(MongoClient mongoClient, MongoDatabase mongoDb, MongoCollection<Document> collection);
}
