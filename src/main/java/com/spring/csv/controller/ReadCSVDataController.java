package com.spring.csv.controller;

import com.spring.csv.dataobject.ApplicationMigration;
import com.spring.csv.service.CSVFileReaderUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/csv")
public class ReadCSVDataController {

    @Autowired
    private CSVFileReaderUtilityService csvFileReaderUtilityService;

    @RequestMapping(value = "/import", method = RequestMethod.GET)
    public List<ApplicationMigration> readCSVFileData(){
        List<ApplicationMigration> result = new ArrayList<>();
        return csvFileReaderUtilityService.readSpringBootApplicationMigrationData();
    }
}
