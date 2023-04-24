package com.gcucapstone.dashboard.changeStreams;

import com.gcucapstone.dashboard.models.LookupType;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static com.mongodb.client.model.Filters.in;

import org.bson.conversions.Bson;
import static java.util.Arrays.asList;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.changestream.FullDocument.UPDATE_LOOKUP;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.sql.*;
import java.util.List;
import java.util.function.Consumer;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 11-10-2022
 * File:           | LookupTypeChangeStreams.java
 * Version:        | 1.0
 * Description:    | This file will be used to monitor changes to the Mongo
 *                 | Atlas Collection : LookupTypes
 * ---------------------------------------------------------------------------
 */
public class LookupTypeChangeStreams extends Thread{

    @Override
    public void run(){

        ConnectionString connectionString = new ConnectionString(("mongodb+srv://csd-user:csd-password@cluster0.p6ivz1h.mongodb.net/?retryWrites=true&w=majority"));
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).codecRegistry(codecRegistry).build();

        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("CapstoneDashboard");
            MongoCollection<LookupType> lookupTypes = db.getCollection("LookupType", LookupType.class);
            List<Bson> pipeline;


            lookupTypes.watch(asList(Aggregates.match(Filters.in("operationType", asList("update","insert")))))
                    .fullDocument(UPDATE_LOOKUP).forEach((d) -> {

                        switch(d.getOperationTypeString()){

                            case "update":
                                System.out.println("****************************\n****************************\n****************************");
                                System.out.println("LOOKUPTYPE - Updated Doc: " + d.getFullDocument().toString());
                                System.out.println("****************************\n****************************\n****************************");

                                com.gcucapstone.dashboard.entity.LookupType updated_lookupType =  new com.gcucapstone.dashboard.entity.LookupType();
                                updated_lookupType.setLookupType(d.getFullDocument().getLookupType());
                                updated_lookupType.setLookupTypeId(d.getFullDocument().getLookupTypeId());


                                submitUpdateQuery(updated_lookupType);
                                break;
                            case "insert":
                                System.out.println("****************************\n****************************\n****************************");
                                System.out.println("LOOKUPTYPE - Inserted Doc: " + d.getFullDocument().toString());
                                System.out.println("****************************\n****************************\n****************************");

                                com.gcucapstone.dashboard.entity.LookupType inserted_lookupType =  new com.gcucapstone.dashboard.entity.LookupType();
                                inserted_lookupType.setLookupType(d.getFullDocument().getLookupType());
                                inserted_lookupType.setLookupTypeId(d.getFullDocument().getLookupTypeId());

                                submitInsertQuery(inserted_lookupType);
                                break;
                        }
                    });
    }
}

    public void submitUpdateQuery(com.gcucapstone.dashboard.entity.LookupType lookupType){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://129.146.131.10:3306/CapstoneDashboard?createDatabaseIfNotExist=true", "capstone", "JJN#5AiKgFDM");){

            String sqlQuery = "UPDATE `CapstoneDashboard`.`lookup_types` SET `lookup_type` = ? WHERE (`lookup_type_id` = ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, lookupType.getLookupType());
            preparedStatement.setLong(2, lookupType.getLookupTypeId());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void submitInsertQuery(com.gcucapstone.dashboard.entity.LookupType lookupType){

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://129.146.131.10:3306/CapstoneDashboard?createDatabaseIfNotExist=true", "capstone", "JJN#5AiKgFDM");){

            String sqlQuery = "INSERT INTO `CapstoneDashboard`.`lookup_types` (`lookup_type_id`, `lookup_type`) VALUES (?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, lookupType.getLookupTypeId());
            preparedStatement.setString(2, lookupType.getLookupType());

            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    private static Consumer<ChangeStreamDocument<LookupType>> printEvent() {
        return System.out::println;
    }
}// LookupTypeChangeStreams Class




