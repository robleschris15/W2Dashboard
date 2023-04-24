package com.gcucapstone.dashboard.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | LookupType,java
 * Version:        | 1.0
 * Description:    | This File will be used to Map LookupType Models &
 *                 | Documents from the CapstoneDashboard Mongo Database
 * ---------------------------------------------------------------------------
 */
@Data
@Document(collection = "LookupType")
public class LookupType {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    private Long lookupTypeId;

    private String lookupType;

}//LookupType Class
