package com.gcucapstone.dashboard.changeStreams;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)11-11-2022
 * File:           | AtlasConnectionTest.java
 * Version:        | 1.0
 * Description:    | This file is used to test the connection to the Mongo
 *                 | Atlas Cluster (cluster0)
 * ---------------------------------------------------------------------------
 */
public class AtlasConnectionTest {

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://csd-user:csd-password@cluster0.p6ivz1h.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
        }
    }
}// AtlasConnctionTest Class
