package com.spring.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.spring.csv.dataobject.ApplicationMigration;
import com.spring.csv.dataobject.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringCsvReadApplication {

    public static void main(String[] args) {
		SpringApplication.run(SpringCsvReadApplication.class, args);

		// for local testing
//        readDataLineByLine("D:\\\\src\\\\StudentData.csv");
//        readSpringBootApplicationMigrationData();
    }

    public static void readDataLineByLine(String file) {

        try {

            Reader reader = new BufferedReader(new FileReader(file));

            Map<String, String> columnMapping = new HashMap<>();
            columnMapping.put("name", "name");
            columnMapping.put("rollno", "rollNumber");
            columnMapping.put("department", "department");
            columnMapping.put("result", "result");
            columnMapping.put("cgpa", "pointer");

            HeaderColumnNameTranslateMappingStrategy mappingStrategy = new HeaderColumnNameTranslateMappingStrategy();
            mappingStrategy.setColumnMapping(columnMapping);
            mappingStrategy.setType(Student.class);

            CsvToBean<Student> csvReader = new CsvToBeanBuilder(reader)
                    .withType(Student.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withMappingStrategy(mappingStrategy)
                    .build();

            List<Student> results = csvReader.parse();

            results.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ApplicationMigration> readSpringBootApplicationMigrationData(){
        List<ApplicationMigration> results = null;
        try {

            Reader reader = new BufferedReader(new FileReader("D:\\src\\SpringApplicationMigrationData.csv"));

            Map<String,String> columnMapping = new HashMap<>();
            columnMapping.put("application_id","applicationId");
            columnMapping.put("application_name","applicationName");
            columnMapping.put("migrated","migrated");

            HeaderColumnNameTranslateMappingStrategy mappingStrategy = new HeaderColumnNameTranslateMappingStrategy();
            mappingStrategy.setColumnMapping(columnMapping);
            mappingStrategy.setType(ApplicationMigration.class);

            CsvToBean<ApplicationMigration> csvReader = new CsvToBeanBuilder(reader)
                    .withType(ApplicationMigration.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .withMappingStrategy(mappingStrategy)
                    .build();

            results = csvReader.parse();

            results.forEach(System.out::println);

        }catch (Exception exp){
            exp.printStackTrace();
        }
        return results;
    }

}
