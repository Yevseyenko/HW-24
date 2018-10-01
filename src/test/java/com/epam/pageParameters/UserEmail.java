package com.epam.pageParameters;

import org.testng.annotations.DataProvider;

import java.util.List;


public class UserEmail {
    @DataProvider(name = "usersData", parallel = true)
    public static Object[][] getUsersAndMessages() {
        UserParameters userParameters = new UserParameters();
        EmailParameters emailParameters = new EmailParameters();
        return generateArray(userParameters.parseUserXML(), emailParameters.parseEmailXML());
    }


    private static Object[][] generateArray(List userList, List messages) {
        Object[][] objArray = new Object[userList.size()][];
        for (int i = 0; i < userList.size(); i++) {
            objArray[i] = new Object[2];
            objArray[i][0] = userList.get(i);
            objArray[i][1] = messages.get(i);
        }
        return objArray;
    }

}
