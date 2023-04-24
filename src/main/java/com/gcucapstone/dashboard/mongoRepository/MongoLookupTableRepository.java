package com.gcucapstone.dashboard.mongoRepository;

import com.gcucapstone.dashboard.models.LookupTable;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoLookupTableRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *  *              | for Mongo LookupTable Documents
 * ---------------------------------------------------------------------------
 */
public interface MongoLookupTableRepository extends MongoRepository<LookupTable, Long> {

    //----------------------------------------------------
    // Query Methods
    //----------------------------------------------------

}// MongoLookupTableRepository Interface
