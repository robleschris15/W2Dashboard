package com.gcucapstone.dashboard.services;

import com.gcucapstone.dashboard.entity.Carrier;
import com.gcucapstone.dashboard.entity.Client;
import com.gcucapstone.dashboard.entity.Vendor;
import com.gcucapstone.dashboard.repository.*;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * ------------------------------------------------------------------------
 * Authors:        | Chris Robles
 * Institution:    | Grand Canyon Universityx
 * Instructor:     | Dr. Isac Artzi
 * Date:           | (Created) 2-22-2023
 * File:           | CsvService.java
 * Version:        | 1.0
 * Description:    | This class will be used to write all the entities of the
 *                 | primary entities to a .CSV file. Vendor, Carrier, and CLient
 * ---------------------------------------------------------------------------
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dashboard/csvexport")
public class CsvService {

//----------------------------------------------------
// Class Variables
//----------------------------------------------------
@Autowired
private ClientRepository clientRepository;
    @Autowired
private VendorRepository vendorRepository;
    @Autowired
private CarrierRepository carrierRepository;
    @Autowired
private LookupTableRepository lookupTableRepository;
    @Autowired

private LookupTypeRepository lookupTypeRepository;

//----------------------------------------------------
// Methods
//----------------------------------------------------


    @GetMapping("/pcd/csvexport")
    public void exportCSV(HttpServletResponse response)
            throws Exception {

        //set file name and content type
        String filename = "dashboard-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");


        StatefulBeanToCsv<Vendor> writer1 = new StatefulBeanToCsvBuilder<Vendor>(response.getWriter()).withOrderedResults(true).build();
        writer1.write(vendorRepository.findAll());

        StatefulBeanToCsv<Carrier> writer2 = new StatefulBeanToCsvBuilder<Carrier>(response.getWriter()).withOrderedResults(true).build();
        writer2.write(carrierRepository.findAll());

        StatefulBeanToCsv<Client> writer3 = new StatefulBeanToCsvBuilder<Client>(response.getWriter()).withOrderedResults(true).build();
        writer3.write(clientRepository.findAll());

    }

}//CsvService
