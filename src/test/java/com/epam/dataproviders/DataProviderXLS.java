package com.epam.dataproviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;

import static com.epam.util.parsers.XLSEmailParser.getXLSEmail;
import static com.epam.util.parsers.XLSUserParser.getXLSUser;

public class DataProviderXLS {
    private static final Logger log = LogManager.getLogger("log4j2");
    @DataProvider(name = "usersXLSData", parallel = true)
    public static Object[][] getXLSUsersAndMessages() {
        Object [] users =getXLSUser();
        Object [] emails=getXLSEmail();
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
