package com.gcucapstone.dashboard.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-28-2022
 * File:           | Client.java
 * Version:        | 1.0
 * Description:    | This File will be used to Map Client Models &
 *                 | Documents from the CapstoneDashboard Mongo Database
 * ---------------------------------------------------------------------------
 */
@Data
@Document(collection = "Client")
public class Client {

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------

    @Id
    private String w2TransmissionId;

    private String branch;

    private String createdDate;

    private int employeeCount;

    private String transmissionFile;

    private int w2Count;

    private String w2DeliveryAddress;

    private LookupTable clientTypeId;

    private LookupTable deliveryCodeTypeId;

}//Client Class
