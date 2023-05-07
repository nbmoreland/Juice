package net.nicholasmoreland.juice.database;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bukkit.Bukkit;

public class DatabaseManager {

    private final String COLLECTION_NAME;
    private final String DATABASE_NAME;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public DatabaseManager(String ip, int port, String databaseName, String collectionName) {
        this.COLLECTION_NAME = collectionName;
        this.DATABASE_NAME = databaseName;

        connect(ip, port);
    }

    public void connect(String ip, int port) {
        ConnectionString connectionString = new ConnectionString("mongodb://" + ip + ":" + port);
        MongoClient mongodb = MongoClients.create(connectionString);

        this.database = mongodb.getDatabase(DATABASE_NAME);
        this.collection = database.getCollection(COLLECTION_NAME);
        Bukkit.getConsoleSender().sendMessage("Connected " + database);
    }

    public void addUser(String uuid, String username, String rank) {
        Document newUser = new Document("uuid", uuid)
                .append("username", username)
                .append("rank", rank);
        collection.insertOne(newUser);
    }

    public Document findUser(String username) {
        Document query = new Document("username", username);
        return collection.find(query).first();
    }

}
