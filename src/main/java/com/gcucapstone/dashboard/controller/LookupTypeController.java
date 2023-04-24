package com.gcucapstone.dashboard.controller;

import com.gcucapstone.dashboard.entity.LookupType;
import com.gcucapstone.dashboard.repository.LookupTypeRepository;
import exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon University
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created)10-26-2022
 * File:           | LookupTypeController.java
 * Version:        | 1.0
 * Description:    | This file will be used to create REST API's for
 *                 | LookupType Entities such as the basic CRUD methods
 * ---------------------------------------------------------------------------
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dashboard/lookuptype")
public class LookupTypeController{

    //----------------------------------------------------
    // Instance Variables
    //----------------------------------------------------
    @Autowired
    private LookupTypeRepository lookupTypeRepository;


    //----------------------------------------------------
    // Methods
    //----------------------------------------------------

    /**
     * This method is a REST method that maps a GET operation to lookupTypRepository
     * instance and calls extended JPArepository method findAll() and
     * returns a list of LookupType records
     * @return  - list of lookupType records
     */
    @GetMapping("/lookuptypes")
    public List<LookupType> getAllLookupTypes(){
        return lookupTypeRepository.findAll();
    }

    /**
     * This REST method maps a GET operation to a MongoLookupTypeRepository instance
     * and calls the JPA named query method: findByLookUpType defined in
     * MongoLookupTypeRepository and as a response to a server request returns
     * a LoookupType Record corresponding the passed ID attribute
     * @param lookupTypeId  - the id corresponding to the record to search for
     * @return              - LookupType record
     * @throws ResourceNotFoundException
     */
    @GetMapping("/lookuptypes/{id}")
    public ResponseEntity<LookupType> getLookUpTypeById(@PathVariable(value = "id") Long lookupTypeId) throws ResourceNotFoundException{
        LookupType lookupType = lookupTypeRepository.findById(lookupTypeId).orElseThrow(() -> new ResourceNotFoundException("Nothing Found for this ID"));
        return ResponseEntity.ok().body(lookupType);
    }

    /**
     * This REST method maps a GET Request to a MongoLookupTypeRepository instance
     * and calls the JPA Named Query Method: findByLookupType defined in
     * MongoLookupTypeRepository and as a response to a server request returns
     * a list of LookupType Records that have an attribute of LookupType
     * that matches the passed parameter
     * @param lookuptype    - the lookup type to search for
     * @return              - list of LookupType Records
     */
    @GetMapping("/lookuptypes/{type}")
    public List<LookupType> getLookupTypeByIdOrType(@PathVariable(value = "type") String lookuptype) {
        List<LookupType> lookupType = lookupTypeRepository.findByLookupType(lookuptype);
        return lookupType;
    }

    /**
     * This REST method maps a GET request to a MongoLookupTypeRepository instance
     * and calls the JPA named query method: findByLookupTypeIdOrLookupType defined
     * in MongoLookupTypeRepository and as a response to a server request returns a List
     * of LookupType records that match either one of the passed parameters
     * @param lookupTypeId  - the id to search for
     * @param lookuptype    - the type to search for
     * @return              - list of LookupType Records
     */
   @GetMapping("/lookuptypes/{id}/{type}")
    public List<LookupType> getLookupTypeByIdOrType(@PathVariable(value = "id") Long lookupTypeId, @PathVariable(value = "type") String lookuptype) {
        List<LookupType> lookupType = lookupTypeRepository.findByLookupTypeIdOrLookupType(lookupTypeId, lookuptype);
       return lookupType;
    }

    /**
     * This REST method maps a GET request to a MongoLookupTypeRepository instance
     * and calls the JPA Named Query Method: findByLookupTypeIdOrLookupType
     * defined in MongoLookupTypeRepository and as a response to a server request returns
     * a list of lookupType Records that match both of the passed parameters
     * @param lookupTypeId  - the id to search for
     * @param lookuptype    - the type to search for
     * @return              - the list of LookupType Records
     */
    @GetMapping("/lookuptype/{id}/{type}")
    public List<LookupType> getLookupTypeByIdAndType(@PathVariable(value = "id") Long lookupTypeId, @PathVariable(value = "type") String lookuptype) {
        List<LookupType> lookupType = lookupTypeRepository.findByLookupTypeIdAndLookupType(lookupTypeId, lookuptype);
        return lookupType;
    }


    @GetMapping("lookupsort/{filtercriteria}/lookups/{filtervalues}")
    @ResponseBody
    public List<LookupType> getClientByState(@PathVariable(value = "filtercriteria")List<Integer> criteriaAttributes,
                                         @PathVariable(value = "filtervalues")List<String> criteriaValues){

        List<LookupType> types = new ArrayList<LookupType>();

        for(int idx = 0; idx < criteriaAttributes.size(); idx++){

            switch(criteriaAttributes.get(idx)){

                case 1 : //lookupTypeId (long) (single)

                    types.add(lookupTypeRepository.findByLookupTypeId(Long.valueOf(criteriaValues.get(idx))));
                    break;

                case 2 : // findbyLookupType (str) (mult)

                    types.addAll(lookupTypeRepository.findByLookupType(criteriaValues.get(idx)));
                    break;

                default:    // print an error
                    System.out.println("\n*******************\nFehler...something went wrong!");
            }

        }

        return types;
    }

}// LookupTypeController Class
