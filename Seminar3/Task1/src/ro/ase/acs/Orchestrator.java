package ro.ase.acs;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ro.ase.acs.contracts.Close;
import ro.ase.acs.contracts.Create;
import ro.ase.acs.contracts.Insert;
import ro.ase.acs.contracts.Read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Orchestrator {
    private Create create;
    private Insert insert;
    private Read read;
    private Close close;

    public Orchestrator(Create create, Insert insert, Read read, Close close) {
        this.create = create;
        this.insert = insert;
        this.read = read;
        this.close = close;
    }

    public void executeSQL(Create create, Insert insert, Read read, Close close) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        connection.setAutoCommit(false);

        create.createTable(connection);
        insert.insertData(connection);
        read.readData(connection);
        close.closeTable(connection);
    }

    public void executeNoSQL(Create create, Insert insert, Read read, Close close) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDb = mongoClient.getDatabase("test");

        MongoCollection<Document> collection = mongoDb.getCollection("employees");

        create.createTable(mongoClient, mongoDb, collection);
        insert.insertData(mongoClient, mongoDb, collection);
        read.readData(mongoClient, mongoDb, collection);
        close.closeTable(mongoClient, mongoDb, collection);
    }
}
