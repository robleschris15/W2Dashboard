package com.gcucapstone.dashboard.models;

import com.gcucapstone.dashboard.entity.BranchClient;
import com.gcucapstone.dashboard.entity.LookupTable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | Carrier.java
 * Version:        | 1.0
 * Description:    | This File will be used to Map Carrier Models &
 *                 | Documents from the CapstoneDashboard Mongo Database
 * ---------------------------------------------------------------------------
 */
@Data
@Document(collection = "Carrier")
public class Carrier {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Id
    private BranchClient carrierId;

    private String destinationAddress;

    private String trackingId;

    private com.gcucapstone.dashboard.entity.LookupTable carrierLookupId;

    private LookupTable deliveryStatusTypeId;


}//Carrier Class
