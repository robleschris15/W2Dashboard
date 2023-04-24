package com.gcucapstone.dashboard.mongoRepository;

import com.gcucapstone.dashboard.entity.BranchClient;
import com.gcucapstone.dashboard.models.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | MongoVendorRepository.java (mongo)
 * Version:        | 1.0
 * Description:    | This File will be used to write Query methods
 *  *              | for Mongo Vendor Documents
 * ---------------------------------------------------------------------------
 */
public interface MongoVendorRepository extends MongoRepository<Vendor, BranchClient> {

    //----------------------------------------------------
    // Query Methods
    //----------------------------------------------------


}// MongoVendorRepository Interface
