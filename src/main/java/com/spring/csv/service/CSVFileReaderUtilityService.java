package com.spring.csv.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.spring.csv.dataobject.ApplicationMigration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CSVFileReaderUtilityService {

    private static Logger LOGGER = LoggerFactory.getLogger(CSVFileReaderUtilityService.class);
    /**
     *  reads csv file from classpath, converts to Java object
     * @return
     */
    public List<ApplicationMigration> readSpringBootApplicationMigrationData(){

        List<ApplicationMigration> applicationMigrationList = new ArrayList<>();

        try {
            // file reader
            URL url = this.getClass().getClassLoader().getResource("SpringApplicationMigrationData.csv");
            File file = new File(url.getFile());
            Reader reader = new BufferedReader(new FileReader(file));

            // csv to object mapping strategy
            Map<String,String> columnMapping = new HashMap<>();
            columnMapping.put("application_id","applicationId");
            columnMapping.put("application_name","applicationName");
            columnMapping.put("migrated","migrated");

            HeaderColumnNameTranslateMappingStrategy mappingStrategy = new HeaderColumnNameTranslateMappingStrategy();
            mappingStrategy.setColumnMapping(columnMapping);
            mappingStrategy.setType(ApplicationMigration.class);

            // csv to bean conversion
            CsvToBean<ApplicationMigration> csvReader = new CsvToBeanBuilder(reader)
                    .withType(ApplicationMigration.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withMappingStrategy(mappingStrategy)
                    .build();

            applicationMigrationList = csvReader.parse();

           LOGGER.info("Imported Application migration list : {}", applicationMigrationList);

        }catch (FileNotFoundException exp){
            exp.printStackTrace();
        }
        return applicationMigrationList;
    }
}
