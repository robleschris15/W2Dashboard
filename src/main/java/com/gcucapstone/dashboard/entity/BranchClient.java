package com.gcucapstone.dashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Embeddable;


/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 10-11-2022
 * File:           | BranchClient.java
 * Version:        | 1.0
 * Description:    | This Class will be used to created composite Primary Keys
 *                 | within the entities that require it. (Branch and Client fields)
 * ---------------------------------------------------------------------------
 * Notes:
 *
 * --------------------------------------------------------------------------*/
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchClient implements  Serializable{

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    private String branch;

    private String clientId;

} // BranchClient Class
