package com.epam.util.parsers;

import com.epam.model.User;
import com.opencsv.CSVReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVUserParser {
    private static final Logger log = LogManager.getLogger("log4j2");
    private static User user;
    private static Object[] userCSV = new Object[5];
    private static CSVReader csvReader = null;
    private static String path = "src/main/resources/emailPassword.csv";

    private static void getUserCSVData() {
        int i = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            csvReader = new CSVReader(reader, ',');
            String[] line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                user = new User();
                user.setLogin(line[0]);
                user.setPassword(line[1]);
                userCSV[i] = user;
                i++;
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    public static Object[] getUserData() {
        getUserCSVData();
        return userCSV;
    }
}
