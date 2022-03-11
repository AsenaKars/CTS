package ro.ase.acs;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.acs.contracts.Close;

import java.sql.Connection;
import java.sql.SQLException;

public class CloseDB implements Close {

    @Override
    public void closeTable(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public void closeTable(MongoClient mongoClient, MongoDatabase mongoDb, MongoCollection<Document> collection) {
        mongoClient.close();
    }
}
