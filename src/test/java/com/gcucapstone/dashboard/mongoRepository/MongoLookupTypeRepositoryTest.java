package com.gcucapstone.dashboard.mongoRepository;

import com.gcucapstone.dashboard.models.LookupType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**-------------------------------------------------------------------
 Authors:      | Chris Robles
 Class:        | STG451 - Capstone 1
 Institution:  | Grand Canyon University
 Instructor:   | Dr. Isac Artzi
 Date:         | (created) 10-28-2022
 File:         | MongoLookupTypeRepositoryTest.java (mongo)
 Version:      | 1.0
 Description:  | This class will be used to test query methods
               | in the Mongo Repository interface MongoLookupTypeRepository
 ---------------------------------------------------------------------
 Notes:

 ----------------------------------------------------------------------*/
@SpringBootTest
public class MongoLookupTypeRepositoryTest {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @Autowired
    private MongoLookupTypeRepository lookupTypeRepository;

    //----------------------------------------------------
    // Query Methods Tests
    //----------------------------------------------------


    @Test
    void findAllLookupType(){
        lookupTypeRepository.findAll().forEach((l) ->{
            System.out.println("TYPE: " + l.getLookupType());
        });
    }

    @Test
    void findByLookupTypeId(){
       LookupType lookupType = lookupTypeRepository.findByLookupTypeID(903999L);
        System.out.println("TYPE :" + lookupType.getLookupType());
        System.out.println("ID: " + lookupType.getLookupTypeId());
    }



}// MongoLookupTypeRepositoryTest Class
