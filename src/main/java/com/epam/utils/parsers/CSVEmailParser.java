package com.epam.utils.parsers;

import com.epam.model.Email;
import com.opencsv.CSVReader;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVEmailParser {
    private static final Logger log = Logger.getLogger(CSVEmailParser.class);
    private static Email email;
    private static Object[] emailCSV = null;
    private static CSVReader csvReader = null;
    private static String path = "src/main/resources/emailInfo.csv";

    private static void getUserCSVData() {
        int i = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            emailCSV = new Object[5];
            csvReader = new CSVReader(reader, ',');
            String[] line = csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                email = new Email();
                email.setReceiver(line[0]);
                email.setSubject(line[1]);
                email.setText(line[2]);
                emailCSV[i] = email;
                i++;
            }
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    public static Object[] getEmailData() {
        getUserCSVData();
        return emailCSV;
    }
}
