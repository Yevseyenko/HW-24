package com.epam.dataproviders;

import jxl.common.Logger;

import org.testng.annotations.DataProvider;

import static com.epam.utils.parsers.CSVEmailParser.getEmailData;
import static com.epam.utils.parsers.CSVUserParser.getUserData;

public class DataProviderCSV {
    private static final Logger log = Logger.getLogger(DataProviderCSV.class);
    @DataProvider(name = "usersCSVData", parallel = true)
    public static Object[][] getCSVUsersAndMessages() {
        Object [] users =getUserData();
        Object [] emails=getEmailData();
        return generateArray(users, emails);
    }


    private static Object[][] generateArray(Object [] users, Object [] emails) {
        Object[][] objArray = new Object[users.length][];
        for (int i = 0; i < users.length; i++) {
            objArray[i] = new Object[2];
            objArray[i][0] = users[i];
            objArray[i][1] = emails[i];
        }
        return objArray;
    }
}
