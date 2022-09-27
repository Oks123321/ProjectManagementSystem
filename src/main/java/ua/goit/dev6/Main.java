package ua.goit.dev6;


import ua.goit.dev6.config.DatabaseManagerConnector;
import ua.goit.dev6.config.PropertiesConfig;
import ua.goit.dev6.model.DeveloperDao;
import ua.goit.dev6.repository.DeveloperRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static ua.goit.dev6.model.DeveloperDao.Gender.female;
import static ua.goit.dev6.model.DeveloperDao.Gender.male;


public class Main {
    public static void main(String[] args) {
        String dbPassword = System.getenv("dbPassword");
        String dbUsername = System.getenv("dbUsername");
        PropertiesConfig propertiesConfig = new PropertiesConfig();
        Properties properties = propertiesConfig.loadProperties("application.properties");

        DatabaseManagerConnector manager = new DatabaseManagerConnector(properties, dbUsername, dbPassword);

        DeveloperRepository developerRepository = new DeveloperRepository(manager);
//        DeveloperDao developerDao = new DeveloperDao("Mary", "Poppins", 20, female);
//        developerRepository.save(developerDao);
        DeveloperDao developerDao = new DeveloperDao();
        System.out.println(developerRepository.findAll());
    }
}