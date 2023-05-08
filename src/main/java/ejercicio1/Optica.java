package ejercicio1;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Optica {
    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {

            //Accessing the database
            MongoDatabase database = mongoClient.getDatabase("Opticas");

            MongoCollection<Document> ulleres = database.getCollection("Ulleres");
            MongoCollection<Document> proveidors = database.getCollection("Proveidors");
            MongoCollection<Document> clients = database.getCollection("Clients");

            Document ullera = new Document("id", "ullera1");
            ullera.append("marca", "Eschenbach")
                    .append("proveidor", "proveidor1")
                    .append("graduacio",0.15)
                    .append("tipus de montura","titani")
                    .append("color muntura","negre")
                    .append("color vidre dret","negre")
                    .append("color vidre esquerre","negre")
                    .append("preu",550)
                    .append("venedor","01");
            ulleres.insertOne(ullera);


            Document proveidor = new Document("id", "proveidor1");
            proveidor.append("nom", "proveidor1").append("telefon",121212121).append("Fax",121212121).append("NIF","453123123");
            proveidors.insertOne(proveidor);

            Document client = new Document("id", "client1");
            client.append("nom", "proveidor1").append("nom", "cliente1").append("adreca","carrer sant 1 4t 3ra").append("telefon",1212121212).append("email","cliente1@gmail.com").append("data de registre","05/05/2023").append("recomanat per","");
            clients.insertOne(client);

        }
    }


}
