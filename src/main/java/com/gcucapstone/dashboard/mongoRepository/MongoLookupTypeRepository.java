package com.gcucapstone.dashboard.mongoRepository;

import com.gcucapstone.dashboard.models.LookupType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoLookupTypeRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *  *              | for Mongo LookupType Documents
 * ---------------------------------------------------------------------------
 */
public interface MongoLookupTypeRepository extends MongoRepository<LookupType, Long> {

    //----------------------------------------------------
    // Query Methods
    //----------------------------------------------------

    @Query("{'lookupTypeID' : '?0'}")
    LookupType findByLookupTypeID(Long lookupTypeID);

    LookupType findByLookupType(String type);
}
