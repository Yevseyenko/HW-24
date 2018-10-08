package com.epam.dataproviders;



import com.epam.util.parsers.XMLEmailParser;
import com.epam.util.parsers.XMLUserParser;
import org.testng.annotations.DataProvider;

import java.util.List;


public class UserEmail {


        @DataProvider(name = "usersData", parallel = true)
    public static Object[][] getUsersAndMessages() {
        XMLUserParser XMLUserParser = new XMLUserParser();
        XMLEmailParser XMLEmailParser = new XMLEmailParser();
        return generateArray(XMLUserParser.parseUserXML(), XMLEmailParser.parseEmailXML());
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
