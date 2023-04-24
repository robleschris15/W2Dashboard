package com.gcucapstone.dashboard.repository;

import com.gcucapstone.dashboard.entity.Client;
import com.gcucapstone.dashboard.entity.LookupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-21-2022
 * File:           | ClientRepository.java
 * Version:        | 1.0
 * Description:    |This interface file is where JPARepository Methods, JPQL and
 *                 | native SQL Query methods will be defined for Client entities
 * ---------------------------------------------------------------------------
 * Notes:
 *  - create findBy-CreatedDates?
 *----------------------------------------------------------------------------*/
public interface ClientRepository extends JpaRepository<Client, String> {

    //----------------------------------------------------
    // Query Method Definitions
    //----------------------------------------------------

    //---------------------------------------
    // *** Find By Individual Attributes ***
    //---------------------------------------

    /**
     * This is method returns a Client record that has a w2TransmissionId
     * attribute that matches the passed parameter
     * @param w2TransmissionId  - the w2TransmissionId to search for
     * @return                  - the Client record
     */
    @Query("SELECT c FROM Client c WHERE c.w2TransmissionId = ?1")
    Client findByW2TransmissionId(String w2TransmissionId);

    /**
     * This method returns a Client record that has a branch attribute that
     * matches the passed parameter.
     * @param branch    - the branch to search for
     * @return          - the client record
     */
    List<Client> findByBranch(String branch);

    /**
     * This method returns a list of Client records that have an attribute
     * employeeCount that matches the passed parameter.
     * @param employeeCount - the quantity of employees to search for
     * @return              - the list of Client records
     */
    List<Client> findByEmployeeCount(int employeeCount);

    /**
     * This method returns a client record that has a transmissionFile attribute
     * that matches the passed parameter
     * @param transmissionFile  - the transmission file to search for
     * @return                  - the client record
     */
    Client findByTransmissionFile(String transmissionFile);

    /**
     * This method returns a list of Client records that have a w2Count atttribute
     * that matches the passed parameter
     * @param w2Count   - the number of w2's to search for
     * @return          - the list of Client record(s)
     */
    List<Client> findByW2Count(int w2Count);

    /**
     * This method returns a list of Client records that have a W2DeliveryAddress
     * attribute that match the passed parameter
     * @param w2DeliveryAddress - the delivery address to search for
     * @return                  - the list of Client record(s)
     */
    List<Client> findByW2DeliveryAddress(String w2DeliveryAddress);

    /**
     * This method returns a Client record that has an attribute of clientTypeId
     * that matches the passed parameter.
     * @param clientTypeId  - the LookupTable to search for
     * @return              - the Client record
     */
    Client findByClientTypeId(LookupTable clientTypeId);

    /**
     * This method returns a Client record that has an attribute of DeliveryCodeTypeId
     * that matches the passed parameter.
     * @param deliveryCodeTypeId    - deliveryCodeTypeID to search for
     * @return                      - Client record
     */
    Client findByDeliveryCodeTypeId(LookupTable deliveryCodeTypeId);

    /**
     * This method is a custom written JPQL Query method that returns a list of
     * Client records that have a state attribute (of their LookupTable FK attribute)
     * that matches the passed argument
     * @param state - the state attribute to search for
     * @return      - a List of Client records
     */
    @Query("SELECT c FROM Client c WHERE c.clientTypeId.state = ?1")
   List<Client> findByLookupTableState(String state);

    /**
     * This method is a custom JPQL QUery method that returns a Client
     * record that corresponds to the lookupTable Lookup ID attribute
     * that matches the pass argument
     * @param id
     * @return CLient record
     */
    @Query("SELECT c FROM Client c WHERE c.clientTypeId.lookupId = ?1")
   Client findByLookupTableClientTypeId(Long id);





} //ClientRepository Interface
