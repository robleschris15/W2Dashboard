package com.gcucapstone.dashboard.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | LookupTable.java
 * Version:        | 1.0
 * Description:    | This File will be used to Map LookupTable Models &
 *                 | Documents from the CapstoneDashboard Mongo Database
 * ---------------------------------------------------------------------------
 */
@Data
@Document(collection = "LookupTable")
public class LookupTable {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Id
    private Long lookupId;

    private String abbreviation;

    private String description;

    private String fullName;

    private LookupType lookupTypeId;

    private String state;

}//LookupTable Class
