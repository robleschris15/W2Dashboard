package com.gcucapstone.dashboard.entity;

import lombok.*;

import javax.persistence.*;

/**-------------------------------------------------------------------
  Authors:      | Chris Robles
  Class:        | STG451 - Capstone 1
  Institution:  | Grand Canyon University
  Instructor:   | Dr. Isac Artzi
  Date:         | (created) 10-11-2022
  File:         | lookupType.java
  Version:      | 1.0
  Description:  | This class represents the loolup_types table/entity in the CapstoneDashboard DB
  				| It will be used to create loopkupType records and determine relationship between tables with fields/attributes
---------------------------------------------------------------------
Notes:

----------------------------------------------------------------------*/

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(
		name = "lookup_types",
		schema = "CapstoneDashboard"
)
public class LookupType {

	//----------------------------------------------------
	// Instance Variables
	//----------------------------------------------------
	@Id
	@Column(name = "lookup_type_id")
	private Long lookupTypeId;


	@Column(name = "lookup_type")
	private String lookupType;

}// lookupType Class

