package com.gcucapstone.dashboard.mongoRepository;

import com.gcucapstone.dashboard.entity.BranchClient;
import com.gcucapstone.dashboard.models.Carrier;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoCarrierRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *                 | for Mongo Carrier Documents
 * ---------------------------------------------------------------------------
 */
public interface MongoCarrierRepository extends MongoRepository<Carrier, BranchClient> {

    //----------------------------------------------------
    // Query Methods
    //----------------------------------------------------

}//MongoCarrierRepository Interface
